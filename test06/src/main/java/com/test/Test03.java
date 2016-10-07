package com.test;

import java.util.Scanner;

/**
 * Created by zjladmin on 2016/9/28.
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int i=0;
        for(i=0;i<str.length();i++)
            if(str.charAt(i)!=' ')
                break;
        System.out.println(i);
        System.out.println(str.substring(i,str.length()));
    }
}
