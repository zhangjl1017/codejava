package com.test;

/**
 * Created by zjladmin on 2016/9/26.
 */
public class Test {
    public static void main(String[] args) {
        Student s=new Student();
        Test t=new Test();
        t.fun();
    }
    private void fun(){
        System.out.println("Hello");

    }
}
class Student{
    private void fun(){
        System.out.println("Hello world!");
    }
}
