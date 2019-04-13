package sample;


import Json.CreateJson;
import Servidor.ChatPrincipalServidor;
import Cliente.ChatPrincipalCliente;
import javafx.scene.input.MouseEvent;

import java.sql.Time;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;


public class Controller extends Ui implements Runnable {
    Ui interfaz0=new Ui();
    Ui interfaz1=new Ui();

    public Controller1 cont1 = new Controller1();


    public int codigo=0;
    public static String codigoleido="";

    public void INTRO() throws Exception {
        interfaz0.newUI(0);

    }

    Thread t1=new Thread(){
        public void run() {
            ChatPrincipalServidor cs = new ChatPrincipalServidor();
            cs.inicio(cs);
            }

    };
    Thread t2=new Thread(){
        public void run() {
            ChatPrincipalCliente cc = new ChatPrincipalCliente();
            cc.mainClient(cc);
        }
    };




    public void CREATEPLAY(MouseEvent mouseEvent) throws Exception {
        PropertiesFile pr=new PropertiesFile();
        pr.crearProperties();
        pr.LeerProperties();
        t1.start();
        TimeUnit.SECONDS.sleep(5);
        t2.start();
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




