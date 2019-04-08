package Ejecucion;


import Logica.Abecedario;
import Logica.Diccionario;
import Logica.Letra;
import Logica.Tablero;

public class Main {

	public static void main(String[] args) throws Exception {
        Tablero Tablero1 = new Tablero();
        Abecedario Abc = new Abecedario();
        Tablero1.printTablero();
        Tablero1.colocarLetra(Abc.H, 0, 0);
        Tablero1.colocarLetra(Abc.O, 1, 0);
        Tablero1.colocarLetra(Abc.L, 2, 0);
        Tablero1.colocarLetra(Abc.A, 3, 0);
        System.out.println("____________________________________________________________________________________________");
        Tablero1.printTablero();
        System.out.println("____________________________________________________________________________________________");
        System.out.println(Abc.A.getCantidad());
	}
}
