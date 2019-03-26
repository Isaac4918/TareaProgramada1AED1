package pruebasJava;

public class Node {
	Node next;
	String value;

	public Node() {
	}

	public Node(String value) {
		this.value = value;
	}

	public Node(String value, Node next){
		this.value = value;
		this.next= next;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}

	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
}
