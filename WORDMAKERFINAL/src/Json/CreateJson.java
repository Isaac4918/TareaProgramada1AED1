package Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CreateJson {
    public static JSONObject obj = new JSONObject();
    private static JSONArray listaPalabras = new JSONArray();
    // jsoon
    public static void crearjson(ArrayList listaPalabra) {

        for(int i=0;i<=listaPalabra.size()-1;i++){
            System.out.println("Pos i "+ listaPalabra.get(i));
            listaPalabras.add(listaPalabra.get(i));
            obj.put("Palabra:", listaPalabras);


        }System.out.println(listaPalabras.toString());
        try (FileWriter file = new FileWriter("C:\\Users\\Kevin Alanis\\Desktop\\New folder (5)\\test.json")) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getJSonValue()
    {
        return listaPalabras.toString();
    }
}