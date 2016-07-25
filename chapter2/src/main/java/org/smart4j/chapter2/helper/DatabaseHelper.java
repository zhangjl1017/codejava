package org.smart4j.chapter2.helper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;

import org.apache.commons.collections4.iterators.ObjectArrayIterator;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.util.CollectionUtil;
import org.smart4j.chapter2.util.PropsUtil;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by zjladmin on 2016/7/24.
 */
//数据库操作助手类
public final class DatabaseHelper {
    private static final Logger LOGGER= LoggerFactory.getLogger(DatabaseHelper.class);
    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    private static final QueryRunner QUERY_RUNNER;
    //private static final ThreadLocal<Connection> CONNECTION_THREAD_LOCAL=new ThreadLocal<Connection>();
    private static final ThreadLocal<Connection> CONNECTION_HOLDER;
    private static final BasicDataSource DATA_SOURCE;

    static {
        CONNECTION_HOLDER=new ThreadLocal<Connection>();
        QUERY_RUNNER=new QueryRunner();

        Properties conf= PropsUtil.loadProps("config.properties");
        DRIVER=conf.getProperty("jdbc.driver");
        URL =conf.getProperty("jdbc.url");
        USERNAME=conf.getProperty("jdbc.username");
        PASSWORD=conf.getProperty("jdbc.password");

        DATA_SOURCE=new BasicDataSource();
        DATA_SOURCE.setDriverClassName(DRIVER);
        DATA_SOURCE.setUrl(URL);
        DATA_SOURCE.setUsername(USERNAME);
        DATA_SOURCE.setPassword(PASSWORD);

/*
        try{
            Class.forName(DRIVER);
        }catch(ClassNotFoundException e){
            LOGGER.error("can not load jdbc driver",e);
        }
        */
    }
    //获取数据库连接
    public static Connection getConnection(){
        Connection conn=CONNECTION_HOLDER.get();
        if(conn==null){
            try{
                conn= DATA_SOURCE.getConnection();
            }catch (SQLException e){
                LOGGER.error("get connection failure",e);
                throw new RuntimeException(e);
            }finally {
                CONNECTION_HOLDER.set(conn);
            }
        }
        /*
        Connection conn=null;
        try{
            conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch (SQLException e){
            LOGGER.error("get connection failure",e);
        }
        */
        return conn;
    }

    //关闭数据库连接(使用连接池的话就不用了)
    public static void closeConnection(){
        Connection conn=CONNECTION_HOLDER.get();
        if(conn!=null){
            try{
                conn.close();
            }catch (SQLException e){
                LOGGER.error("close connection failure",e);
                throw new RuntimeException(e);
            }finally {
                CONNECTION_HOLDER.remove();
            }
        }
    }
    /*
    public static void closeConnection(Connection conn){
        if(conn!=null){
            try{
                conn.close();
            }catch (SQLException e){
                LOGGER.error("close connection failure",e);
            }
        }
    }*/

