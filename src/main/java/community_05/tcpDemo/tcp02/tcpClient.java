package community_05.tcpDemo.tcp02;

import java.io.*;
import java.net.Socket;

public class tcpClient {

    public static void main(String[] args) throws IOException {

        Socket socket=new Socket("192.168.0.104",12345);

        //键盘获取输入的数据并发送
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        //封装输出流对象
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line;
        while ((line=reader.readLine())!=null) {
            if (line.equals("000")){
                break;
            }
            writer.write(line);
            writer.newLine();
            writer.flush();

        }
        socket.shutdownOutput();

        socket.close();


    }
}
