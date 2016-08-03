package com.wiley.beginningspring.ch11;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zjladmin on 2016/8/3.
 */
public class UpdateUserTest {
    @Test
    public void updateUserWorksOK(){
        RestTemplate template=new RestTemplate();
        User user=new User(3,"Funda Caliskan");
        template.put("http://localhost:8080/rest/users/3",user);
    }

}
