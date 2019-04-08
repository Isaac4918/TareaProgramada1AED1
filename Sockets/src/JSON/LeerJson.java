package JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class LeerJson {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("C:\\Users\\Kevin Alanis\\IdeaProjects\\test.json"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);

            String contrasena = (String) jsonObject.get("contrasena");
            System.out.println(contrasena);


            // loop array
            JSONArray msj = (JSONArray) jsonObject.get("Matrix");
            Iterator<Integer> iterator = msj.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
            JSONArray msj1 = (JSONArray) jsonObject.get("ListaLetras");
            Iterator<String> iterator1 = msj1.iterator();
            while (iterator1.hasNext()) {
                System.out.println(iterator1.next());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}