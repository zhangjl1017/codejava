import sun.text.normalizer.CharTrie;
import sun.text.normalizer.Trie;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjladmin on 2016/9/12.
 */
public class Main8 {
    public static void main(String[] args) throws IOException{
        ServerSocket ss=new ServerSocket(80);
        ServerSocket s=new ServerSocket();
        Socket socket=null;
        while((socket=ss.accept())!=null){
            new HTTPThread(socket).start();
        }
        ss.close();
    }
}
class HTTPThread extends Thread{
    private Socket socket;
    public HTTPThread(Socket socket){
        super();
        this.socket=socket;
    }
    public void run(){
        try{

            InputStream os=socket.getInputStream();
            StringBuffer sb=new StringBuffer(os.read());
            System.out.println(sb);

            /*
            OutputStream os=socket.getOutputStream();
            PrintWriter pw=new PrintWriter(os);
            pw.println("<html>");
            pw.println("<body>");
            pw.println("hello zjl");
            pw.println("</body>");
            pw.println("</html>");
            pw.flush();
            pw.close();
            socket.close();  */
        }catch (IOException e){
            System.out.println(e);
        }
    }
}

