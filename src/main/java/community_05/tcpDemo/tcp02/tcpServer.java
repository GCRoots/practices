package community_05.tcpDemo.tcp02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class tcpServer {

    public static void main(String[] args) throws IOException {

        ServerSocket ss=new ServerSocket(12345);

        //监听端口，等待客户端来连接
        Socket s=ss.accept();

        //获取输入流
        BufferedReader reader=new BufferedReader(new InputStreamReader(s.getInputStream()));
        //把数据写入文本文件
        BufferedWriter writer=new BufferedWriter(new FileWriter("src/main/java/community_05/tcpDemo/tcp02/writer.txt"));
        String line;
        while ((line=reader.readLine())!=null) {

            System.out.println(line);
            writer.write(line);
            writer.newLine();
            writer.flush();
        }

        //给出反馈
        BufferedWriter back=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        back.write("file uploaded.");
        back.newLine();
        back.flush();

        writer.close();
        ss.close();

    }

}
