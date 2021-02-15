package Lesson_1;

import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task_3 {

    static String fileName = "src/outputArray.json";
    static File file = new File(fileName);
    static List<String> acceptedLines = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        while (true) {
            String text = scan.nextLine();
            if (!text.equals("end")) {
                acceptedLines.add(text);

            } else {
                offAndСreateFile(acceptedLines);
                break;
            }
        }
    }

    private static void offAndСreateFile(List<String> acceptedLines) throws IOException {
        System.out.println("Программа прервана пользователем. Создан файл: outputArray.json");
        FileWriter writer = new FileWriter(file, false);
        JSONObject obj = new JSONObject();

        for (String couple : acceptedLines) {
            String[] arrSplit_2 = couple.split("=");
            String first = arrSplit_2[0].trim();
            String second = arrSplit_2[1].trim();
            obj.put(first, second);
        }
        writer.write(String.valueOf(obj));
        writer.flush();
    }
}




