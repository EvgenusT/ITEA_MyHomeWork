package tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator implements Calculator {
    private String message = "Negative numbers are not allowed here. Values of: ";
    List<Integer> numberNegative = new ArrayList<>();
    List<String> stringList = new ArrayList<>();
    int count = 0;
    @Override
    public int add(String numbers) {
        String spliterator = "[^\\d|-]+";
        stringList = Arrays.asList(numbers.split(spliterator));
        System.out.println(stringList);
        return stringList.stream()
                .mapToInt(Integer::valueOf)
                .map(this::validateNumber)
                .sum();
    }

    private int validateNumber(int i) {
        String result = "";
        count++;
        if (i < 0) {
            numberNegative.add(i);
        }
        if (stringList.size() == count && !numberNegative.isEmpty()) {
            result = numberNegative.stream().map(String::valueOf).collect(Collectors.joining(", ", message, ""));
            throw new RuntimeException(String.format(result.toString()));
        }
        return i;
    }
}
