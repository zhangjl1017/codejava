package com.test;

import java.io.Serializable;
import java.util.*;

/**
 * Created by zjladmin on 2016/9/25.
 */
public class MainTree {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>();
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        treeMap.put("a", 1);
        treeMap.put("b", 2);
        treeMap.put("c", 3);
        treeMap.put("d", 4);
        treeMap.put("e", 5);
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("zjl");
        System.out.println(treeMap.subMap("c", "e"));
        System.out.println(treeMap.tailMap("d"));
        System.out.println(treeMap.values());
        ;
        System.out.println(treeMap.keySet());
        ;
        System.out.println(treeMap.get("c"));
        System.out.println(treeMap.entrySet());
        ;

        HashSet<Strudent> a = new HashSet<Strudent>();
        HashMap<Strudent, Integer> b = new HashMap<Strudent, Integer>();
        Strudent s = new Strudent("zjl", 12);
        a.add(s);
        b.put(s, s.age);
        s.age = 13;
        a.add(s);
        b.put(s, s.age);
        System.out.println(b.keySet());
        System.out.println("zjl".hashCode());
        System.out.println("123".hashCode());
    }
}
class Strudent implements Serializable {
    String id;
    String name;
    int age;

    Strudent(String name, int age) {
        this.name = name;
        this.age = age;

    }
    @Override
    public int hashCode(){
        return age%2;
    }
}

    /*
    @Override
    public int hashCode(){
        return age%2;
    }
    */

