import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zjladmin on 2016/9/17.
 */
public class Main12 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int x=sc.nextInt();
            int n=sc.nextInt();
            int[] data=new int[n];
            for(int i=0;i<n;i++)
                data[i]=sc.nextInt();
            System.out.println(Arrays.binarySearch(data,x));
            //System.out.println(fun(0,n-1,data,x));
        }
    }
    public static int fun(int l,int r,int[] data,int key){
        if(l>r||l>=data.length||r<0) {
            return (-1)-l;
        }
        int temp=(l+r)/2;
        if(data[temp]==key) {
            return temp;
        }
        if(data[temp]>key){
            r=temp-1;
            return fun(l,r,data,key);
        }else{
            l=temp+1;
            return fun(l,r,data,key);
        }
    }
}
