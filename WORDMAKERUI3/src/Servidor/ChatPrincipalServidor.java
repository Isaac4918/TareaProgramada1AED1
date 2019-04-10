package Servidor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatPrincipalServidor extends JFrame{
    public JTextField campoTexto;
    public JTextArea areaTexto;
    private static ServerSocket servidor;
    private static String ip = "192.168.2.55";
    public static Socket conexion;
    public static String [] nombrejugadores;
    public static String [] compujugadores;


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
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ExecutorService executor =  Executors.newCachedThreadPool();
        try{
            servidor = new ServerSocket(4999, 100);
            boolean lleno=false;
            main.mostrarMensaje("Esperando Cliente...");
            numerodejugadores= Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de jugadores"));
            boolean ciclo=true;
            nombrejugadores = new String[numerodejugadores];
            compujugadores = new String[numerodejugadores];


            for (int i = 0; i <= nombrejugadores.length - 1; i++) {
                compujugadores[i] = "0";
            }

            for (int i = 0; i <= nombrejugadores.length - 1; i++) {
                nombrejugadores[i] = "0";
            }


            while(ciclo){
                try{
                    conexion = servidor.accept();
                    int conexionnum= main.servernum +1;
                    main.servernum=conexionnum;
                    System.out.println(conexion.getInetAddress().getHostName());

                    boolean esta= false;

                    for(int i = 0; i <= compujugadores.length-1; i++) {
                        if (compujugadores[i].equals(conexion.getInetAddress().getHostName())){
                            esta=true;
                        }
                    }
                    if (esta==false) {
                        for (int i = 0; i <= compujugadores.length-1; i++) {
                            System.out.println("fsd");

                            if (compujugadores[i].equals("0")) {
                                System.out.println("me cago en");

                                compujugadores[i] = conexion.getInetAddress().getHostName();
                                break;
                            }
                        }
                    }

                    if (lleno==false) {
                        if (compujugadores[numerodejugadores-1]!="0") {
                            lleno=true;
                            System.out.println("Estan todos los jugadores");
                        }
                    }


                    if (conexionnum==1){
                        System.out.println("1");

                        main.mostrarMensaje("Conectado a: "+ String.valueOf(conexionnum) );


                        main.habilitarTexto(true);
                        ciclo=false;


                    }else if(conexionnum!=1){
                        System.out.println("2");

                        main.mostrarMensaje("Conectado a: "+ String.valueOf(conexionnum) );


                        main.habilitarTexto(true);


                    }
                    System.out.println(compujugadores[0]+compujugadores[1]);


                }catch (IOException ex){
                    Logger.getLogger(ChatPrincipalServidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            executor.execute(new ThreadRecibe(conexion, main,1));
            executor.execute(new ThreadEnvia(conexion, main,1));
        } catch (IOException ex) {
            Logger.getLogger(ChatPrincipalServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            executor.shutdown();
        }
    }
}
