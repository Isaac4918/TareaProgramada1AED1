package Ejecucion;


import EstructurasDeDatos.Matriz;
import EstructurasDeDatos.ListaLetra;
import EstructurasDeDatos.Letra;

public class Main {

	public static void main(String[] args) throws Exception {
		Matriz M1 =  new Matriz();
		ListaLetra tmp = M1.getHead();
		Letra L1= new Letra();
		for(int i=0; i <= 14; i ++){
			for(int j=0; j <= 15; j++){
				tmp.insert(j,L1);
			}
			M1.add(tmp);
		}
	}
}
