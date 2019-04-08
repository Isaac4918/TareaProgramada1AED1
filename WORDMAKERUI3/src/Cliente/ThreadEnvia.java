package Cliente;

import sample.Caso;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ThreadEnvia implements Runnable {
    private ObjectOutputStream salida;
    public static String mensaje;
    private Socket conexion;
    public static boolean ciclo=true;
    public static int valor=1;

    public ThreadEnvia(Socket conexion){
        this.conexion = conexion;

    }

    public void run(){
        try{
            while(ciclo) {
                salida = new ObjectOutputStream(conexion.getOutputStream());
                salida.writeObject(mensaje);
                System.out.println("Cliente Enviado>>> " + mensaje);
                salida.flush();

                if (valor<5){
                    valor++;
                }

                Thread.sleep(5000);
            }
        }catch (IOException ioException){
            ioException.printStackTrace();
        }catch (NullPointerException ex){

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
