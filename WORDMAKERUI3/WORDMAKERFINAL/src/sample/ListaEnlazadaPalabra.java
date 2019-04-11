package sample;

public class ListaEnlazadaPalabra<T extends Comparable> {
    private Node first = null;



    public void insertTileValue(T data) {
        Node n = new Node(data);
        n.next = first;
        first = n;
    }

    public Node deleteTileValue() {
        Node temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        Node current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return (first == null);
    }


}

class Node<T extends Comparable> {

    T data;
    public Node next;

    public Node(T data) {
        this.data = data;
    }
    public void displayNode() {
        System.out.print(data);
        System.out.print("  ");

    }


}
