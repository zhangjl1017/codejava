import java.util.Scanner;

/**
 * Created by zjladmin on 2016/9/17.
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            boolean ab=false;
            for(int i=n;i<=m;i++){
                if(fun(i)){
                    System.out.print(i);
                    ab=true;
                }
                if(ab)
                    System.out.print(" ");
            }
            if(ab==false)
                System.out.print("no");
            System.out.println();
        }
    }
    public static boolean fun(int n){
        int a=n%10;
        int b=n/10%10;
        int c=n/100;
        boolean bl=Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3)==n;
        return bl;
    }
}
