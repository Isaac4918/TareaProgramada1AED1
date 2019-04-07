package Logica;

public class Tablero {
    private int sizex;
    private int sizey;
    Letra[][] tablero;


    public Tablero(int sizex, int sizey) {
        this.sizex = sizex;
        this.sizey = sizey;
        this.tablero = new Letra[sizex][sizey];
    }

    public void colocarLetra(Letra L1, int x, int y) throws Exception{
        if(this.tablero[x][y] != null){
            if(L1.cantidad > 0){
                this.tablero[x][y] = L1;
                L1.colocar();
            }
            else{
                throw new Exception("Cantidad insuficiente de letras");
            }
        }
        else{
            throw new Exception("Casilla ocupada");
        }
    }





}
