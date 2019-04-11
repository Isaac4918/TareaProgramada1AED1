package Logica;

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
        if (jugador == 1){
            this.puntaje1 += word.puntaje;
        }
        else if (jugador == 2){
            this.puntaje2 += word.puntaje;
        }
        else if (jugador == 3){
            this.puntaje3 += word.puntaje;
        }
        else if (jugador == 4){
            this.puntaje4 += word.puntaje;
        }
        return this.diccionario.comparar(palabra);
    }

   //public Palabra convierteLista(){

    //}
/*
    public String buscaHorizontal(Palabra word){

    }



    public String buscaVertical(Palabra word){

    }*/
}
