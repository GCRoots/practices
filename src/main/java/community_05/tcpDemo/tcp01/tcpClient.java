package community_05.tcpDemo.tcp01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class tcpClient {

    public static void main(String[] args) throws IOException {

        Socket socket=new Socket("192.168.0.104",12345);

        //写数据
        OutputStream out=socket.getOutputStream();
        out.write("hello world".getBytes());

        //接受服务器反馈
        InputStream in=socket.getInputStream();
        byte[] bytes=new byte[1024];
        int len=in.read(bytes);
        String data=new String(bytes,0,len);
        System.out.println("Client:"+data);


        socket.close();


    }
}
