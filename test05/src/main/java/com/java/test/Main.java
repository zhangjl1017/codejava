package com.java.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by zjladmin on 2016/8/31.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String aa="hel";
        Class class1=aa.getClass();
        Class class2=String.class;
        Class class3=Class.forName("java.lang.String");
        System.out.println(class1==class3);
        System.out.println(Integer.class==int.class);
        System.out.println(Integer.TYPE==int.class);
        System.out.println(class2.isPrimitive());
        System.out.println(int.class.isPrimitive());
        /*
        ArrayList arrayList=new ArrayList();
        Class alclass=arrayList.getClass();
        System.out.println(alclass);
        System.out.println(alclass.getName());
        Method[] methods=alclass.getMethods();
        for(Method method:methods){
            //System.out.println(method.getClass());
            System.out.println(method.getName());
        }
        */

        InputStream is=new FileInputStream("G:\\codejava\\test05\\src\\main\\resources\\conf.properties");
        Properties properties=new Properties();
        properties.load(is);
        int x1=Integer.parseInt(properties.getProperty("selfX1"));
        //int x2=Integer.valueOf(x1).intValue();
        System.out.println(x1);


        System.out.println("Hello World!");
    }
}
