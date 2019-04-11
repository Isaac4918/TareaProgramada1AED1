package Ejecucion;


import Logica.*;

public class Main {

	public static void main(String[] args) throws Exception {
        /*Tablero Tablero1 = new Tablero();
        Abecedario Abc = new Abecedario();
        //Tablero1.printTablero();
        Tablero1.colocarLetra(Abc.H, 0, 0);
        Tablero1.colocarLetra(Abc.O, 1, 0);
        Tablero1.colocarLetra(Abc.L, 2, 0);
        Tablero1.colocarLetra(Abc.A, 3, 0);
        System.out.println("____________________________________________________________________________________________");
        //Tablero1.printTablero();
        System.out.println("____________________________________________________________________________________________");
        //System.out.println(Abc.A.getCantidad());
        Palabra p1 = new Palabra();
        System.out.println(p1.Index(0).getLetra());*/

        Juego Scrabble = new Juego();
        Scrabble.abc.A.setPosy(14);
        Scrabble.abc.A.setPosx(14);
        Palabra p1 = new Palabra();

        Scrabble.abc.H.setPosx(6);
        Scrabble.abc.H.setPosy(7);
        Scrabble.abc.O.setPosx(7);
        Scrabble.abc.O.setPosy(7);
        Scrabble.abc.L.setPosx(8);
        Scrabble.abc.L.setPosy(7);
        Scrabble.abc.A.setPosx(9);
        Scrabble.abc.A.setPosy(7);
        Scrabble.tablero.colocarLetra(Scrabble.abc.H, Scrabble.abc.H.getPosx(), Scrabble.abc.H.getPosy() );
        p1.add(Scrabble.abc.H);
        Scrabble.tablero.colocarLetra(Scrabble.abc.O, Scrabble.abc.O.getPosx(), Scrabble.abc.O.getPosy() );
        p1.add(Scrabble.abc.O);
        Scrabble.tablero.colocarLetra(Scrabble.abc.L, Scrabble.abc.L.getPosx(), Scrabble.abc.L.getPosy() );
        p1.add(Scrabble.abc.L);
        Scrabble.tablero.colocarLetra(Scrabble.abc.A, Scrabble.abc.A.getPosx(), Scrabble.abc.A.getPosy() );
        p1.add(Scrabble.abc.A);
        Scrabble.tablero.printTablero();

        System.out.println("___________________________________");
        System.out.println(Scrabble.revisaPalabra(p1,1));
        System.out.println(Scrabble.puntaje1);


	}
}
