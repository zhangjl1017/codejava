import java.util.Scanner;

/**
 * Created by zjladmin on 2016/9/4.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            double r=0.0;
            double d=n;
            for(int i=0;i<m;i++){
                r+=d;
                d=Math.sqrt(d);
            }
            //System.out.println(new java.text.DecimalFormat("#.00").format(r));
            String result = String .format("%.2f",r);
            System.out.println(result);
        }
        System.out.println("hello");
    }
}
