package Servidor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ChatPrincipalServidor extends JFrame{
    public JTextField campoTexto;
    public JTextArea areaTexto;
    private static ServerSocket servidor;
    private static String ip="172.26.33.79";



    public static ChatPrincipalServidor main;

    public int servernum=0;

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
            main.mostrarMensaje("Esperando Cliente...");

            while(true){
                try{
                    Socket conexion = servidor.accept();

                    int conexionnum= main.servernum +1;
                    main.servernum=conexionnum;
                    main.mostrarMensaje("Conectado a: "+ String.valueOf(conexionnum) );

                        main.habilitarTexto(true);

                        executor.execute(new ThreadRecibe(conexion, main,conexionnum));
                        executor.execute(new ThreadEnvia(conexion, main,conexionnum));

                }catch (IOException ex){
                    Logger.getLogger(ChatPrincipalServidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatPrincipalServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            executor.shutdown();
        }
    }
}
