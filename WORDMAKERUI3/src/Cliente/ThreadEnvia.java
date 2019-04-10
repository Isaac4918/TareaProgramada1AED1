package Cliente;

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

    public ThreadEnvia(Socket conexion, final ChatPrincipalCliente main){
        this.conexion = conexion;
        this.main = main;

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
            salida.writeObject("Cliente>>> "+mensaje);
            salida.flush();
            main.mostrarMensaje("Cliente>>> "+mensaje);
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

        }catch (IOException ioException){
            ioException.printStackTrace();
        }catch (NullPointerException ex){

        }
    }
}
