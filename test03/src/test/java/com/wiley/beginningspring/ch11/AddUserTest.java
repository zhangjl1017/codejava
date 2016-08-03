package com.wiley.beginningspring.ch11;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by zjladmin on 2016/8/3.
 */
public class AddUserTest {
    @Test
    public void addUserWorksOK(){
        RestTemplate template=new RestTemplate();
        User user=new User(3,"Funda Bayulu");
        ResponseEntity<Void> resultSave=template.postForEntity("http://localhost:8080/rest/users",user,Void.class);
        assertNotNull(resultSave);
    }
}
