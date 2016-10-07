package com.test;

/**
 * Created by zjladmin on 2016/9/27.
 */
public class Test01 {
    public static void main(String[] args) {
        Integer a=Integer.parseInt("1");
        Integer b=Integer.parseInt("1");
        Integer c=Integer.parseInt("1000");
        Integer d=Integer.parseInt("1000");
        Integer e=new Integer(1);
        Integer f=new Integer(1);
        Integer x=1000;
        Integer y=1000;
        System.out.println(a==b);
        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(x==y);
    }
}
