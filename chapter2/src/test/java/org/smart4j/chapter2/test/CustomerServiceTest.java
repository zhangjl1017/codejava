package org.smart4j.chapter2.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.smart4j.chapter2.helper.DatabaseHelper;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zjladmin on 2016/7/24.
 */
//CustomerService测试
public class CustomerServiceTest {
    final CustomerService customerService;

    public CustomerServiceTest() {
        customerService=new CustomerService();
    }

    @Before
    public void init() throws Exception{
        String file="sql/customer_init.sql";
        DatabaseHelper.executeSqlFile(file);
        /*
        InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
        BufferedReader reader =new BufferedReader(new InputStreamReader(is));
        String sql;
        while (sql=reader.readLine()!=null){
            DatabaseHelper.executeUpdate(sql);
        }
        */


    }

    @Test
    public void getCustomerListTest() throws Exception{
        List<Customer> customersList=customerService.getCustomerList();
        Assert.assertEquals(2,customersList.size());
    }

    @Test
    public void getCustomerTest()throws Exception{
        long id=1;
        Customer customer=customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomerTest() throws Exception{
        Map<String ,Object > fieldMap=new HashMap<String,Object>();
        fieldMap.put("name","customer100");
        fieldMap.put("contact","John");
        fieldMap.put("telephone","13512345678");
        boolean result=customerService.createCustomer(fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void updateCustomerTest() throws Exception{
        long id=1;
        Map<String,Object> fieldMap=new HashMap<String,Object>();
        fieldMap.put("contact","Eric");
        boolean result=customerService.updateCustomer(id,fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteCustomerTest() throws Exception{
        long id=1;
        boolean result=customerService.deleteCustomer(id);
        Assert.assertTrue(result);
    }
}
