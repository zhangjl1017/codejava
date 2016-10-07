import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zjladmin on 2016/9/4.
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int a=sc.nextInt();
            int b=sc.nextInt();
            List<Integer> list=new ArrayList<Integer>();
            for(int i=a;i<=b;i++){
                if(fun(i)){
                    list.add(i);
                }
            }
            if(list.size()==0){
                System.out.println("no");
            }else
            {
                Iterator<Integer> it=list.iterator();
                System.out.print(it.next());
                while (it.hasNext()){
                    System.out.print(" ");
                    System.out.print(it.next());
                }
            }
            System.out.println();
        }
    }
    static boolean fun(int n){
        int sum=0;
        int s=n;
        for(int i=0;i<3;i++){
            sum+=(s%10)*(s%10)*(s%10);
            s/=10;
        }
        if(sum==n)
            return true;
        else
            return false;
    }
}
