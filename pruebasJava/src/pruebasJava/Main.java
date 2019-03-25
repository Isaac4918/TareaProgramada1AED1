package pruebasJava;


public class Main {

	public static void main(String[] args) throws Exception {
		ListaEnlazada<String> Lista1 = new ListaEnlazada<>();
		Lista1.insert(3,"A");
		Lista1.print();
		System.out.println("______________________");
		Lista1.insert(6, "Hola");
		Lista1.print();
		System.out.println("______________________");
		Lista1.insert(6, "Adiós");
		Lista1.print();
		/*
		Lista1.insert(10, "B");
		Lista1.print();
		System.out.println("Largo de la Lista:");
		System.out.println(Lista1.len());
		System.out.println("Prueba");
		System.out.println(Lista1.Index(5).getValue());
		*/


	} 

}
