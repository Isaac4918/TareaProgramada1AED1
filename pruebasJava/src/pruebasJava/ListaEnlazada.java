package pruebasJava;

public class ListaEnlazada {
    private int size;
    private Node head;
    private Node tail;
    ListaEnlazada next;

    public ListaEnlazada() {
        this.head = new Node();
        this.tail = this.head;
        this.size = 0;
    }

    public boolean isEmpty() {
        if(head == null) {
            return true;
        }
        return false;
    }

    public void add(String value) {
        Node newNode = new Node(value);
        if(this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public void insert(int index, String value) throws Exception {
        Node tmp = this.head;
        if(index > this.size){
            throw new Exception("Posición mayor a la capacidad de la Lista");
        }
        for(int i= 0; i < index; i++){
            tmp = tmp.next;
        }
        tmp.setValue(value);
    }

    public void print() {
        Node tmp = this.head;
        while(tmp != null) {
            System.out.println(tmp.getValue());
            tmp = tmp.next;
        }
    }

    public int len() {
        return this.size;
    }

    public void deleUlti() {
        Node tmp = this.head;
        if(this.isEmpty()) {
            System.out.println("La lista está vacía");
        }
        while(tmp.next.next != null) {
            tmp = tmp.next;
        }
        tmp.next = null;
        this.tail = tmp;
    }

    public Node Index(int num) throws Exception{
        Node tmp = this.head;
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

    public ListaEnlazada getNext() {
        return next;
    }

    public void setNext(ListaEnlazada next) {
        this.next = next;
    }
}
