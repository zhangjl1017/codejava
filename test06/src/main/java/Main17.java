import java.util.Scanner;

/**
 * Created by zjladmin on 2016/9/18.
 */
public class Main17 {
    public static void main12(String[] args) {
        System.out.println('b'-'a');
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String strc="0123456789";
        while (scanner.hasNext()){
            String str= scanner.next();
            int temp=0;
            outer:
            while (temp<10){
                int a=strc.charAt(temp);
                int b=strc.charAt(temp+1);
                for(int i=temp+2;i<temp+b-a+1;i++){
                    char ctr=str.charAt(i);
                    if(a<ctr&&ctr<b)
                        continue;
                    else{
                        System.out.println("no");
                        break outer;
                    }
                }
                temp=temp+b-a+2;
            }
            if(temp>=10)
            System.out.println("yes");
        }
    }
}
