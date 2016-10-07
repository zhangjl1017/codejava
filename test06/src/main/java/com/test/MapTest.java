package com.test;

/**
 * Created by zjladmin on 2016/9/23.
 */
import java.util.*;
public class MapTest {
    Vector<int[]> v = new Vector<int[]>();
    Vector<Integer> vv = new Vector<Integer>();
    MapTest() {
        int[] array = { 1, 2, 3, 4, 5 };
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        pro(array, 0, x);
        for(int i=0;i<v.size();i++){
            int[] r=v.get(i);
            for(int j=0;j<r.length;j++){
                System.out.print(""+r[j]+",");
            }
            System.out.println();
        }
    }
    public void pro(int[] a, int start, int n) {
        if (n == 0) {
            int[] r = new int[vv.size()];
            for (int i = 0; i < r.length; i++) {
                r[i] = vv.get(i);
            }
            v.add(r);
            return;
        }
        if (start >= a.length) {
            return;
        }
        for (int i = start; i < a.length; i++) {
            vv.add(a[i]);
            pro(a, i + 1, n - 1);
            vv.remove(vv.size()-1);
        }
    }
    public static void main(String arg[]) {
        new MapTest();
    }
}