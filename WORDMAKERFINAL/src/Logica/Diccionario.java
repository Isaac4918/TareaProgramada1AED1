package Logica;

import java.io.BufferedReader;
import java.io.FileReader;

public class Diccionario {

    private String direccion = "C:\\Users\\Kevin Alanis\\Desktop\\New folder (5)\\WORDMAKERFINAL\\src\\Diccionario.txt";

    public Diccionario() {
    }

   /* public Diccionario(String direccion) {
        this.direccion = direccion;
    }*/


    public Boolean comparar(String palabra){
        boolean result = false;
        try{
            BufferedReader bf = new BufferedReader(new FileReader(this.direccion));
            String bfRead = bf.readLine();
            while(bfRead != null) {
                if(bfRead.equals(palabra)){
                    result = true;
                    break;
                }
                System.out.println(bfRead);
                bfRead = bf.readLine();
            }
        }catch(Exception e) {
            System.err.println("No se encontró archivo");
        }
        return result;
    }
}
