package Servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import  java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;

public class ThreadEnvia implements Runnable {
    private final ChatPrincipalServidor main;
    private ObjectOutputStream salida;
    private String mensaje;
    private Socket conexion;
    private int clientnum;

    public ThreadEnvia(Socket conexion, final ChatPrincipalServidor main, int clientnum){
        this.conexion = conexion;
        this.main = main;
        this.clientnum=clientnum;

        main.campoTexto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                mensaje = event.getActionCommand();
                enviarDatos(mensaje);
                main.campoTexto.setText("");
            }
        });
    }

    private void enviarDatos(String mensaje){
        try{
            salida.writeObject("Servidor>>> "+mensaje);
            salida.flush();
            main.mostrarMensaje("Servidor>>> "+mensaje);
        }catch (IOException ioException){
            main.mostrarMensaje("Error escribiendo Mensaje");
        }
    }

    public void mostrarMensaje(String mensaje){
        main.areaTexto.append(mensaje);
    }

    public void run(){
        try{
            salida = new ObjectOutputStream(conexion.getOutputStream());
            salida.flush();
        }catch (SocketException ex){

        }catch (IOException ioException){
            ioException.printStackTrace();
        }catch (NullPointerException ex){

        }
    }
}
