package Cliente;

import javafx.scene.input.MouseEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ThreadEnvia implements Runnable {
    private final ChatPrincipalCliente main;
    private ObjectOutputStream salida;
    private String mensaje;
    private Socket conexion;
    public static ObjectOutputStream jsonenviar;

    public ThreadEnvia(Socket conexion, final ChatPrincipalCliente main){
        this.conexion = conexion;
        this.main = main;

    }



    public void run(){
        try{
            salida = new ObjectOutputStream(conexion.getOutputStream());
            salida.flush();

        }catch (IOException ioException){
            ioException.printStackTrace();
        }catch (NullPointerException ex){

        }
    }
    public static void sendmessageclient(){
        try {
            jsonenviar.writeObject("Pasar turno y enviar datos");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
        try {
            jsonenviar.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
