import java.util.Scanner;

/**
 * Created by zjladmin on 2016/9/18.
 */
public class Main15 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int ret=0;
            while (n>0){
                ret+=n/5;
                n/=5;
            }
            System.out.println(ret);
        }
    }
}
