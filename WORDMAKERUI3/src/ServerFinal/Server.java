package ServerFinal;

import Json.CreateJson;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

/**
 * This class implements java Socket server
 * @author pankaj
 *
 */
public class Server {

    //static ServerSocket variable
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 4999;
    public int codigo;
    public int modo;

    //1 partida creada
    //2 partida unida
    //3 contrasena
    //4 enviar json servidor
    //5 leer json servidor

    public static boolean servidorEschucha;
    public static boolean servidorHabla;
    public static int opcion = 1;
    public static String contrasena;
    public static String contrasenalocal;
    public static String message="";

    public Server() throws IOException, ClassNotFoundException {
        servidorHabla = true;
        servidorEschucha = true;
        //create the socket server object

        System.out.println("Server running");

        boolean ciclo = true;
        CreateJson cr = new CreateJson();
        String datajson = cr.getJSonValue();
        ObjectInputStream ois;
        ObjectOutputStream oos;
        var pool = Executors.newFixedThreadPool(500);
        server = new ServerSocket(port);

        //keep listens indefinitely until receives 'exit' call or program terminates
        while(ciclo){
            var socket = server.accept();

            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println(opcion);

            switch(opcion) {  //nulo
                case 1: //nulo
                    System.out.println("GuardarJson");
                    message = (String) ois.readObject();
                    System.out.println("Message Received:" + message + "jol" + socket.getInetAddress().getHostName());
                    oos.writeObject(socket.getInetAddress().getHostName());

                    break;
                case 2: //contrasena
                    String contrasenalocal = (String) ois.readObject();
                    if (contrasenalocal.equals(contrasena)) {
                        System.out.println("Contrasena correcta");
                        opcion = 3;
                    }

                    break;

                case 3: //enviar json
                    System.out.println("EnviarJson");
                    message = (String) ois.readObject();
                    System.out.println(datajson);
                    oos.writeObject(datajson);

                    break;

                case 5: //recibir json
                    System.out.println("GuardarJson");
                    message = (String) ois.readObject();
                    System.out.println("Message Received:" + null);
                    oos.writeObject(null);
                    break;

            }

            if (message.equals("DESKTOP-NGQ0AID")){
                System.out.println("hola baby");

            }


            ois.close();
            oos.close();
            socket.close();




        }
        System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
        server.close();
    }



}








