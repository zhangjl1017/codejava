package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by zjladmin on 2016/9/28.
 */
public class Test04 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String result="";
        int n=0;
        Stack<String> stack=new Stack<String>();

        boolean bo=false;
        int c=sc.nextInt();
        BufferedReader bfin=new BufferedReader(new InputStreamReader(System.in));
        while (c-->0){
            String str="";
            try{
                str=bfin.readLine();
            }catch (IOException e){}
            int i=0;
            for(i=0;i<str.length();i++)
                if(str.charAt(i)!=' ')
                    break;

            if(i==n){
                if(bo)
                    result+=",";
                result+=str.substring(i,str.length());
            }
            else if(i>n){
                n=i;
                result+="("+str.substring(i,str.length());
                bo=true;
            }else{
                result+="),"+str.substring(i,str.length());
                n=i;
                bo=false;
            }
        }
        while (n-->0)
            result+=")";
        System.out.println(result);
        }

    }
