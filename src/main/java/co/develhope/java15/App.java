package co.develhope.java15;

import java.util.List;
import java.util.stream.Collectors;

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

        List<String> names = List.of("Emanuele", "Giuseppe", "Alessandro", "Maurizio");

        System.out.println(names);

        names.stream()
            .filter(App::startsWithE)
            .forEach(System.out::println);
    }

    public static boolean startsWithE(String s) {
        return s.startsWith("E");
    }
}
