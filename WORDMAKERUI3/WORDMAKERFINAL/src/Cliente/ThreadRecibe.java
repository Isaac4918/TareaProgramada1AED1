package Cliente;

import sample.Controller1;

import javax.swing.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadRecibe<T extends Comparable> implements Runnable {
    private  final ChatPrincipalCliente main;
    private Object mensaje;
    private ObjectInputStream entrada;
    private Socket cliente;
    public String[] contrasenaarray;
    public int contrasena=1;
    public String contrasenareal;


    public ThreadRecibe(Socket cliente, final ChatPrincipalCliente main){
        this.cliente = cliente;
        this.main = main;
    }


    public void run() {
        try {
            entrada = new ObjectInputStream(cliente.getInputStream());
        }catch (IOException ex){
            Logger.getLogger(ThreadRecibe.class.getName()).log(Level.SEVERE, null, ex);
        }
        do{
            try{
                mensaje = entrada.readObject();
                System.out.println(mensaje);

                if (mensaje instanceof String[]){
                    System.out.println("Ingrese contrasena");
                    contrasenaarray= (String[]) mensaje;
                    contrasenareal=contrasenaarray[1];
                    while(Integer.parseInt(contrasenareal)!=contrasena){
                        contrasena= Integer.parseInt(JOptionPane.showInputDialog("Ingrese contrasena"));
                    }
                    System.out.println("Contrasena correcta");
                    try {
                        System.out.println("iniciar partida");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
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
        }while(!mensaje.equals("Cliente>>>TERMINATE"));
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
