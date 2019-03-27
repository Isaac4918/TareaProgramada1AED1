package Logica;

public class Letra {
    String letra;
    int valor;
    int cantidad;

    public Letra() {
    }

    public Letra(String letra, int valor, int cantidad) {
        this.letra = letra;
        this.valor = valor;
        this.cantidad = cantidad;
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
}
