package Servidor;

import java.util.Random;

public class Codigo {

    public static int generarCodigo(){
        int codigo=0;
        codigo = (int)Math.floor(Math.random()*(999-100+1)+100);
        return codigo;
    }
}