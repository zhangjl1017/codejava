import java.io.*;
import java.util.*;

/**
 * Created by zjladmin on 2016/9/4.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            Integer d=sc.nextInt();
            if(d>=60000||d<10){
                System.out.println(d);
                continue;
            }
            String str=d.toString();
            char[] temp=str.toCharArray();
            char x=temp[0];
            for(int i=1;i<temp.length;i++){
                char y=temp[i];
                int a=y-'0';
                a=(a+6)%10;
                temp[i]=(char)(a+'0');
            }
            System.out.print(x);
            for(int i=temp.length-1;i>0;i--)
                System.out.print(temp[i]);
            System.out.println("\n");

        }
        System.out.println("hello");
    }
}
