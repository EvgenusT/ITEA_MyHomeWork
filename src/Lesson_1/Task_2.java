package Lesson_1;

import java.io.File;

public class Task_2 {

    static int count = 1;

    public static void main(String[] args) {
        // задаем путь к каталогу для проверки
        File dir = new File("C://AMDв");
        if (!dir.exists()) {
            System.err.println("Путь не найден");
            System.exit(1);

        }else
        new Task_2().go(dir);
    }

    private void go(File dir) {

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
    }
}

