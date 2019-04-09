package Logica;

public class Juego {

    public Tablero tablero  = new Tablero();
    public Diccionario diccionario = new Diccionario();
    public Abecedario abc = new Abecedario();

    int puntaje1 = 0;
    int puntaje2 = 0;
    int puntaje3 = 0;
    int puntaje4 = 0;

    public Juego() {
    }

    public String buscaPalabra(Palabra word) throws Exception{
        String texto = "";
        if(word.len() == 1){
            String tV = "";
            String tH = "";
            tV = buscaVertical(word);
            tH = buscaHorizontal(word);
            if (tV.length() < tH.length()){
                texto = tH;
            }
            else if(tV.length() > tH.length()){
                texto = tV;
            }
        }else {
            int x1 = (word.Index(0)).getPosx();
            int y1 = (word.Index(0)).getPosy();
            int x2 = (word.Index(1)).getPosx();
            int y2 = (word.Index(1)).getPosy();
            if ((x1 -x2) == 0 & (y1 - y2) != 0){
                texto = buscaVertical(word);
            }
            if((x1 - x2) != 0 & (y1 - y2) == 0){
                texto = buscaHorizontal(word);
            }

        }
        return texto;
    }

    public String buscaHorizontal(Palabra word){
        String palabra = "";
        Letra L1 = word.getHead();
        int y = (L1.getPosy());
        int x = (L1.getPosx());
        while(this.tablero.tablero[x][y] != null){
            palabra += this.tablero.tablero[x][y].getLetra();
            x--;
        }
        int i = L1.getPosx() +1;
        while(this.tablero.tablero[i][y] != null){
            palabra += this.tablero.tablero[i][y].getLetra();
            i++;
        }















        return palabra;

    }

    public String buscaVertical(Palabra word){
        String palabra = "";

        return palabra;

    }
}
