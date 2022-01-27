package community_05.tcpDemo.tcp03;

import java.io.*;
import java.net.Socket;

public class SocketThread implements Runnable {

    private Socket s;

    public SocketThread(Socket s) {
        this.s=s;
    }

    @Override
    public void run() {
        //获取输入流
        BufferedReader reader= null;
        try {
            reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //把数据写入文件
            int count=0;
            File file=new File("src/main/java/community_05/tcpDemo/tcp03/writer["+count+"]txt");
            while (file.exists()){
                count++;
                file=new File("src/main/java/community_05/tcpDemo/tcp03/writer["+count+"].txt");
            }

            BufferedWriter writer=new BufferedWriter(new FileWriter(file));
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

            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
