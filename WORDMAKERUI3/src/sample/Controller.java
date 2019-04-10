package sample;


import Json.CreateJson;
import Servidor.ChatPrincipalServidor;
import Cliente.ChatPrincipalCliente;
import Servidor.Codigo;
import Servidor.ThreadEnvia;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;


public class Controller extends Ui implements Runnable {
    Ui interfaz0=new Ui();
    Ui interfaz1=new Ui();
    Controller1 cont1 = new Controller1();
    public int codigo=0;
    public static String codigoleido="";

    public void INTRO() throws Exception {
        interfaz0.newUI(0);

    }
    Thread t1=new Thread(){
        public void run() {
            ChatPrincipalServidor cs = new ChatPrincipalServidor();
            }

    };
    Thread t2=new Thread(){
        public void run() {
            ChatPrincipalCliente cc = new ChatPrincipalCliente();
        }
    };
    Thread t3= new Thread(){
        public void run() {
        }
    };



    public void CREATEPLAY(MouseEvent mouseEvent) throws Exception {
        PropertiesFile pr=new PropertiesFile();
        pr.crearProperties();
        pr.LeerProperties();
        CreateJson cr = new CreateJson();
        cr.crearjson();
        System.out.println("CREATE PLAY");
        System.out.println("HOLA");



        cont1.create();




    }









    public void JOINPLAY(MouseEvent mouseEvent) throws Exception {

        System.out.println("JOINING GAME");

        cont1.create();

        }


    @Override
    public void run() {
        System.out.println("rum");
    }
}




