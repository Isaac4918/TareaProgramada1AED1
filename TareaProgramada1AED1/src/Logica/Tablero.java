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

    public Tablero() {
        this.sizex = 15;
        this.sizey = 15;
        this.tablero = new Letra[15][15];
    }

    public void colocarLetra(Letra L1, int x, int y){
        if(this.tablero[y][x] == null){
            if(L1.cantidad > 0){
                this.tablero[y][x] = L1;
                L1.colocar();
                L1.setPosx(x);
                L1.setPosy(y);
            }
            else{
                System.err.println("Cantidad insuficiente de letras");
            }
        }
        else if(this.tablero[y][x] != null){
            System.err.println("Casilla ocupada");
        }
    }

    public void printTablero(){
        String linea = "";
        for(int i = 0; i<= this.sizex-1; i++){
            for(int j = 0; j<= this.sizey-1; j++){
                if(this.tablero[i][j] != null){
                    linea += "  ";
                    linea += (this.tablero[i][j]).getLetra();
                    linea += "  ";
                }
                else if(this.tablero[i][j] == null){
                    linea += this.tablero[i][j];
                    linea += " ";
                }
            }
            System.out.println(linea);
            linea = "";
        }
    }
/*
    public void revisar(Letra L1){

    }
*/

}
