package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zjladmin on 2016/10/4.
 */
public class Test07Quanzuhe {
    public static void main(String[] args) {
        String[] data=new String[]{"1","2","3","4"};
        listAll(Arrays.asList(data),"");
    }
    public static void listAll(List candidate, String prefix){
        System.out.println(prefix);
        for(int i=0;i<candidate.size();i++){
            List temp=new LinkedList(candidate);
            listAll(temp,prefix+temp.remove(i));
        }

    }
}
