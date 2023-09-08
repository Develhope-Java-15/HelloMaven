package co.develhope.java15;

import org.json.JSONObject;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        String json = "{ \"name\": \"Lorenzo\", \"age\": 25 }";
        JSONObject obj = new JSONObject(json);

        System.out.println(obj.getString("name"));
    }
}
