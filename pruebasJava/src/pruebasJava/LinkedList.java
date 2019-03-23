package pruebasJava;

public class LinkedList <T>{
	int lenght;
	Node<T> head;
	Node<T> tail;
	
	public LinkedList() {
	}
	
	public boolean isEmpty() {
		if(head == null) {
			return true;
		}
		return false;
	}
	
	public void add(T num) {
		Node<T> newNode = new Node<>(num);
		if(this.isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		}
		else { 
			this.tail.next = newNode;
			this.tail = newNode;
		}
		this.lenght ++;
	}
	
	public void print() {
		Node tmp = this.head;
		while(tmp != null) {
			System.out.println(tmp.getValue());
			tmp = tmp.next;
		}
	}
	
	public int len() {
		return this.lenght;
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
}
