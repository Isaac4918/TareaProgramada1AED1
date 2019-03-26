package pruebasJava;

public class Matriz {
    private int size;
    private ListaEnlazada head;
    private ListaEnlazada tail;

    public Matriz(){
        this.head = new ListaEnlazada();
        this.tail = this.head;
        this.size = 0;
    }

    public boolean Vacia() {
        if(head == null) {
            return true;
        }
        return false;
    }

    public void add(ListaEnlazada Lista) {
        if(this.Vacia()) {
            this.head = Lista;
            this.tail = Lista;
        }
        else {
            this.tail.next = Lista;
            this.tail = Lista;
        }
        this.size++;
    }

    public ListaEnlazada indice(int num) throws Exception{
        ListaEnlazada tmp = this.head;
        int con = 0;
        if(this.size >= num) {
            while (con != num) {
                tmp = tmp.next;
                con ++;
            }
            return tmp;
        }
        else{
            throw new Exception("No hay ninguna lista en esa posición");
        }
    }
}
