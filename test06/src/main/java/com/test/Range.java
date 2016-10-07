package com.test;

/**
 * Created by zjladmin on 2016/9/23.
 */
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
public class Range {
    private static int count = 0;
    //循环的次数
    private static int loopTime = 0;
    //保存结果的容器
    private static ArrayList ls = new ArrayList();

    public static void main(String[] args) {

        long l1 = Calendar.getInstance().getTimeInMillis();
        Integer[] result = new Integer[6];

        //输入的数组为 1, 2, 3, 4, 5 也可以为任意多数组
        ArrayList al = new ArrayList(6);
        al.add(new Integer(1));
        al.add(new Integer(2));
        al.add(new Integer(2));
        al.add(new Integer(3));
        al.add(new Integer(4));
        al.add(new Integer(5));

        //递规调用
        rotate(result, al, al.size());


        for(int i=0 ; i< ls.size(); i++){
            System.out.print("this is the " + ++count + " number: ");
            System.out.println(ls.get(i));
        }
        long l2 = Calendar.getInstance().getTimeInMillis();
        System.out.println("consume time seconds is: " + (l2-l1));
        System.out.println("loopTime is: " + loopTime);
    }
    //递规方法
    public static void rotate(Integer[] result, List al, int index){
        index = result.length - index;
        if(index == result.length-1){
            ++loopTime;
            result[index] = (Integer)al.get(0);
            organizeNum(result);
        }
        for (int s1 = 0; s1 < al.size(); s1++) {
            result[index] = (Integer)al.get(s1);
            ArrayList al1 = new ArrayList(al);
            al1.remove(result[index]);
            rotate(result, al1, al1.size());
        }
    }
    //加入容器
    public static void organizeNum(Integer[] result){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<result.length; i++){
            sb.append(result[i].toString());
        }
        String pstr = sb.toString();

        ls.add(pstr);

    }
}
