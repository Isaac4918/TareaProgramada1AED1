package Servidor;

import Logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatPrincipalServidor extends JFrame {
    public JTextField campoTexto;
    public JTextArea areaTexto;
    private static ServerSocket servidor;
    private static String ip = "192.168.43.100";
    public static String[] nombrejugadores;
    public static String[] compujugadores;
    public static int contrasena;

    public Tablero tablero = new Tablero();
    public Diccionario diccionario = new Diccionario();
    public Abecedario abc = new Abecedario();
    public int puntaje1 = 0;
    public int puntaje2 = 0;
    public int puntaje3 = 0;
    public int puntaje4 = 0;

    public int servernum = 0;
    public static int numerodejugadores;

    public ChatPrincipalServidor() {
        super("Servidor");
        campoTexto = new JTextField();
        campoTexto.setEditable(false);
        add(campoTexto, BorderLayout.NORTH);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        areaTexto.setBackground(Color.orange);
        areaTexto.setForeground(Color.BLACK);
        campoTexto.setForeground(Color.BLACK);

        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem salir = new JMenu("Salir");
        menuArchivo.add(salir);

        JMenuBar barra = new JMenuBar();
        setJMenuBar(barra);
        barra.add(menuArchivo);

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        setSize(300, 320);
        setVisible(true);
    }

    public void mostrarMensaje(String mensaje) {
        areaTexto.append(mensaje + "\n");
    }

    public void habilitarTexto(boolean editable) {
        campoTexto.setEditable(editable);
    }

    public static void inicio(ChatPrincipalServidor inicioServer) {
        //ChatPrincipalServidor inicioServer = new ChatPrincipalServidor();
        inicioServer.setLocationRelativeTo(null);
        Codigo codigo = new Codigo();
        contrasena = codigo.generarCodigo();
        System.out.println("La contrasena es: " + contrasena);
        JOptionPane.showMessageDialog(null, "La contrasena es: " + contrasena);
        inicioServer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ExecutorService executor = Executors.newCachedThreadPool();
        numerodejugadores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de jugadores"));

        nombrejugadores = new String[numerodejugadores];
        compujugadores = new String[numerodejugadores];
        ArrayList<Object> object = new ArrayList<Object>();
        try {
            servidor = new ServerSocket(4999, 100);
            inicioServer.mostrarMensaje("Esperando Cliente...");
            boolean ciclo = true;


            while (ciclo) {
                try {
                    int conexionnum = inicioServer.servernum + 1;
                    inicioServer.servernum = conexionnum;
                    Socket conexion = servidor.accept();
                    boolean lleno = false;

                    inicioServer.mostrarMensaje("Conectado a: " + String.valueOf(conexionnum));
                    System.out.println("Conexion" + conexion.getInetAddress().getHostName());

                    boolean esta = false;

                    object.add(conexion);
                    if (object.size() == numerodejugadores) {
                        ciclo = false;
                        System.out.println("Termino");
                    } else {
                        System.out.println("Ingrese contrasena");
                    }


                    inicioServer.habilitarTexto(true);

                    System.out.println(object.size());

                } catch (IOException ex) {
                    Logger.getLogger(ChatPrincipalServidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


            executor.execute(new ThreadEnviayRecibe(object, inicioServer, numerodejugadores, contrasena));

        } catch (IOException ex) {
            Logger.getLogger(ChatPrincipalServidor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            executor.shutdown();
        }
    }

    public boolean revisaPalabra(Palabra word, int jugador) {
        Letra tmp = word.getHead();
        String palabra = "";
        while (tmp != null) {
            palabra += tmp.getLetra();
            tmp = tmp.next;
        }
        if (jugador == 0 & this.diccionario.comparar(palabra)) {
            this.puntaje1 += word.puntaje;
        } else if (jugador == 1 & this.diccionario.comparar(palabra)) {
            this.puntaje2 += word.puntaje;
        } else if (jugador == 2 & this.diccionario.comparar(palabra)) {
            this.puntaje3 += word.puntaje;
        } else if (jugador == 3 & this.diccionario.comparar(palabra)) {
            this.puntaje4 += word.puntaje;
        }
        return this.diccionario.comparar(palabra);
    }

    public static Palabra convierteLista(Letra[] Lista) {
        Palabra p1 = new Palabra();
        for (int i = 0; i <= Lista.length; i++) {
            p1.add(Lista[i]);
        }
        return p1;
    }

    public void orientaPalabra(Palabra word) {
        Letra L1 = word.getHead();
        Letra L2 = L1.next;
        if (L1.getPosx() == L2.getPosx() & L1.getPosy() != L2.getPosy()) {
            this.revisaPalabra(this.buscaVertical(word), 0);
        } else if (L1.getPosx() != L2.getPosx() & L1.getPosy() == L2.getPosy()) {
            this.revisaPalabra(this.buscaHorizontal(word), 0);
        }
    }


    public Palabra buscaVertical(Palabra word) {
        Letra tmp = word.getHead();
        int posx = tmp.getPosx();
        int posy = tmp.getPosy();
        Letra puntero = this.tablero.tablero[posx][posy];
        Palabra p1 = new Palabra();
        while (puntero != null) {
            posy--;
            puntero = this.tablero.tablero[posx][posy];
        }
        while (puntero.getLetra() != null) {
            p1.add(puntero);
            posy++;
            puntero = this.tablero.tablero[posx][posy];
        }
        return p1;
    }

    public Palabra buscaHorizontal(Palabra word) {
        Letra tmp = word.getHead();
        int posx = tmp.getPosx();
        int posy = tmp.getPosy();
        Letra puntero1 = this.tablero.tablero[posx][posy];
        Palabra p2 = new Palabra();
        while (puntero1 != null) {
            posx--;
            puntero1 = this.tablero.tablero[posx][posy];
        }
        while (puntero1.getLetra() != null) {
            p2.add(puntero1);
            posx++;
            puntero1 = this.tablero.tablero[posx][posy];

        }
        return p2;
    }
}
