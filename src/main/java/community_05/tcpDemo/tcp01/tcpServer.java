package community_05.tcpDemo.tcp01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class tcpServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(12345);

        //监听端口，等待客户端来连接
        Socket s=ss.accept();

        //获取客户端发出的数据
        InputStream in=s.getInputStream();
        byte[] bytes=new byte[1024];
        int len=in.read(bytes);
        String data=new String(bytes,0,len);
        System.out.println("Server:"+data);

        //给出反馈
        OutputStream out=s.getOutputStream();
        out.write("Server Accepted.".getBytes());

        s.close();
        ss.close();

    }

}
