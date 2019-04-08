package Servidor;

import sample.Caso;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import  java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;

public class ThreadEnvia implements Runnable {
    private ObjectOutputStream salida;
    private String mensaje;
    private Socket conexion;
    public static boolean ciclo=true;
    private int clientnum;
    public int modo;
    public static int numerodejugadores=0;
    public static int turno=0;
    public static String [] nombrejugadores;
    private String contrasena;
    public static boolean todascontrasenas=false;

    public ThreadEnvia(Socket conexion,String contrasena){
        this.conexion = conexion;
        this.clientnum=clientnum;
        this.modo=modo;
        this.contrasena=contrasena;

    }



    public void run(){
        boolean lleno= false;
        while (numerodejugadores==0){
            System.out.println("Ingrese numero de jugadores");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        nombrejugadores =new String[numerodejugadores];
        for (int i = 0; i <= nombrejugadores.length-1; i++) {
            nombrejugadores[i]="0";
        }
        JOptionPane.showMessageDialog(null,"La contraseña es: "+ contrasena);
        try{
            while (ciclo) {
                boolean esta= false;
                for(int i = 0; i <= nombrejugadores.length-1; i++) {
                    if (nombrejugadores[i]==conexion.getInetAddress().getHostName()){
                        esta=true;
                    }
                }

                if (esta==false) {
                    for (int i = 0; i <= nombrejugadores.length-1; i++) {

                        if (nombrejugadores[i].equals("0")) {

                            nombrejugadores[i] = conexion.getInetAddress().getHostName();
                            break;
                        }
                    }
                }

                if (lleno==false) {
                    if (nombrejugadores[numerodejugadores-1]!="0") {
                        lleno=true;
                        System.out.println("Estan todos los jugadores");
                    }
                }

                if (numerodejugadores-1<turno){
                    System.out.println("Todas las contrasenas ingresadas correctamente");
                    todascontrasenas=true;

                }

                if (lleno==true){
                    if (todascontrasenas==false){
                        salida = new ObjectOutputStream(conexion.getOutputStream());
                        salida.writeObject(nombrejugadores[turno]);
                        salida.flush();
                        Thread.sleep(5000);}
                    else{
                        System.out.println("Waiting");
                    }
                }








               /* salida = new ObjectOutputStream(conexion.getOutputStream());
                salida.writeObject(Integer.toString(numerodejugadores)+nombrejugadores[0]);
                salida.flush();
                Thread.sleep(5000);*/
            }

        }catch (SocketException ex){

        }catch (IOException ioException){
            ioException.printStackTrace();
        }catch (NullPointerException ex){

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
