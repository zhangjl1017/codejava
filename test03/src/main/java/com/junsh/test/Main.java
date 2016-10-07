package com.junsh.test;

/**
 * Created by zjladmin on 2016/8/6.
 */
import java.util.*;

import static java.util.Arrays.sort;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n,temp=1,sum=0,s=0;
            n=in.nextInt();
            int[] data=new int[n];
            for(int i=0;i<n;i++){
                data[i]=in.nextInt();
            }
            Set<Vector<Integer>> re=new HashSet<Vector<Integer>>();
            Vector<Integer> result=new Vector<Integer>();
            for(int i=0;i<n;i++){
                result.add(data[i]);
                re.add(result);
            }
            for(Vector<Integer> r:re){
                for(int t:r){
                    temp*=t;
                    sum+=t;
                    if(sum>temp)
                        s++;
                }
                sum=0;
                temp=1;
            }
            System.out.println(s);
        }
    }
}