package EstructurasDeDatos;

public class Matriz {
    private int size;
    private ListaLetra head;
    private ListaLetra tail;

    public Matriz(){
        this.head = new ListaLetra();
        this.tail = this.head;
        this.size = 0;
    }

    public boolean Vacia() {
        if(head == null) {
            return true;
        }
        return false;
    }

    public void add(ListaLetra Lista) {
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

    public ListaLetra indice(int num) throws Exception{
        ListaLetra tmp = this.head;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ListaLetra getHead() {
        return head;
    }

    public void setHead(ListaLetra head) {
        this.head = head;
    }

    public ListaLetra getTail() {
        return tail;
    }

    public void setTail(ListaLetra tail) {
        this.tail = tail;
    }
}
