package Servidor;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import  java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ThreadEnvia implements Runnable {
    private ObjectOutputStream salida;
    private String mensaje;
    private Socket conexion;

    public ThreadEnvia(Socket conexion) throws IOException {
        this.conexion = conexion;
        mensaje=JOptionPane.showInputDialog("Digite el mensaje");

        enviarDatos(mensaje);
    }

    private void enviarDatos(String mensaje) throws IOException {
        //ObjectOutputStream s = new ObjectOutputStream();
        try {
            salida.writeObject("Servidor>>> " + mensaje);
            salida.flush();

        } catch (IOException ioException) {

        }
        salida.close();
    }


    public void run() {
        try {
            salida = new ObjectOutputStream(conexion.getOutputStream());
            salida.flush();
        } catch (SocketException ex) {

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }catch (NullPointerException ex){

        }
    }
}
