package EstructurasDeDatos;

public class ListaLetra extends Letra {
    private int size;
    private Letra head;
    private Letra tail;
    ListaLetra next;

    public ListaLetra() {
        this.head = new Letra();
        this.tail = this.head;
        this.size = 15;
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
        this.size++;
    }

    public void insert(int index, Letra letra) throws Exception {
        Letra tmp = this.head;
        if(index > this.size){
            throw new Exception("Posición mayor a la capacidad de la Lista");
        }
        for(int i= 0; i < index-1; i++){
            tmp = tmp.next;
        }
        tmp.setNext(letra);
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

    public Letra Index(int num) throws Exception{
        Letra tmp = this.head;
        int cont = 0;
        if(this.size >= num) {
            while (cont != num) {
                tmp = tmp.next;
                cont ++;
            }
            return tmp;
        }
        else{
            throw new Exception("No hay ningun elemento en esa posición");
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

    public void setNext(ListaLetra next) {
        this.next = next;
    }
}
