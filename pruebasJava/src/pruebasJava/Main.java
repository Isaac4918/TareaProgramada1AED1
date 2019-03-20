package pruebasJava;


public class Main {

	public static void main(String[] args) {
		LinkedList Lista = new LinkedList();
		Lista.add(-10);
		Lista.add(2);
		Lista.add(3);
		Lista.add(4);
		Lista.add(5);
		Lista.add(6);
		Lista.add(7);
		Lista.add(8);
		Lista.print();
		Lista.deleUlti();
		System.out.println("Hola");
		Lista.add(100);
		Lista.print();
		System.out.println("Mayor:");
		System.out.println(Lista.mayor());
		System.out.println("Menor:");
		System.out.println(Lista.menor());
	} 

}
