package Lesson_1;


import java.io.File;

public class Task_2 {

    public static void main(String[] args) {
        // определяем объект для каталога
        File dir = new File("D://Музыка");
        if (!dir.exists()) {
            System.err.println("Путь не найден");
            System.exit(1);
        }

        go(dir);
    }

    private static void go(File dir) {

        if (dir.isDirectory()) {

            for (File item : dir.listFiles()) {
                if (item.isDirectory()) {
                    System.out.println("- " + item.getName());
                } else {
                    System.out.println("\t" + "file: " + item.getName());
                }
                go(item);
            }
        }
    }
}
