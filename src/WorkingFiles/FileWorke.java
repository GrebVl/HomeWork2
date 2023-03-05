package WorkingFiles;

import PlushToy.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileWorke {
    public static ArrayList<PlushToy> ReadFile(String FileName) throws IOException, ParseException {
        String[]  arr = new String[]{"id", "name", "color", "weight", "amount"};
        ArrayList<PlushToy> toy = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        try(FileReader fileTaskRead = new FileReader(FileName)){
            JSONArray arrF = (JSONArray) jsonParser.parse(fileTaskRead);
            for(Object obj : arrF){
                JSONObject per = (JSONObject) obj;
                int idToy = (int)(long) per.get(arr[0]);
                String name = (String) per.get(arr[1]);
                String color = (String) per.get(arr[2]);
                int weight = (int)(long) per.get(arr[3]);
                int amount = (int)((long) per.get(arr[4]));
                toy.add(new NewToy(name, color, weight, amount));
                toy.get(toy.size()-1).setIdToy(idToy);
            }
        } catch(Exception e){
            System.out.println("Parsing error " + e.toString());
        }
        return toy;
    }

    public static void WreatFile(ArrayList<PlushToy> toy, String FileName){
        ArrayList<JSONObject> arrJson = new ArrayList<>();
        String[] strArr = new String[]{"id", "name", "color", "weight", "amount"};
        for (int i = 0; i < toy.size(); i++) {
            arrJson.add(new JSONObject());
            arrJson.get(i).put(strArr[0], toy.get(i).getIdToy());
            arrJson.get(i).put(strArr[1], toy.get(i).getNameToy());
            arrJson.get(i).put(strArr[2], toy.get(i).getColorToy());
            arrJson.get(i).put(strArr[3], toy.get(i).getWeight());
            arrJson.get(i).put(strArr[4], toy.get(i).getAmount());
        }
        try (PrintWriter out = new PrintWriter(new FileWriter(FileName))) {
            out.write(arrJson.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
