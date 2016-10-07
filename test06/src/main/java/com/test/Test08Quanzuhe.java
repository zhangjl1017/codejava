package com.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zjladmin on 2016/10/4.
 */
public class Test08Quanzuhe {
    public static int count=0;
    public static void main(String[] args) {
        String[] data=new String[]{"1","2","2","3","4"};
        listAll(Arrays.asList(data),"");
        System.out.println("count "+count);
    }
    public static void listAll(List candidate, String prefix){
        count++;
        System.out.println(prefix);
        for(int i=0;i<candidate.size();i++){
            //if(i>0&&candidate.get(i)==candidate.get(i-1))
             //   continue;
            List temp=new LinkedList(candidate);
            listAll(temp,prefix+temp.remove(i));
        }

    }
}
