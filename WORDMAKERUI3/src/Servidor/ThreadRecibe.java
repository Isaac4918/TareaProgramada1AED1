package Servidor;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadRecibe implements Runnable {
    private String mensaje;
    private ObjectInputStream entrada;
    private Socket cliente;
    private int clientnum;
    private String contrasena;
    public static boolean ciclo=true;
    public static int modo=0;


    public ThreadRecibe(Socket cliente,String contrasena){
        this.cliente = cliente;
        this.clientnum=clientnum;
        this.contrasena=contrasena;
    }


    public void run() {


            try {
                while(ciclo) {
                    try {
                        entrada = new ObjectInputStream(cliente.getInputStream());
                    } catch (IOException ex) {
                        Logger.getLogger(ThreadRecibe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    mensaje = (String) entrada.readObject();
                    if (mensaje!=null) {
                        System.out.println(mensaje);


                        //modo contrasena
                        if (modo == 0) {
                            if (contrasena.equals(mensaje)) {
                                System.out.println("Contrasena correcta");
                                modo = 1;
                                ThreadEnvia.turno++;
                            }
                        }
                    }
                    Thread.sleep(5000);

                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }




    }

