package pruebasJava;

public class LinkedList extends Node {
	int lenght;
	Node head;
	Node tail;
	
	public LinkedList() {
	}
	
	public boolean isEmpty() {
		if(head == null) {
			return true;
		}
		return false;
	}
	
	public void add(int num) {
		Node newNode = new Node(num);
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
			System.out.println(tmp.getNum());
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

	public int mayor() {
		Node tmp = this.head;
		if(this.isEmpty()) {
			System.out.println("La lista está vacía");
		}
		int May = tmp.getNum();
		while(tmp != null) {
			if(tmp.getNum() > May){
				May = tmp.getNum();
			}
			else {
				tmp = tmp.next;
			}
		}
		return May;
	}
	
	public int menor() {
		Node tmp = this.head;
		if(this.isEmpty()) {
			System.out.println("La lista está vacía");
		}
		int Min = tmp.getNum();
		while(tmp != null) {
			if(tmp.getNum() < Min){
				Min = tmp.getNum();
			}
			else {
				tmp = tmp.next;
			}
		}
		return Min;
	}
}
