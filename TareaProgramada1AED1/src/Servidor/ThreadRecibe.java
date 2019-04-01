package Servidor;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadRecibe implements Runnable {
    private final ChatPrincipalServidor main;
    private String mensaje;
    private ObjectInputStream entrada;
    private Socket cliente;
    private int clientnum;

    public ThreadRecibe(Socket cliente, ChatPrincipalServidor main, int clientnum){
        this.cliente = cliente;
        this.main = main;
        this.clientnum=clientnum;
    }

    public void mostrarMensaje(String mensaje){
        main.areaTexto.append(mensaje); }

    public void run() {
        try {
            entrada = new ObjectInputStream(cliente.getInputStream());
        }catch (IOException ex){
            Logger.getLogger(ThreadRecibe.class.getName()).log(Level.SEVERE, null, ex);
        }
        do{
            try{
                mensaje = (String)entrada.readObject();
                main.mostrarMensaje(mensaje);

            }catch (SocketException ex){

            }catch(EOFException eofException){
                main.mostrarMensaje("Fin de la conexión");
                break;
            }
            catch(IOException ex){
                Logger.getLogger(ThreadRecibe.class.getName()).log(Level.SEVERE, null, ex);
            }catch (ClassNotFoundException classNotFoundException){
                main.mostrarMensaje("Objeto desconocido");
            }
        }while(!mensaje.equals("Servidor>>>TERMINATE"));
        try{
            entrada.close();
            cliente.close();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
        main.mostrarMensaje("Fin de la conexión");
        System.exit(0);
    }
}
