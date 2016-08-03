package com.wiley.beginningspring.ch11;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static sun.nio.cs.Surrogate.is;

/**
 * Created by zjladmin on 2016/8/3.
 */
public class DeleteUserTest {
    @Test
    public void deleteUserWorksOK(){
        RestTemplate template=new RestTemplate();
        template.delete("http://localhost:8080/rest/users/3");
        ResponseEntity<List> resultList=template.getForEntity("http://localhost:8080/rest/users",List.class);
        assertNotNull(resultList);
        assertNotNull(resultList.getBody());
        //assertThat(resultList.getBody().size(),is(2);
    }

}
