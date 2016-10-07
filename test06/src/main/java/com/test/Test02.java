package com.test;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by zjladmin on 2016/9/28.
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            int k=sc.nextInt();
            HashSet<Character> set=new HashSet<Character>();
            int max=0;
            for(int i=0;i<str.length();i++){
                int j=i;
                int temp=0;
                set.clear();
                while (j<str.length()&&set.size()<=k){

                    set.add(str.charAt(j));
                    if(set.size()<=k){
                        temp++;
                        if(temp>max)
                            max=temp;
                    }
                    j++;
                }
            }
            System.out.println(max);
        }
    }
}
