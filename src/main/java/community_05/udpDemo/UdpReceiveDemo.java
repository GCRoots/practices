package community_05.udpDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceiveDemo {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket=new DatagramSocket(12345);

        while (true){
            byte[] bytes=new byte[1024];
            DatagramPacket packet=new DatagramPacket(bytes,bytes.length);

            socket.receive(packet);

            byte[] data=packet.getData();
            int len=packet.getLength();

            String dataString=new String(data,0,len);

            System.out.println(dataString);
        }

//        socket.close();

    }
}
