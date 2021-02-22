import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<String> strings = getList();

        System.out.println("Задание 1.1:");
        System.out.println(new App().sortingText(strings));

        System.out.println("Задание 1.1. Альтернативная версия:");
        strings.sort(Comparator.comparingInt(String::length).thenComparing(s -> s.toUpperCase()));
        System.out.println(strings);

        System.out.println("Задание 1.2:");
        strings.forEach((st -> System.out.print((upperCaseTranslation(st)) + " ")));
        System.out.println();

        System.out.println("Задание 1.3:");
        strings.forEach(str -> System.out.print(StringUtils.capitalize((lowerCaseTranslation(str))) + " "));
        System.out.println();
    }

    private List<String> sortingText(List<String> strings) {
        strings.sort((a, b) -> a.compareToIgnoreCase(b));
        strings.sort((first, second) -> Integer.compare(first.length(), second.length()));
        return strings;
    }

    private static String lowerCaseTranslation(String str) {
        return str.toLowerCase();
    }

    private static String upperCaseTranslation(String str) {
        return str.toUpperCase();
    }

    private static List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("Three");
        list.add("four");
        list.add("FIVE");
        list.add("Six");
        list.add("seven");
        return list;
    }
}
