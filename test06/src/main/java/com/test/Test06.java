package com.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zjladmin on 2016/10/3.
 */
public class Test06 {
    public static void main(String[] args) {
        int num=32;
        String str="aavzcadfdsfsdhshgwasdfasdfdddaaa";
        char[] chars=str.toCharArray();
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for(int i=0;i<chars.length;i++){
            if(hashMap.keySet().contains(chars[i])){
                hashMap.put(chars[i],hashMap.get(chars[i])+1);
            }else {
                hashMap.put(chars[i],0);
            }
        }
        Iterator<Map.Entry<Character,Integer>> it=hashMap.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Character,Integer> entry=it.next();
            System.out.println(entry.getKey()+"   "+entry.getValue());
        }
        System.out.println(num>>>32);
        System.out.println(num>>1);
        System.out.println(num>>>1);

    }
}
