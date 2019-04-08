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

    public ThreadRecibe(Socket cliente){
        this.cliente = cliente;
    }


    public void run() {
        try {
            entrada = new ObjectInputStream(cliente.getInputStream());
        }catch (IOException ex){
            Logger.getLogger(ThreadRecibe.class.getName()).log(Level.SEVERE, null, ex);
        }
        do{
            try{
                mensaje = (String)entrada.readObject();
                System.out.println(mensaje);
            }catch (SocketException ex){

            }catch(EOFException eofException){
            }
            catch(IOException ex){
                Logger.getLogger(ThreadRecibe.class.getName()).log(Level.SEVERE, null, ex);
            }catch (ClassNotFoundException classNotFoundException){
            }
        }while(!mensaje.equals("Servidor>>>TERMINATE"));
        try{
            entrada.close();
            cliente.close();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
        System.exit(0);
    }
}