    //查询实体列表
    public static <T> List<T> queryEntityList(Class<T> entityClass,String sql){
        List<T> entityList;
        try{
            Connection conn=getConnection();
            entityList =QUERY_RUNNER.query(conn,sql,new BeanListHandler<T>(entityClass));
        }catch(SQLException e){
            LOGGER.error("query entity list failure",e);
            throw new RuntimeException(e);
        }finally {
           // closeConnection();
        }
        return  entityList;
    }
    /*
    public static <T> List<T> queryEntityList(Class<T> entityClass,Connection conn,String sql){
        List<T> entityList;
        try{
            entityList =QUERY_RUNNER.query(conn,sql,new BeanListHandler<T>(entityClass));
        }catch(SQLException e){
            LOGGER.error("query entity list failure",e);
            throw new RuntimeException(e);
        }finally {
            closeConnection(conn);
        }
        return  entityList;
    }*/
    //查询单个实体
    public static <T> T queryEntity(Class<T> entityClass,String sql){
        T entity;
        try{
            Connection conn=getConnection();
            entity=QUERY_RUNNER.query(conn,sql,new BeanHandler<T>(entityClass));
        }catch(SQLException e){
            LOGGER.error("query entity failure",e);
            throw new RuntimeException(e);
        }finally {
            //closeConnection();
        }
        return entity;
    }
    /**
     * 执行查询语句
     */
    public static List<Map<String,Object>> executeQuery(String sql){
        List<Map<String,Object>> result;
        try{
            Connection conn=getConnection();
            result=QUERY_RUNNER.query(conn,sql,new MapListHandler());
        }catch (SQLException e){
            LOGGER.error("execute query failure",e);
            throw new RuntimeException(e);
        }
        return result;
    }
    /**
     * 执行更新语句（包括update , insert , delete）
     */
    public static int executeUpdate(String sql,Object params){
        int rows=0;  //返回受影响的行数
        try{
            Connection conn=getConnection();
            rows=QUERY_RUNNER.update(conn,sql,params);
        }catch (SQLException e){
            LOGGER.error("execute update failure",e);
        }finally {
            //closeConnection();
        }
        return rows;
    }
    public static int executeUpdate(String sql){
        int rows=0;  //返回受影响的行数
        try{
            Connection conn=getConnection();
            rows=QUERY_RUNNER.update(conn,sql);
        }catch (SQLException e){
            LOGGER.error("execute update failure",e);
        }finally {
            //closeConnection();
        }
        return rows;
    }
    /**
     * 插入实体
     */
    public  static <T> boolean insertEntity(Class<T> entityClass,Map<String,Object>fieldMap){
        if(CollectionUtil.isEmpty(fieldMap)){
            LOGGER.error("can not insert entity: fieldMap is empty");
            return false;
        }
        String sql="INSERT INTO " + getTableName(entityClass);
        StringBuilder columns=new StringBuilder("(");
        StringBuilder values=new StringBuilder("(");
        for(String fieldName:fieldMap.keySet()){
            columns.append(fieldName).append(", ");
            values.append("?, ");
        }
        columns.replace(columns.lastIndexOf(", "),columns.length(),")");
        values.replace(values.lastIndexOf(", "),values.length(),")");
        sql+=columns+" VALUES " + values;

        Object[] params=fieldMap.values().toArray();
        return executeUpdate(sql,params)==1;
    }
    /**
     * 更新实体
     */
    public static <T> boolean updateEntity(Class<T> entityClass,long id,Map<String,Object> fieldMap){
        if(CollectionUtil.isEmpty(fieldMap)){
            LOGGER.error("can not update entity: fieldMap is empty");
            return false;
        }
        String sql="UPDATE " + getTableName(entityClass) + " SET ";
        StringBuilder columns=new StringBuilder();
        for(String fieldName : fieldMap.keySet()){
            columns.append(fieldName).append("=?, ");
        }
        sql+=columns.substring(0,columns.lastIndexOf(", "))+ " WHERE id=?";

        List<Object> paramList=new ArrayList<Object>();
        paramList.addAll(fieldMap.values());
        paramList.add(id);
        Object[] params=paramList.toArray();
        return executeUpdate(sql,params)==1;
    }
    /**
     * 删除实体
     */
    public static <T> boolean deleteEntity(Class<T> entityClass,long id){
        String sql="DELETE FROM "+getTableName(entityClass)+ " WHERE id=?";
        return executeUpdate(sql,id)==1;
    }

    private static String getTableName(Class<?> entityClass){
        return entityClass.getSimpleName();
    }
    /**
     * 执行SQL文件
     */
    public static void executeSqlFile(String filePath){

        InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
        BufferedReader reader =new BufferedReader(new InputStreamReader(is));
        try{
            String sql;
            while ((sql=reader.readLine())!=null){
                executeUpdate(sql);
            }
        }catch (Exception e){
            LOGGER.error("execute sql file failure",e);
            throw new RuntimeException(e);
        }
    }

}
