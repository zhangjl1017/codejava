package com.wiley.beginningspring.ch11;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static sun.nio.cs.Surrogate.is;

/**
 * Created by zjladmin on 2016/8/3.
 */
public class ListUsersTest {
    @org.junit.Test
    public void listUsersWorksOK(){
        RestTemplate template=new RestTemplate();
        ResponseEntity<List> result=template.getForEntity("http://localhost:8080/rest/users",List.class);
        assertNotNull(result);
        assertNotNull(result.getBody());
        //assertThat(result.getBody().size(),is(2));
    }
}
