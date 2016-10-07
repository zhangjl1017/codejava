import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by zjladmin on 2016/9/16.
 */

public class Main9 {
    public static void main(String[] args) {
        File file = new File("G:\\学习资料\\数学建模0915\\2016试题\\2016赛题终\\B\\B题附件\\gene_info");
        ArrayList<String> arrayList=new ArrayList<String>();
        File[] files=file.listFiles();
        try {

            for(File f:files){
                FileReader fileReader=new FileReader(f);
                String str;
                BufferedReader bufferedReader=new BufferedReader(fileReader);
                while ((str=bufferedReader.readLine())!=null){
                    if("rs2273298".equals(str))
                        arrayList.add(f.getName());
                }
            }
        }catch (IOException e){
            System.out.println(e);
        }
        Iterator<String> iterator=arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
