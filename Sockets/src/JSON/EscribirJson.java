package JSON;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class EscribirJson {

    public static void main(String[] args) {

        JSONObject obj = new JSONObject();
        obj.put("contrasena", "234");


        JSONArray list = new JSONArray();
        list.add(1);
        list.add(2);
        list.add(3);

        obj.put("Matrix", list);

        JSONArray letter = new JSONArray();
        letter.add("A");
        letter.add("B");
        letter.add("C");

        obj.put("ListaLetras", letter);



        try (FileWriter file = new FileWriter("C:\\Users\\Kevin Alanis\\IdeaProjects\\test.json")) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);

    }

}