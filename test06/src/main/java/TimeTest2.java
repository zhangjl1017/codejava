import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by zjladmin on 2016/9/2.
 */
public class TimeTest2 {
    public static void main(String[] args) throws IOException{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        InputStream in=new FileInputStream("G:\\codejava\\test06\\src\\main\\resources\\conf.properties");
        Properties properties=new Properties();
        properties.load(in);
        int timeAdjust=Integer.parseInt(properties.getProperty("timeAdjust"));
        long s = date.getTime()+timeAdjust*1000;
        String strtemp=df.format(new Date(s));
        String tests [] = strtemp.split(" ");
        System.out.println(tests[1]);
        //Runtime.getRuntime().exec("cmd /c date 2013-05-06");//Windows 系统
        Runtime.getRuntime().exec("cmd /c time "+tests[1]);//Windows 系统
    }
}
