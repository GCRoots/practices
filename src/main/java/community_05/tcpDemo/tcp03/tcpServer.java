package community_05.tcpDemo.tcp03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//多线程文件上传
public class tcpServer {

    public static void main(String[] args) throws IOException {

        ServerSocket ss=new ServerSocket(12345);

        while (true){
            //监听端口，等待客户端来连接
            Socket s=ss.accept();
            new Thread(new SocketThread(s)).start();
        }


    }

}
