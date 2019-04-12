package Servidor;

import Json.CreateJson;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class ThreadEnvia implements Runnable {
    private final ChatPrincipalServidor main;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private String mensaje;
    public static Socket conexion1;
    private int clientnum;
    private int numerodejugadores;
    public static int modo=1;
    private int contrasena;
    public static String[] arraycontrasena;
    public static  ArrayList<Object> object = new ArrayList<Object>();
    public static int turno=0;



    public ThreadEnvia(ArrayList<Object> conexion, final ChatPrincipalServidor main,int numerodejugadores,int contrasena){
        this.contrasena=contrasena;
        this.object = conexion;
        this.main = main;
        this.clientnum=clientnum;
        this.numerodejugadores=numerodejugadores;

    }


    public void run(){
        arraycontrasena=new String[2];
        try{

            while(true) {
                if (modo == 1) {
                    for (int i = 1; i < numerodejugadores; i++) {
                        arraycontrasena[0] = "contrasena";
                        arraycontrasena[1] = String.valueOf(contrasena);
                        Socket conexionvalue = (Socket) object.get(i);
                        salida = new ObjectOutputStream(conexionvalue.getOutputStream());
                        salida.writeObject(arraycontrasena);
                        salida.flush();
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    modo = 2;
                }

                for (int i = 1; i < numerodejugadores; i++) {

                    Socket conexionvalue1 = (Socket) object.get(1);
                    entrada = new ObjectInputStream(conexionvalue1.getInputStream());
                    mensaje = (String) entrada.readObject();
                    System.out.println(mensaje);
                    main.mostrarMensaje(mensaje);
                }


                //Mandar a un solo jugador en su turno
                if (modo == 2) {
                    CreateJson cr = new CreateJson();
                    cr.getJSonValue();
                    Socket conexionvalue = (Socket) object.get(turno);
                    salida = new ObjectOutputStream(conexionvalue.getOutputStream());
                    salida.writeObject("json");
                    salida.flush();
                    modo = 3;

                }

                //Mandar a todos los jugadores una actualizacion
                if (modo == 3) {
                    for (int i = 0; i < numerodejugadores; i++) {
                        CreateJson cr = new CreateJson();
                        cr.getJSonValue();
                        Socket conexionvalue = (Socket) object.get(i);
                        salida = new ObjectOutputStream(conexionvalue.getOutputStream());
                        salida.writeObject("Enviar json a todos");
                        salida.flush();
                    }
                    modo = 0;


                }

            }

        }catch (SocketException ex){

        }catch (IOException ioException){
            ioException.printStackTrace();
        }catch (NullPointerException ex){

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }}

