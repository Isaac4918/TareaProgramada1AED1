package pruebasJava;

public class Node <T> {
	Node  next;
	Node prev;
	T num;
	public Node(int num) {
		this.num = num;
	}
	
	public Node() {
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getPrev() {
		return prev;
	}
	
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
}
