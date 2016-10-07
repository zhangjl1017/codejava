/**
 * Created by zjladmin on 2016/9/18.
 */
public class Mainquanpailie {
    public static void main(String[] args) {
        int[] a={1,2,3};
        cal(a,0,2);
    }

    public static void cal(int[] a,int n,int m) {
        if(n==m){
            for(int i=0;i<=m;i++)
                System.out.print(a[i]+" ");
            System.out.println();
        }else {
            for(int i=n;i<=m;i++){

                swap(a,i,n);
                cal(a,n+1,m);
                swap(a,i,n);
            }
        }
    }

    public static void swap(int[] a,int n,int m) {
        int temp=a[n];
        a[n]=a[m];
        a[m]=temp;
    }
}
