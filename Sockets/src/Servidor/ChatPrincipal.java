package Servidor;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ChatPrincipal {

    private static ServerSocket servidor;



    public static void main(String[] args){

        ExecutorService executor =  Executors.newCachedThreadPool();

        try{
            servidor = new ServerSocket(4999, 100);
            System.out.println("Esperando Cliente...");

            while(true){
                try{
                    Socket conexion = servidor.accept();
                    System.out.println("Conectado a: "+conexion.getInetAddress().getHostName());

                    executor.execute(new ThreadRecibe(conexion));
                    executor.execute(new ThreadEnvia(conexion));
                }catch (IOException ex){
                    Logger.getLogger(ChatPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            executor.shutdown();
        }
    }
}
