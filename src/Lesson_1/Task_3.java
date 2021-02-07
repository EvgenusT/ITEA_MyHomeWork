package Lesson_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Task_3 {

    static List<Map<String, String>> listMap = new ArrayList<>();

    static String fileName = "D:\\output.json";
    static File file = new File(fileName);

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true) {

            Map<String, String> couple = new HashMap<>();
            System.out.println("Введите имя:");
            String name = scan.nextLine();
            if (!name.equals("end")) {
                couple.put("name", name);
            } else {
                offAndСreateFile();
            }

            System.out.println("Введите возраст:");
            String age = scan.nextLine();
            if (!age.equals("end")) {
                couple.put("age", age);
            } else {
                offAndСreateFile();
            }
            listMap.add(couple);
        }
    }

    private static void offAndСreateFile() {

        System.out.println("Программа прервана пользователем. Создан файл: output.json");
        try (FileWriter writer = new FileWriter(file, false)) {

            for (Map<String, String> d : listMap) {
                writer.write("name = " + d.get("name"));
                writer.append('\n');
                writer.append("age = " + d.get("age"));
                writer.append('\n');
//                writer.write(String.valueOf(d));

            }
            writer.flush();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.exit(0);
    }
}



