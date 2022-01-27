package community_05.tcpDemo.tcp03;

import java.io.*;
import java.net.Socket;

public class tcpClient_file {
    public static void main(String[] args) throws IOException {

        Socket socket=new Socket("192.168.0.104",12345);

        //获取文本文件中的数据并发送
        BufferedReader reader=new BufferedReader(new FileReader("src/main/java/community_05/tcpDemo/tcp03/reader.txt"));
        //封装输出流对象
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line;
        while ((line=reader.readLine())!=null) {
            writer.write(line);
            writer.newLine();
            writer.flush();
        }

        //结束传输
        socket.shutdownOutput();

        //接受反馈
        BufferedReader back=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        line=back.readLine();
        System.out.println("Server:"+line);

        reader.close();
        writer.close();
        socket.close();


    }

}
