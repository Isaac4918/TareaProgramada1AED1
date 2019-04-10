package Servidor;

public class Codigo {

    public static int generarCodigo(){
        int codigo=0;
        for (int contador=0; contador<=9;contador++) {
            codigo += (int) (Math.random() * 10)*Math.pow(10,contador);
        }
        return codigo;
    }
}
