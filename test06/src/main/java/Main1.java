import java.math.BigInteger;
import java.util.*;
import java.io.*;

/**
 * Created by zjladmin on 2016/9/4.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while (n-->0){
            BigInteger big=sc.nextBigInteger();
            BigInteger b2=big.add(new BigInteger(String.valueOf(1)));
            String str=b2.toString(2);
            int i=1;

            while (i<str.length()){
                if(str.charAt(i)=='1')
                    System.out.print(7);
                else
                    System.out.print(4);
                i++;
            }
            System.out.println();

        }
    }
}
