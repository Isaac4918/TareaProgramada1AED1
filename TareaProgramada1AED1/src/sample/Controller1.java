package sample;

import Cliente.ThreadRecibeyEnvia;
import javafx.scene.control.Button;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import Logica.*;

public class Controller1 {

    public Button Button1;
    public Rectangle tile1;
    public Text tileletter1;
    public Text tilevalue1;
    public Rectangle tile3;
    public Rectangle tile2;
    public Rectangle tile4;
    public Rectangle tile5;
    public Rectangle tile6;
    public Rectangle tile7;
    public Text tileletter3;
    public Text tilevalue3;
    public Text tileletter5;
    public Text tilevalue5;
    public Text tileletter7;
    public Text tilevalue7;
    public Text tileletter2;
    public Text tilevalue2;
    public Text tileletter4;
    public Text tilevalue4;
    public Text tileletter6;
    public Text tilevalue6;

    public boolean primeraLetra = true;

    public String savedtilevalue1;
    public String savedtilevalue2;
    public String savedtilevalue3;
    public String savedtilevalue4;
    public String savedtilevalue5;
    public String savedtilevalue6;
    public String savedtilevalue7;
    public Rectangle boardspace1;
    public Text boardtext1;
    public Rectangle textbox;
    public Text textSelection;
    public Text draggedvalue;
    public Rectangle draggedrect;
    public Text draggedtext;
    public AnchorPane pantalla;
    public GridPane grid;
    Ui interfaz1 = new Ui();

    public Rectangle boardtile;
    public Text boardtext;


    public Text source4;

    ListaEnlazadaPalabra linkedlist = new ListaEnlazadaPalabra();

    public static int primeraposx=141;

    public static int primeraposy=71;

    public static int separacionpalabras=55;

    public TilesCreator tl = new TilesCreator();

    public void create() throws Exception {
        interfaz1.newUI(1);
    }


    public void createTiles(MouseEvent mouseEvent) {
        Button1.setVisible(false);
        tileletter7.setOpacity(1);
        tile7.setOpacity(1);
        tileletter2.setOpacity(1);
        tileletter4.setOpacity(1);
        tileletter6.setOpacity(1);
        tilevalue7.setOpacity(1);
        System.out.println(tileletter1.getText());

        setTiles(tileletter1, tilevalue1);
        setTiles(tileletter2, tilevalue2);
        setTiles(tileletter3, tilevalue3);
        setTiles(tileletter4, tilevalue4);
        setTiles(tileletter5, tilevalue5);
        setTiles(tileletter6, tilevalue6);
        setTiles(tileletter7, tilevalue7);
        savetilevalue();


    }

    public void setTiles(Text tileletter, Text tilevalue) {
        tileletter.setText(tl.generatetiles());
        tilevalue.setText(String.valueOf(tl.settilevalue(tileletter.getText())));

    }


    public void tilehandler(MouseEvent mouseEvent) {
        Object a = mouseEvent.getSource();
        System.out.println(a.toString());
        dragger(a);
        draggedvalue.setVisible(true);


        mouseEvent.consume();

    }


    public void dragger(Object tile) {
        if (tile.equals(tile1) || tile.equals(tileletter1) || tile.equals(tilevalue1)) {
            initdrag(tile1, tileletter1);
            draggedrect = tile1;
            draggedtext = tileletter1;
            draggedvalue = tilevalue1;

        }
        if (tile.equals(tile2) || tile.equals(tileletter2) || tile.equals(tilevalue2)) {
            initdrag(tile2, tileletter2);
            draggedrect = tile2;
            draggedtext = tileletter2;
            draggedvalue = tilevalue2;
        }
        if (tile.equals(tile3) || tile.equals(tileletter3) || tile.equals(tilevalue3)) {
            initdrag(tile3, tileletter3);
            draggedrect = tile3;
            draggedtext = tileletter3;
            draggedvalue = tilevalue3;
        }
        if (tile.equals(tile4) || tile.equals(tileletter4) || tile.equals(tilevalue4)) {
            initdrag(tile4, tileletter4);
            draggedrect = tile4;
            draggedtext = tileletter4;
            draggedvalue = tilevalue4;
        }
        if (tile.equals(tile5) || tile.equals(tileletter5) || tile.equals(tilevalue5)) {
            initdrag(tile5, tileletter5);
            draggedrect = tile5;
            draggedtext = tileletter5;
            draggedvalue = tilevalue5;
        }
        if (tile.equals(tile6) || tile.equals(tileletter6) || tile.equals(tilevalue6)) {
            initdrag(tile6, tileletter6);
            draggedrect = tile6;
            draggedtext = tileletter6;
            draggedvalue = tilevalue6;
        }
        if (tile.equals(tile7) || tile.equals(tileletter7) || tile.equals(tilevalue7)) {
            initdrag(tile7, tileletter7);
            draggedrect = tile7;
            draggedtext = tileletter7;
            draggedvalue = tilevalue7;
        }

    }

