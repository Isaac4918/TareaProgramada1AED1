package Logica;

import sample.*;

import java.util.ArrayList;

public class Juego {

    public Tablero tablero  = new Tablero();
    public Diccionario diccionario = new Diccionario();
    public Abecedario abc = new Abecedario();
    public int puntaje1 = 0;
    public int puntaje2 = 0;
    public int puntaje3 = 0;
    public int puntaje4 = 0;

    public Juego() {
    }

    public boolean revisaPalabra(Palabra word, int jugador){
        Letra tmp = word.getHead();
        String palabra = "";
        while(tmp != null){
            palabra += tmp.getLetra();
            tmp = tmp.next;
        }
        if (jugador == 1 & this.diccionario.comparar(palabra)){
            this.puntaje1 += word.puntaje;
        }
        else if (jugador == 2 & this.diccionario.comparar(palabra)){
            this.puntaje2 += word.puntaje;
        }
        else if (jugador == 3 & this.diccionario.comparar(palabra)){
            this.puntaje3 += word.puntaje;
        }
        else if (jugador == 4 & this.diccionario.comparar(palabra)){
            this.puntaje4 += word.puntaje;
        }
        return this.diccionario.comparar(palabra);
    }

   //public Palabra convierteLista(ArrayList Lista){

    //}

    public void orientaPalabra(Palabra word){
        Letra L1= word.getHead();
        Letra L2 = L1.next;
        if(L1.getPosx() == L2.getPosx() & L1.getPosy() != L2.getPosy()){
            this.buscaVertical(word);
        }
        else if(L1.getPosx() != L2.getPosx() & L1.getPosy() == L2.getPosy()){
            this.buscaHorizontal(word);
        }
    }



    public String buscaVertical(Palabra word){
        Letra tmp = word.getHead();
        int posx= tmp.getPosx();
        int posy = tmp.getPosy();
        Letra puntero = this.tablero.tablero[posx][posy];
        String p1= "";
        while (puntero != null){
            posy --;
            puntero = this.tablero.tablero[posx][posy];
        }
        while (puntero.getLetra() != null){
            p1 += puntero.getLetra();
            posy ++;
            puntero = this.tablero.tablero[posx][posy];
        }
        return p1;
    }

    public String buscaHorizontal(Palabra word){
        Letra tmp = word.getHead();
        int posx= tmp.getPosx();
        int posy = tmp.getPosy();
        Letra puntero1 = this.tablero.tablero[posx][posy];
        String p2= "";
        while (puntero1 != null){
            posx --;
            puntero1 = this.tablero.tablero[posx][posy];
        }
        while (puntero1.getLetra() != null) {
            p2 += puntero1.getLetra();
            posx ++;
            puntero1 = this.tablero.tablero[posx][posy];

        }
        return p2;
    }
}
