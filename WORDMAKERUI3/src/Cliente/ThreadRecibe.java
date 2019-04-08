package Cliente;

import javax.swing.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadRecibe implements Runnable {
    private String mensaje;
    private ObjectInputStream entrada;
    private Socket cliente;
    public static boolean ciclo=true;
    public static boolean contrasenaingresada=false;

    public ThreadRecibe(Socket cliente) {
        this.cliente = cliente;
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
                if (!mensaje.equals(null)) {
                    System.out.println(mensaje);


                    if (mensaje.equals(cliente.getInetAddress().getHostName())) {
                        if (contrasenaingresada == false) {
                            ThreadEnvia.mensaje = JOptionPane.showInputDialog("Ingrese contrasena");

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
