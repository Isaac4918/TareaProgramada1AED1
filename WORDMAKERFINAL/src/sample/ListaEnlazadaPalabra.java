package sample;

import Logica.*;

public class ListaEnlazadaPalabra {
    public static Letra first = null;
    public static Letra last = null;
    public int puntaje = 0;
    public int size= 0;



    public void add(Letra letra) {
        Letra l1= new Letra();
        if(this.isEmpty()) {
            this.first = letra;
            this.last = letra;
        }
        else {
            this.last.next = letra;
            this.last = letra;
        }
        this.puntaje += letra.getValor();
        this.size ++;
    }

    public Letra deleteTileValue() {
        Letra temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        Letra current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public Letra getFirst() {
        return this.first;
    }

    public void setFirst(Letra first) {
        this.first = first;
    }
}


