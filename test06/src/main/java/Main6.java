/**
 * Created by zjladmin on 2016/9/5.
 */
/*
Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){

        }
 */
import java.io.*;
import java.util.*;

public class Main6 {
    static int[] data={0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4,1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,2,3,3,4,3,4,4,5,3,4,4,5,4,5,5,6,1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,2,3,3,4,3,4,4,5,3,4,4,5,4,5,5,6,2,3,3,4,3,4,4,5,3,4,4,5,4,5,5,6,3,4,4,5,4,5,5,6,4,5,5,6,5,6,6,7,1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,2,3,3,4,3,4,4,5,3,4,4,5,4,5,5,6,2,3,3,4,3,4,4,5,3,4,4,5,4,5,5,6,3,4,4,5,4,5,5,6,4,5,5,6,5,6,6,7,2,3,3,4,3,4,4,5,3,4,4,5,4,5,5,6,3,4,4,5,4,5,5,6,4,5,5,6,5,6,6,7,3,4,4,5,4,5,5,6,4,5,5,6,5,6,6,7,4,5,5,6,5,6,6,7,5,6,6,7,6,7,7,8};
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while (n-->0){
            int t=sc.nextInt();
            int count=0;
            for(int i=1;i<=t;i++){
                if(f(i)==g(i)){
                    System.out.println(i);
                count++;}
            }
            System.out.println("count");
            System.out.print(count);
        }
    }
    public static int f(int n){
        int sum=0;
        int t=n;
        while (t>0){
            sum+=t%10;
            t/=10;
        }
        return sum;
    }
    public static int g(int n){
        int sum=0;
        int t=n;
        while (t>0){
            sum+=data[t%256];
            t/=256;
        }
        return sum;
    }
}
