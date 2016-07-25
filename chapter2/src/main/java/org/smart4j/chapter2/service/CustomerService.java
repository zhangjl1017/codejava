package org.smart4j.chapter2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.helper.DatabaseHelper;
import org.smart4j.chapter2.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.sql.Connection;


/**
 * Created by zjladmin on 2016/7/24.
 * 提供客户数据服务
 */
public class CustomerService {
    private static final Logger LOGGER= LoggerFactory.getLogger(CustomerService.class);
    /*
    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;
    static {
        Properties conf= PropsUtil.loadProps("config.properties");
        DRIVER=conf.getProperty("jdbc.driver");
        URL=conf.getProperty("jdbc.url");
        USERNAME=conf.getProperty("jdbc.username");
        PASSWORD=conf.getProperty("jdbc.password");
        try{
            Class.forName(DRIVER);
        }catch(ClassNotFoundException e){
            LOGGER.error("can not load jdbc driver",e);
        }
    }
    */
    //获取客户列表
    public List<Customer> getCustomerList(){
        String sql="SELECT * FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class,sql);
        /*
        Connection conn=null;
        try{
            conn= DatabaseHelper.getConnection();

            List<Customer> customerList=new ArrayList<Customer>();
            String sql="SELECT * FROM customer";
            conn= DatabaseHelper.getConnection();
            PreparedStatement stmt=conn.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()){
                Customer customer=new Customer();
                customer.setID(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setContact(rs.getString("contact"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setRemark(rs.getString("remark"));
                customerList.add(customer);
            }
            return customerList;

            String sql="SELECT * FROM customer";
            return DatabaseHelper.queryEntityList(Customer.class,conn,sql);
        }
        catch(SQLException e){
            LOGGER.error("execute sql failure",e);
        }

        finally {
            DatabaseHelper.closeConnection(conn);
        }
        */
        //return  null;
    }


    //获取客户
    public Customer getCustomer(long id){
        return null;
    }

    //创建客户
    public boolean createCustomer(Map<String,Object> fieldMap){
        return DatabaseHelper.insertEntity(Customer.class,fieldMap);
    }

    //更新客户
    public boolean updateCustomer(long id,Map<String,Object> fieldMap){
        return DatabaseHelper.updateEntity(Customer.class,id,fieldMap);
    }

    //删除客户
    public boolean deleteCustomer(long id){
        return DatabaseHelper.deleteEntity(Customer.class,id);
    }


}
