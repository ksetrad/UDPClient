import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.DatagramSocket;

/**
 * Created by idalov on 25.05.16.
 */
public class BroadcastClient {
    private InetAddress address;
    public byte[] buffer;
    public DatagramPacket packet;
    public DatagramSocket socket;

    public BroadcastClient() throws Exception{
        socket = new DatagramSocket(4567);
        socket.setReuseAddress(true);
        socket.setBroadcast(true);
        transmit();


    }

    private void transmit() {
        int i = 0;
        long Time = (long)System.currentTimeMillis();
        try {
            buffer = new byte[1481];
            packet = new DatagramPacket(buffer,buffer.length, InetAddress.getByName("0.0.0.0"),4568);
            while(true) {
                socket.receive(packet);
                    if(i++%100000 == 0)System.out.println("Total reseive: " + i +"time " +(System.currentTimeMillis()-Time));
            }
            } catch (Exception e) {
            e.printStackTrace();
        } finally {

            socket.close();
            System.out.println("Total: " + i + "packets");}

        }

    }



