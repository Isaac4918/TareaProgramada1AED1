package Logica;

public class Palabra extends Letra {
    private int size;
    private Letra head;
    private Letra tail;
    public int puntaje;


    public Palabra() {
        this.head = null;
        this.tail = this.head;
        this.size = 0;
    }

    public boolean isEmpty() {
        if(head == null) {
            return true;
        }
        return false;
    }

    public void add(Letra letra) {
        if(this.isEmpty()) {
            this.head = letra;
            this.tail = letra;
        }
        else {
            this.tail.next = letra;
            this.tail = letra;
        }
        this.puntaje += letra.getValor();
        this.size ++;
    }

    public void insert(int index, Letra letra){
        Letra tmp = this.head;
        Letra L1 = new Letra("_", 0, 0);
        if(index > this.size){
            for(int j=0; j <= index; j++){
                this.add(L1);
            }
        }
        for(int i= 0; i < index-1; i++){
            tmp = tmp.next;
        }
        tmp.next = letra;
    }

    public void print() {
        Letra tmp = this.head;
        while(tmp != null) {
            System.out.println(tmp.getLetra());
            tmp = tmp.next;
        }
    }

    public int len() {
        return this.size;
    }

    public void deleUlti() {
        Letra tmp = this.head;
        if(this.isEmpty()) {
            System.out.println("La lista está vacía");
        }
        while(tmp.next.next != null) {
            tmp = tmp.next;
        }
        tmp.next = null;
        this.tail = tmp;
    }

    public Letra Index(int indice) throws Exception{
        Letra letra = this.head;
        int i = 0;
        if(this.size >= indice) {
            while (i != indice) {
                letra = letra.next;
                i ++;
            }
            return letra;
        }
        else{
            throw new Exception("No hay ninguna lista en esa posición");
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Letra getHead() {
        return head;
    }

    public void setHead(Letra head) {
        this.head = head;
    }

    public Letra getTail() {
        return tail;
    }

    public void setTail(Letra tail) {
        this.tail = tail;
    }

    public Letra getNext() {
        return next;
    }

    public void setNext(Palabra next) {
        this.next = next;
    }
}
