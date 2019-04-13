package sample;

import Logica.Abecedario;
import Logica.*;
import Logica.Letra;

import java.util.ArrayList;

public class TilesCreator {
    private int tilevalue;

    public Letra generatetiles(Abecedario abc) {
        int pos=random();
        Letra tileletter = abc.ListaLetras[pos];
        if(abc.ListaLetras[pos].getCantidad() != 0) {
            System.out.println(abc.ListaLetras[pos].getCantidad());
            System.out.println("+++++++++++++++++++");
            System.out.println(tileletter.getLetra());
            System.out.println("+++++++++++++++++++");
            tileletter = abc.ListaLetras[pos];
            abc.ListaLetras[pos].colocar();
            System.out.println(abc.ListaLetras[pos].getCantidad());
        }else{
            this.generatetiles(abc);
        }
        return tileletter;
    }

    public int settilevalue(Letra tileletter){
        this.tilevalue = tileletter.getValor();
        return tileletter.getValor();


    }


    private int random(){
        return (int) (Math.random()*26);
        }
}
