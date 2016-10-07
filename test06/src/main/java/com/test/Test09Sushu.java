package com.test;

/**
 * Created by zjladmin on 2016/10/4.
 * 刷选法找素数
 */
public class Test09Sushu {
    public static void main(String[] args) {
        int[] a=new int[101];
        for(int i=1;i<101;i++)
            a[i]=1;
        for(int i=2;i<101;i++)
            if(a[i]!=0)
                for(int j=i+i;j<101;j+=i){
                        a[j]=0;
                }
        for(int i=2;i<101;i++)
            if(a[i]!=0)
                System.out.println(i);
    }


}
