package Cliente;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ChatPrincipalCliente {

    private static ServerSocket servidor;
    private static Socket cliente;
    private static String ip = "192.168.2.55";

    public ChatPrincipalCliente() {


        ExecutorService executor = Executors.newCachedThreadPool();
            try {
                System.out.println("Buscando Servidor...");
                cliente = new Socket(InetAddress.getByName(ip), 4999);

                System.out.println("Conectado a: " + cliente.getInetAddress().getHostName());

                executor.execute(new ThreadRecibe(cliente));
                executor.execute(new ThreadEnvia(cliente));
            } catch (IOException ex) {
                Logger.getLogger(ChatPrincipalCliente.class.getName()).log(Level.SEVERE, null, ex);

            } finally {

            }
            executor.shutdown();
        }
    }

