package Cliente;

import Json.CreateJson;
import sample.Controller1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadRecibeyEnvia<T extends Comparable> implements Runnable {

    private  final ChatPrincipalCliente main;
    private Object mensaje;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    public static ObjectOutputStream salida1;
    private Socket cliente;
    public String[] contrasenaarray;
    public int contrasena=1;
    public String contrasenareal;
    public static ObjectOutputStream enviar;
    ArrayList lista;


    public static Socket client1;
    public static boolean ButtonPresionado;



    public ThreadRecibeyEnvia(Socket cliente, final ChatPrincipalCliente main) throws IOException {
        this.cliente = cliente;
        this.main = main;
        this.client1=cliente;

        Frame f=new Frame("Button");
        Button b=new Button("Pasar turno");
        b.setBounds(0,0,200,200);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Enviar mensaje");
                enviarDatos();
            }
        });
        f.add(b);
        f.setSize(200,200);
        f.setLayout(null);
        f.setVisible(true);

    }


    private void enviarDatos(){
        lista=Controller1.listaPalabras();
        CreateJson.crearjson(lista);
        try{
            salida = new ObjectOutputStream(cliente.getOutputStream());
            salida.writeObject(lista.toString());
            salida.flush();
            main.mostrarMensaje("Enviar Json al servidor");
        }catch (IOException ioException){
            main.mostrarMensaje("Error escribiendo Mensaje ");
        }
    }


    public void run() {
        do{
            try{
                entrada = new ObjectInputStream(cliente.getInputStream());
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
                    salida = new ObjectOutputStream(cliente.getOutputStream());
                    salida.writeObject("COntrasena encviada correctamente del cliente");
                    salida.flush();
                    try {
                        System.out.println("iniciar partida");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }

                if (mensaje instanceof String) {
                    System.out.println("Json");
                    main.mostrarMensaje("mensaje y siguiente turno");
                    salida = new ObjectOutputStream(cliente.getOutputStream());
                    salida.writeObject("Siguiente turno");
                    salida.flush();
                }

            }catch (SocketException ex){

            }catch(EOFException eofException){
                main.mostrarMensaje("Fin de la conexión");
                break;
            }
            catch(IOException ex){
                Logger.getLogger(ThreadRecibeyEnvia.class.getName()).log(Level.SEVERE, null, ex);
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
