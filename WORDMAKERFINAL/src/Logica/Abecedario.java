package Logica;

public class Abecedario {
    public Letra A = new Letra("a", 1, 12);public Letra B = new Letra("b", 3, 2);
    public Letra C = new Letra("c", 3, 4);public Letra D = new Letra("d", 2, 5);
    public Letra E = new Letra("e", 1, 12);public Letra F = new Letra("f", 4, 1);
    public Letra G = new Letra("g", 2, 2);public Letra H = new Letra("h", 4, 2);
    public Letra I = new Letra("i", 1, 6);public Letra J = new Letra("j", 8, 1);
    public Letra K = new Letra("k", 5, 1);public Letra L = new Letra("l", 1, 4);
    public Letra M = new Letra("m", 3, 2);public Letra N = new Letra("n", 1, 5);
    public Letra O = new Letra("o", 1, 9);public Letra P = new Letra("p", 3, 2);
    public Letra Q = new Letra("q", 5, 1);public Letra R = new Letra("r", 1, 6);
    public Letra T = new Letra("t", 1, 5);public Letra S = new Letra("s", 1, 4);
    public Letra U = new Letra("u", 1, 5);public Letra V = new Letra("v", 4, 1);
    public Letra W = new Letra("w", 3, 2);public Letra X = new Letra("x", 8, 1);
    public Letra Y = new Letra("y", 4, 1);public Letra Z = new Letra("z", 10, 1);
    public Letra Blanco  = new Letra("_", 0, 2);public Letra[] ListaLetras = new Letra[27];

    public Abecedario() {
        ListaLetras[0] = this.A;ListaLetras[1] = this.B;ListaLetras[2] = this.C;ListaLetras[3] = this.D;ListaLetras[4] = this.E;
        ListaLetras[5] = this.F;ListaLetras[6] = this.G;ListaLetras[7] = this.H;ListaLetras[8] = this.I;ListaLetras[9] = this.J;
        ListaLetras[10] = this.K;ListaLetras[11] = this.L;ListaLetras[12] = this.M;ListaLetras[13] = this.N;ListaLetras[14] = this.O;
        ListaLetras[15] = this.P;ListaLetras[16] = this.Q;ListaLetras[17] = this.R;ListaLetras[18] = this.S;ListaLetras[19] = this.T;
        ListaLetras[20] = this.U;ListaLetras[21] = this.V;ListaLetras[22] = this.W;ListaLetras[23] = this.X;ListaLetras[24] = this.Y;
        ListaLetras[25] = this.Z;ListaLetras[26] = this.Blanco;
    }

    public void reset(){
        this.A = new Letra("a", 1, 12);this.B = new Letra("b", 3, 2);
        this.C = new Letra("c", 3, 4);this.D = new Letra("d", 2, 5);
        this.E = new Letra("e", 1, 12);this.F = new Letra("f", 4, 1);
        this.G = new Letra("g", 2, 2);this.H = new Letra("h", 4, 2);
        this.I = new Letra("i", 1, 6);this.J = new Letra("j", 8, 1);
        this.K = new Letra("k", 5, 1);this.L = new Letra("l", 1, 4);
        this.M = new Letra("m", 3, 2);this.N = new Letra("n", 1, 5);
        this.O = new Letra("o", 1, 9);this.P = new Letra("p", 3, 2);
        this.Q = new Letra("q", 5, 1);this.R = new Letra("r", 1, 5);
        this.S = new Letra("s", 1, 6);this.T = new Letra("t", 1, 4);
        this.U = new Letra("u", 1, 5);this.V = new Letra("v", 4, 1);
        this.W = new Letra("w", 3, 2);this.X = new Letra("x", 8, 1);
        this.Y = new Letra("y", 4, 1);this.Z = new Letra("z", 10, 1);
        this.Blanco  = new Letra("_", 0, 2);
    }
}
