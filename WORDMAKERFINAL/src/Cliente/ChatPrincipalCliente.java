package Cliente;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatPrincipalCliente extends JFrame {
    public JTextField campoTexto;
    public JTextArea areaTexto;
    private static ServerSocket servidor;
    private static Socket cliente;
    private static String ip="192.168.43.100";

    public ChatPrincipalCliente(){
        super("Cliente");

        campoTexto = new JTextField();
        campoTexto.setEditable(false);
        add(campoTexto, BorderLayout.NORTH);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        areaTexto.setBackground(Color.orange);
        areaTexto.setForeground(Color.BLACK);

        JMenu menuArchivo = new JMenu("Archivo");
        JMenu salir = new JMenu("Salir");
        menuArchivo.add(salir);

        JMenuBar barra = new JMenuBar();
        setJMenuBar(barra);
        barra.add(menuArchivo);
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setSize(300, 320);
        setVisible(true);
    }

    public void mostrarMensaje(String mensaje){
        areaTexto.append(mensaje+"\n");
    }

    public void habilitarTexto(boolean editable){
        campoTexto.setEditable(editable);
    }

    public static void mainClient(ChatPrincipalCliente inicioCliente){
        inicioCliente.setLocationRelativeTo(null);
        inicioCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ExecutorService executor = Executors.newCachedThreadPool();
        try{
            inicioCliente.mostrarMensaje("Buscando Servidor...");
            cliente = new Socket(InetAddress.getByName(ip),4999);

            inicioCliente.mostrarMensaje("Conectado a: "+cliente.getInetAddress().getHostName());

            inicioCliente.habilitarTexto(true);

            executor.execute(new ThreadRecibeyEnvia(cliente, inicioCliente));
        }catch(IOException ex){
            Logger.getLogger(ChatPrincipalCliente.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

        }
        executor.shutdown();
    }
}
