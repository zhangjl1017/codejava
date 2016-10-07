import java.util.Scanner;

/**
 * Created by zjladmin on 2016/9/18.
 */
public class Main14 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            double result=0;
            double temp=n;
            while (m-->0){
                result+=temp;
                temp=Math.sqrt(temp);
            }
            System.out.println(String.format("%.2f",result));
        }
    }
}
