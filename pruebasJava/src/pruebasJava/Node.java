package pruebasJava;

public class Node <T> {
	Node<T> next;
	Node<T> prev;
	T value;

	public Node(T value) {
		this.value = value;
	}
	
	public Node() {
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public Node<T> getPrev() {
		return prev;
	}
	
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
}
