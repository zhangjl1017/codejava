package com.test;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by zjladmin on 2016/9/29.
 */
public class Test05 {
    public static Vector<Integer> result=new Vector<>();

    public static void main(String[] args) {
        result.add(0);
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
            int n=in.nextInt();
            if(n<result.size())
            {
                System.out.println(result.get(n));
                continue;

            }
            else
            {
                for(int i=result.size();i<=n;i++)
                    result.add(result.get(i-1)+fun(i));
                System.out.println(result.get(n));
            }
        }


    }
    public static int fun(int n){
        String str=n+"";
        int num=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                num++;
            }
        }
        return num;

    }
}
