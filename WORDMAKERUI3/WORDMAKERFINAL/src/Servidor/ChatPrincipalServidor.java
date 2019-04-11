package Servidor;

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

public class ChatPrincipalServidor extends JFrame{
    public JTextField campoTexto;
    public JTextArea areaTexto;
    private static ServerSocket servidor;
    private static String ip = "192.168.2.55";
    public static String [] nombrejugadores;
    public static String [] compujugadores;
    public static int contrasena;



    public static ChatPrincipalServidor main;

    public int servernum=0;
    public static int numerodejugadores;

    public ChatPrincipalServidor(){
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

    public void mostrarMensaje(String mensaje){
        areaTexto.append(mensaje + "\n");
    }

    public void habilitarTexto(boolean editable){
        campoTexto.setEditable(editable);
    }

    public static void main(String [] args){
        ChatPrincipalServidor main = new ChatPrincipalServidor();
        main.setLocationRelativeTo(null);
        Codigo codigo=new Codigo();
        contrasena=codigo.generarCodigo();
        System.out.println("La contrasena es: "+contrasena);
        JOptionPane.showMessageDialog(null,"La contrasena es: "+contrasena);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ExecutorService executor =  Executors.newCachedThreadPool();
        numerodejugadores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de jugadores"));
        while (numerodejugadores==1) {
            numerodejugadores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de jugadores mayor que 1"));
        }
        nombrejugadores = new String[numerodejugadores];
        compujugadores = new String[numerodejugadores];
        ArrayList<Object> object = new ArrayList<Object>();
        try{
            servidor = new ServerSocket(4999, 100);
            main.mostrarMensaje("Esperando Cliente...");
            boolean ciclo=true;


            while(ciclo){
                try {
                    int conexionnum = main.servernum + 1;
                    main.servernum = conexionnum;
                    Socket conexion = servidor.accept();
                    boolean lleno=false;

                    main.mostrarMensaje("Conectado a: " + String.valueOf(conexionnum));
                    System.out.println("Conexion"+conexion.getInetAddress().getHostName());

                    boolean esta = false;

                    object.add(conexion);
                    if(object.size()==numerodejugadores){
                        ciclo=false;
                        System.out.println("Termino");
                    }
                    else{
                        System.out.println("Ingrese contrasena");
                    }


                    main.habilitarTexto(true);

                    System.out.println(object.size());

                }catch (IOException ex){
                    Logger.getLogger(ChatPrincipalServidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

                executor.execute(new ThreadRecibe(object, main,numerodejugadores,contrasena));
                executor.execute(new ThreadEnvia(object, main,numerodejugadores,contrasena));
                System.out.println(object.get(0));
                System.out.println(object.get(1));
        } catch (IOException ex) {
            Logger.getLogger(ChatPrincipalServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            executor.shutdown();
        }
    }
}
