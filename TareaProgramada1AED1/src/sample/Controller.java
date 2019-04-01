package sample;

import javafx.scene.input.MouseEvent;
import Servidor.ChatPrincipalServidor;
import Cliente.ChatPrincipalCliente;
import javax.swing.*;



public class Controller extends Ui {
    Ui interfaz0=new Ui();
    Ui interfaz1=new Ui();
    Controller1 cont1 = new Controller1();

    public void INTRO() throws Exception {
        interfaz0.newUI(0);

    }


    public void CREATEPLAY(MouseEvent mouseEvent) throws Exception {
        System.out.println("CREATE PLAY");

        System.out.println("HOLA");
        ChatPrincipalCliente.main();

        System.out.println("no");
        cont1.create();
        JOptionPane.showMessageDialog(null, );







    }




    public void JOINPLAY(MouseEvent mouseEvent) throws Exception {

        System.out.println("JOINING GAME");
        
        ChatPrincipalCliente.main();
        cont1.create();
    }
}
