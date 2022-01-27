package community_05.udpDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UdpSendDemo {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket=new DatagramSocket();

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line=reader.readLine())!=null) {
            if (line.equals("000")){
                break;
            }
            byte[] bytes=line.getBytes();
            DatagramPacket packet=new DatagramPacket(bytes,bytes.length, InetAddress.getByName("192.168.0.104"),12345);
            socket.send(packet);
        }

        socket.close();

    }

}
