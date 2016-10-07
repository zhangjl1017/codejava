import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zjladmin on 2016/9/4.
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            //Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();

            Main3 m=new Main3();
            m.fu(n,sc);
        }
        System.out.println("hello");
    }
    void fu(int n,Scanner sc){
        int[] d=new int[n];
        for(int i=0;i<n;i++){
            d[i]=sc.nextInt();
        }
        ArrayList<Integer> result=new ArrayList<Integer>();
        Main3 m=new Main3();
        m.fun(0,d,0,n,0,result);
        Iterator<Integer> it=result.iterator();
        int max=0;
        while (it.hasNext()){
            if(max<it.next())
                max=it.next();
        }

        System.out.println(max);
    }
    void fun(Integer c, int[] d, int now, int n, int type,List result){
        if(now>=n){
            Integer i=c;
            result.add(i);
            return ;
        }
        fun(c, d, now+1,n,0,result);
        if(type==0){
            if(now<n)
            fun(c+d[now], d, now+1,n,type+1,result);
            if(now+1<n)
            fun(c+d[now]+d[now+1], d, now+2,n,type+2,result);
        }else if(type==1){
            if(now<n)
            fun(c+d[now], d, now+1,n,type+1,result);
        }else if(type==2){
            fun(c, d, now+1,n,type,result);
        }
    }
}
