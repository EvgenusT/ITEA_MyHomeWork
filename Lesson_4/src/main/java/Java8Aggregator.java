import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Aggregator implements Aggregator {
    static List<Integer> numbers = List.of(11, 25, 5, 1, 10, 12);
    static List<String> words = List.of("One", "two", "Yarik", "qwert", "Asdfg", "qwert", "Petrovich", "Hi",
            "Vasiliy", "Asdfg", "Petrovich", "Hi", "two", "knife sharpening", "hi", "Yarik", "Hi");

    public static void main(String[] args) {
        System.out.println("Задание 1: " + "\n" + new Java8Aggregator().sum(numbers));
        System.out.println("Задание 2: " + "\n" + new Java8Aggregator().getMostFrequentWords(words, 4));
        System.out.println("Задание 3: " + "\n" + new Java8Aggregator().getDuplicates(words, 5));
    }

    @Override
    public int sum(List<Integer> numbers) {
        try {

            return IntStream.of(numbers.stream().mapToInt(i -> i).sum()).sum();

        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Map<String, Long> getMostFrequentWords(List<String> words, long limit) {
        try {
            Map<String, Long> result2 = new HashMap<>();
            Map<String, Long> collect = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            collect.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(limit).
                    forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));
            return result2;
        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public List<String> getDuplicates(List<String> words, long limit) {

        try {
            // группировка
            Map<String, Long> result = words.stream().map(str -> str.toUpperCase()).
                    collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));

            // фильтр, лимит и перевод в список
            List<String> duplicatesList = result.keySet().stream().filter(key -> (result.get(key) > 1)).limit(limit).collect(Collectors.toList());

            // сортировка
            duplicatesList.sort(Comparator.comparingInt(String::length).thenComparing(s -> s.toUpperCase()));

            return duplicatesList;

        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException();
        }
    }
}
