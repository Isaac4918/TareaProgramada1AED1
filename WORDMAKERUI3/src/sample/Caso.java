package sample;

import Json.CreateJson;
import Servidor.ChatPrincipalServidor;
import Servidor.ThreadEnvia;

import javax.swing.*;

public class Caso {
    public static String mensaje="";
    public static String number;
    public static CreateJson cr= new CreateJson();
    public static int valor;
    public static String CasoServer(){
        valor= Integer.parseInt(JOptionPane.showInputDialog("Ingrese valor al Servidor"));
        String jsondata=cr.getJSonValue();
        switch(valor){
        case 1: mensaje= number;  //numero de jugador
        break;
        case 2: mensaje= "Introducir contrasena"; //contrasena
        break;
        case 3: mensaje=jsondata; //json
        break;
        }
        return mensaje;


    }
    public static String CasoCliente(){
        valor= Integer.parseInt(JOptionPane.showInputDialog("Ingrese valor al Cliente"));

        String jsondata=cr.getJSonValue();
        switch(valor){
            case 1: mensaje= "HOLA";  //numero de jugador
                break;
            case 2:  mensaje= "Introducir contrasena";//contrasena
                break;
            case 3: mensaje=jsondata; //json
                break;
        }
        return mensaje;


    }

}
