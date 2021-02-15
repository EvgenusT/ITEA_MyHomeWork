package Lesson_1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task_3_JSON {

    static String fileName = "src/outputJSONArray.json";
    static File file = new File(fileName);
    static JSONArray array = new JSONArray();
    static JSONObject obj;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("Введите имя:");
            String name = scan.nextLine();

            if (name.indexOf("name =") == 0) {
                name = name.substring(7);
            }
            if (!name.equals("end")) {
                obj = new JSONObject();
                obj.put("name", name);
                System.out.println("Введите возраст:");
                String age = scan.nextLine();

                if (age.indexOf("age =") == 0) {
                    age = age.substring(6);
                }
                if (!age.equals("end")) {
                    obj.put("age", new Integer(age));
                    array.add(obj);
                } else
                    offAndСreateFile();
            } else
                offAndСreateFile();
        }
    }

    private static void offAndСreateFile() {

        try (FileWriter writer = new FileWriter(file, false)) {
            System.out.println("Программа прервана пользователем. Создан файл: outputJSONArray.json");
            writer.write(String.valueOf(array));
            writer.flush();

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        System.exit(0);
    }
}
