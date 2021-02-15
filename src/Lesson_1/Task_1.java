package Lesson_1;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task_1 {
    public static void main(String[] args) {

        //задаем любое время и дату для проверки работоспособности программы
        String dateTime = "2021-02-02T08:29:59";

        System.out.println("Проверка рабочее ли время сейчас : " + LocalDateTime.now() + " - " + check(LocalDateTime.now()));
        System.out.println("Проверка рабочее ли время: " + dateTime + " - " + check(LocalDateTime.parse(dateTime)));
    }

    static LocalTime initalTime = LocalTime.of(8, 30, 00);
    static LocalTime finalTime = initalTime.plus(Duration.ofHours(8).plusMinutes(30));

    private static boolean check(LocalDateTime locDateTime) {
        boolean checkWorkingTimeAndDay = false;
        if (isWorkingTime(locDateTime) && isWorkingDay(locDateTime)) {
            checkWorkingTimeAndDay = true;
        }
        return checkWorkingTimeAndDay;
    }

    private static boolean isWorkingTime(LocalDateTime locDateTime) {
        boolean checkisWorkingTime = false;
        if (locDateTime.toLocalTime().isAfter(initalTime) && locDateTime.toLocalTime().isBefore(finalTime)) {
            checkisWorkingTime = true;
        }
        return checkisWorkingTime;
    }

    private static boolean isWorkingDay(LocalDateTime locDateTime) {
        boolean checkIsWorkingDay = false;
        DayOfWeek dayWeek = locDateTime.getDayOfWeek();
        if (!(dayWeek.toString().equals("SATURDAY") || dayWeek.toString().equals("SUNDAY"))) {
            checkIsWorkingDay = true;
        }
        return checkIsWorkingDay;
    }

}
