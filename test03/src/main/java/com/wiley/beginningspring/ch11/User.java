package com.wiley.beginningspring.ch11;

/**
 * Created by jianleizhang on 2016/8/3.
 */
public class User {
    private int id;
    private String name;
    private User(){

    }
    public User(int id,String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
