import java.util.*;
/**
 * Created by zjladmin on 2016/9/9.
 */
public class Main16 {
    public static void main(String[] args) {
       Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            double result=0.0;
            result+=n;
            double temp=n;
            while (m-->1){
                result+=Math.sqrt(temp);
                temp=Math.sqrt(temp);
            }
            String str = String .format("%.2f",result);
            System.out.println(str);
        }
    }
}
