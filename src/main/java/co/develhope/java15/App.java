package co.develhope.java15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        System.out.println(" --- ");

        System.out.println("Using stream:");
        printAllLinesUsingStream("names.txt");

        System.out.println("Using readAllLines and a for each loop:");
        printAllLinesUsingReadAndFor("names.txt");

        System.out.println("Using stream and filter with length() < 5:");
        printFilteredUsingStream("names.txt", App::isShorterThan5);

        System.out.println("Using stream and filter starting with 'S':");
        printFilteredUsingStream("names.txt", name -> name.startsWith("S"));

        System.out.println("Using stream and filter starting with 'F':");
        printFilteredUsingStream("names.txt", name -> name.startsWith("F"));

    }

    static void printAllLinesUsingStream(String filePath) {
        try {
            Stream<String> lines = Files.lines(Path.of(filePath));
            lines.forEach(System.out::println);
            lines.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printFilteredUsingStream(String filePath, Predicate<String> predicate) {
        try {
            Stream<String> lines = Files.lines(Path.of(filePath));
            lines
                .filter(predicate)
                .forEach(System.out::println);
            lines.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static void printAllLinesUsingReadAndFor(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));
            for(String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static boolean isShorterThan5(String s) {
        return s.length() < 5;
    }
}
