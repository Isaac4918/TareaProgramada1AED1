package Logica;

public class Letra {
    String letra;
    int valor;
    int cantidad;
    int posx;
    int posy;
    Letra next;

    public Letra(String letra, int valor, int cantidad) {
        this.letra = letra;
        this.valor = valor;
        this.cantidad = cantidad;
    }

    public Letra() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getLetra() {
        return letra;
    }

    public int getValor() {
        return valor;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Letra getNext() {
        return next;
    }

    public void setNext(Letra next) {
        this.next = next;
    }

    public void colocar(){
        this.cantidad --;
    }

    public void devolver(){
        this.cantidad ++;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }
}
