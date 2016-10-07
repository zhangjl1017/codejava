import java.util.LinkedList;
import java.util.List;

/**
 * Created by zjladmin on 2016/9/17.
 */
public class MainCycle {
    public static void main(String[] args) {
        System.out.println(fun(50,3));
    }
    public static int fun(int n,int k){
        List<Integer> list=new LinkedList<Integer>();
        for(int i=0;i<n;i++)
            list.add(i+1);
        int index=-1;
        while (list.size()>1){
            index=(index+3)%list.size();
            list.remove(index--);
        }
        return list.get(0);
    }
}
