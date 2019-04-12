package sample;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {
    public void crearProperties() {

        Properties prop = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream("config.properties");

            // set the properties value
            prop.setProperty("IP", "10.233.129.213");
            prop.setProperty("Puerto del Servidor", "4999");
            prop.setProperty("Telefono experto en palabras", "(+506)87654321");

            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    public void LeerProperties(){
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("IP"));
            System.out.println(prop.getProperty("Puerto del Servidor"));
            System.out.println(prop.getProperty("Telefono experto en palabras"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }




}


