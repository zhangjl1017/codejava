package com.wiley.beginningspring.ch11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

/**
 * Created by jianleizhang on 2016/8/3.
 */
@RestController
@RequestMapping("/rest")
public class UserRestController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public void save(@RequestBody User user){
        userRepository.save(user);
    }
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> list(){
        return userRepository.findAll();
    }
    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public User get(@PathVariable("id") int id){
        return userRepository.find(id);
    }
    @RequestMapping(value = "/users/{id}",method = RequestMethod.PUT)
    public void update(@PathVariable("id") int id,@RequestBody User user){
        userRepository.update(id,user);
    }
    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id){
        userRepository.delete(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

}
