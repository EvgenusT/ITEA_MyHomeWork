import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task_1 {
    public static void main(String[] args) {

        //задаем любое время и дату для проверки работоспособности программы
        String dateTime = "2021-02-02T08:31:59";

        System.out.println("Проверка рабочее ли время сейчас: " + "\t" + LocalDateTime.now() + " - " + check(LocalDateTime.now()));
        System.out.println("Проверка рабочее ли время заданное вручную: " + "\t" + dateTime + " - " + check(LocalDateTime.parse(dateTime)));
    }

    static LocalTime initalTime = LocalTime.of(8, 30, 00);
    static LocalTime finalTime = initalTime.plus(Duration.ofHours(8).plusMinutes(30));

    private static boolean check(LocalDateTime locDateTime) {
        return isWorkingTime(locDateTime) && isWorkingDay(locDateTime);
    }

    private static boolean isWorkingTime(LocalDateTime locDateTime) {
        return locDateTime.toLocalTime().isAfter(initalTime) && locDateTime.toLocalTime().isBefore(finalTime);
    }

    private static boolean isWorkingDay(LocalDateTime locDateTime) {
        DayOfWeek dayWeek = locDateTime.getDayOfWeek();
        return !(dayWeek.toString().equals("SATURDAY") || dayWeek.toString().equals("SUNDAY"));
    }

}
