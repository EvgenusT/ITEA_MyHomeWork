package HW1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class Main extends Thread {

    static AtomicLong atomicLong = new AtomicLong();

    public static void main(String[] args) throws InterruptedException {

        Numbers forCount = getValues();
        try {
            new Thread(() -> new Main().sumOfPartNumbers(0, forCount)).start();
            new Thread(() -> new Main().sumOfPartNumbers(1, forCount)).start();
            new Thread(() -> new Main().sumOfPartNumbers(2, forCount)).start();
            new Thread(() -> new Main().sumOfPartNumbers(3, forCount)).start();
            Thread.sleep(1000);
            new Main().printSum();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printSum() {
        System.out.println("Результат расчета: " + atomicLong + ".\t Вывод на экран результата выполняется в потоке:  " + getName());
    }

    public void sumOfPartNumbers(int index, Numbers forCount) {
        long sum = payment(distributionOfDigits(forCount), index);
        System.out.println(" - Выполняется в потоке:  " + getName());
        atomicLong.addAndGet(sum);
    }

    public static Numbers getValues() {
        Scanner scanner = new Scanner(System.in);
        Numbers numbers = new Numbers(scanner.nextLong(), scanner.nextLong());
        return numbers;
    }

    private static List<List<Long>> distributionOfDigits(Numbers num) {
        long in = num.getFirst();
        long out = num.getLast();
        long count = out - in + 1;
        long part = count / 4;
        List<List<Long>> listPartsNumber = new ArrayList<>();
        listPartsNumber.add(new ArrayList<>(addNumbersToList(in, part)));
        listPartsNumber.add(new ArrayList<>(addNumbersToList(part + 1, part * 2)));
        listPartsNumber.add(new ArrayList<>(addNumbersToList(part * 2 + 1, part * 3)));
        listPartsNumber.add(new ArrayList<>(addNumbersToList(part * 3 + 1, out)));

        return listPartsNumber;
    }

    private static List<Long> addNumbersToList(long in, long out) {
        List<Long> partList = new ArrayList<>();
        for (long i = in; i < out + 1; i++) {
            partList.add(i);
        }
        return partList;
    }

    private static Long payment(List<List<Long>> lists, int index) {
        long sum = lists.get(index).stream().mapToLong(Long::longValue).sum();
        return sum;

    }

}
