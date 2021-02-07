package Lesson_1;

import java.io.File;

public class Task_2 {

    static int count = 1;

    public static void main(String[] args) {
        // определяем объект для каталога
        File dir = new File("C://AMD");
        if (!dir.exists()) {
            System.err.println("Путь не найден");
            System.exit(1);
        }
        go(dir);
    }

    private static void go(File dir) throws NullPointerException {
        try {
            if (dir.isDirectory()) {
                count++;
                for (File item : dir.listFiles()) {
                    if (item.isDirectory()) {
                        System.out.println(" ".repeat(count * 3) + "- " + item.getName());

                    } else {
                        System.out.println(" ".repeat(count * 3) + "file: " + item.getName());
                    }
                    go(item);
                }
                count--;
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }
}

