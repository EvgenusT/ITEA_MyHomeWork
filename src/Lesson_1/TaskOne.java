package Lesson_1;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TaskOne {
    public static void main(String[] args) {

        String dateTime = "2021-02-02T09:45:00";
        System.out.println("Проверка рабочее ли время сейчас : " + LocalDateTime.now() + " - " + checkWorkingDay(LocalDateTime.now()));
        System.out.println("Проверка рабочее ли время: " + dateTime + " - " + checkWorkingDay(LocalDateTime.parse(dateTime)));
    }

    private static boolean checkWorkingDay(LocalDateTime locDateTime) {

        boolean timeControl = false;

        LocalTime initalTimeNew = LocalTime.of(locDateTime.getHour(), locDateTime.getMinute());

        LocalTime initalTime = LocalTime.of(8, 29);
        LocalTime finalTime = initalTime.plus(Duration.ofMinutes(512));

        DayOfWeek dayWeek = locDateTime.getDayOfWeek();

        if ((initalTimeNew.isAfter(initalTime) && initalTimeNew.isBefore(finalTime)) &&
                !(dayWeek.toString().equals("SATURDAY") || dayWeek.toString().equals("SUNDAY"))) {

            timeControl = true;
        }

        return timeControl;
    }
}
