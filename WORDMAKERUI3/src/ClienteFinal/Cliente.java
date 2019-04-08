package ClienteFinal;

import Json.CreateJson;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This class implements java socket client
 * @author pankaj
 *
 */
public class Cliente {
    public static boolean clienteEschucha;
    public static boolean clienteHabla;


    public Cliente() throws IOException, ClassNotFoundException, InterruptedException{
        //get the localhost IP address, if server is running on some other IP, you need to use that

        clienteEschucha=true;
        clienteHabla=true;
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        boolean ciclo=true;
        CreateJson cr =new CreateJson();
        String datajson=cr.getJSonValue();
        int i=1;


        while (ciclo){
            //establish socket connection to server
            socket = new Socket("192.168.2.55", 4999);
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());


            if (this.clienteHabla==true) {
                oos.writeObject(socket.getInetAddress().getHostName());
                //read the server response message
            }

            else{
                oos.writeObject(null);
            }

            if(this.clienteEschucha==true) {
                String message = (String) ois.readObject();
                System.out.println("Message: " + message+i +socket.getInetAddress().getHostName());
            }
            else {

            }

            i++;
            ois.close();
            oos.close();
            Thread.sleep(3000);

        }
    }

    public void changevalues(){
        clienteEschucha=false;
        clienteHabla=false;

    }
}