    public void initdrag(Rectangle tile, Text tileletter) {
        Dragboard db = tile.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();

        cb.putString(tileletter.getText());
        db.setContent(cb);


    }


    public void savetilevalue() {
        savedtilevalue1 = tilevalue1.getText();
        savedtilevalue2 = tilevalue2.getText();
        savedtilevalue3 = tilevalue3.getText();
        savedtilevalue4 = tilevalue4.getText();
        savedtilevalue5 = tilevalue5.getText();
        savedtilevalue6 = tilevalue6.getText();
        savedtilevalue7 = tilevalue7.getText();
    }

    public void changeTiles(int numtileschanged) {

    }

    Thread Thread321= new Thread(() -> ThreadRecibeyEnvia.ButtonPresionado = true);

    public void submitButton(MouseEvent mouseEvent) throws IOException {

        System.out.println("Pulsado");
        Thread321.start();
        //ChatPrincipalCliente.enviarLista();
        listaPalabras();
        System.out.println("Pulsado 56");
    }

    public ArrayList listaPalabras(){
        Letra aux = linkedlist.first; //aux apunta al primero
        ArrayList listaPalabra = new ArrayList();
        while(aux!=null){
            listaPalabra.add(aux);
            aux=aux.getNext();
        }
        System.out.println("**************************************");
        System.out.println(listaPalabra);
        System.out.println("**************************************");
        return listaPalabra;
    }

    public void changeBoardtiles(DragEvent dragEvent) {
        if (dragEvent.getDragboard().hasString()) {
            dragEvent.acceptTransferModes(TransferMode.ANY);

        }

    }

    public void setBoardtile1(DragEvent dragEvent) {
        if (dragEvent.getSource() instanceof Rectangle) {

            boardtile = (Rectangle) dragEvent.getSource();


            if (primeraLetra == true) {


                if (boardtile.getLayoutX() >= 419 && boardtile.getLayoutX() <= 642 && boardtile.getLayoutY() == 456) {
                    mostrarLetras(dragEvent);
                    primeraLetra = false;

                } else {
                    JOptionPane.showMessageDialog(null, "Posición inválida. Coloque la ficha inicial en el centro del tablero.");


                }

            } else {
                mostrarLetras(dragEvent);
            }
        }
    }

    private void mostrarLetras(DragEvent dragEvent) {
        if (boardtile.getOpacity() == 0) {

            String str = dragEvent.getDragboard().getString();

            boardtile.setOpacity(1);

            texto(str, boardtile.getLayoutX(), boardtile.getLayoutY());

            draggedrect.setVisible(false);
            draggedvalue.setVisible(false);
            draggedtext.setVisible(false);
        }
    }


        public void bagDragOver (DragEvent dragEvent){
            if (dragEvent.getDragboard().hasString()) {
                dragEvent.acceptTransferModes(TransferMode.ANY);

            }


        }


        public void bagDragDropped (DragEvent dragEvent){

            setTiles(draggedtext, draggedvalue);
        }



    private void texto(String str, double layoutX, double layoutY) {
        boardtext1 = new Text();
        boardtext1.setVisible(true);
        boardtext1.setText(str);
        boardtext1.setX(layoutX + 15);
        boardtext1.setY(layoutY + 40);
        boardtext1.setFill(Color.BLACK);
        boardtext1.setFont(Font.font(null, FontWeight.BOLD, 36));



        int valorx= (int) (layoutX-primeraposx)/separacionpalabras;
        int valory= (int) (layoutY-primeraposy)/separacionpalabras;
        String unirletra=str;

        //this.linkedlist.add(unirletra,valorx,valory);
        System.out.println("-----");
        linkedlist.displayList();
        System.out.println("---");



        pantalla.getChildren().add(boardtext1);
    }


}




