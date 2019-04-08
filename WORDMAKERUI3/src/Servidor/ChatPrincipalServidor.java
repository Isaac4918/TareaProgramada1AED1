package Servidor;

import Json.CreateJson;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ChatPrincipalServidor {

    private static ServerSocket servidor;
    private static String ip="192.168.2.55";
    public static int codigo;
    public static int numerodejugadores=2;
    public static String [] nombrejugadores;
    public static String contrasena;




    public static int servernum=0;
    public static String nameIP="";

    public ChatPrincipalServidor(){
        contrasena= String.valueOf(Codigo.generarCodigo());
        ExecutorService executor =  Executors.newCachedThreadPool();
        try{
            servidor = new ServerSocket(4999, 100);
            System.out.println("Esperando Cliente...");


            while(true){
                try{
                    Socket conexion = servidor.accept();

                    int conexionnum= servernum +1;
                    System.out.println("Conectado a: "+ String.valueOf(conexionnum ) );
                    nameIP=conexion.getInetAddress().getHostName();

                        executor.execute(new ThreadRecibe(conexion,contrasena));
                        executor.execute(new ThreadEnvia(conexion,contrasena));

                }catch (IOException ex){
                    Logger.getLogger(ChatPrincipalServidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatPrincipalServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            executor.shutdown();
        }
    }
}
