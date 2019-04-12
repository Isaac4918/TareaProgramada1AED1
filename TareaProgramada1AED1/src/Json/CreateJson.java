package Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class CreateJson {
    public JSONObject obj = new JSONObject();
    public static String jsonvalue="";
    // jsoon

    public void crearjson () {

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



        try (FileWriter file = new FileWriter("C:\\Users\\Kevin Alanis\\Desktop\\Commits2\\test.json")) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


        jsonvalue=obj.toString();

    }

    public String getJSonValue()
    {
        return jsonvalue;
    }
}