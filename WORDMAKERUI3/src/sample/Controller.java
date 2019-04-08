package sample;


import ClienteFinal.Cliente;
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
            ThreadEnvia.numerodejugadores= Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de jugadores"));
        }
    };



    public void CREATEPLAY(MouseEvent mouseEvent) throws Exception {
        CreateJson cr = new CreateJson();
        cr.crearjson();
        System.out.println("CREATE PLAY");
        System.out.println("HOLA");
        t1.start();
        t2.start();
        t3.start();

        cont1.create();




    }









    public void JOINPLAY(MouseEvent mouseEvent) throws Exception {

        System.out.println("JOINING GAME");
        String codigoLeído=(JOptionPane.showInputDialog("Digite el códgo de invitación"));

        cont1.create();

        }


    @Override
    public void run() {
        System.out.println("rum");
    }
}




