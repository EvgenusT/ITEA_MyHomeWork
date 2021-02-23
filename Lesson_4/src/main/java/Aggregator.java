
import java.util.List;
import java.util.Map;


public interface Aggregator {

    /**
     * Метод для нахождения суммы всех чисел
     *
     * @param numbers список чисел, которые нужно просуммировать
     * @return sum - сумма всех чисел
     */
    int sum(List<Integer> numbers); // simple method just to warm up :)

    /**
     * Метод для нахождения слов, которые встречаются чаще всех
     *
     * @param words список слов
     * @param limit параметр для ограничеия количества возвращаемых слов
     * @return список слов и количество их повторений
     * (результат сортируется по частоте в убывающем порядке, если частота одинакова,
     * то сортировать в алфавитном порядке)
     */
    Map<String, Long> getMostFrequentWords(List<String> words, long limit);

    /**
     * Ищет дубликаты игнорирую регистр(например: 'java' == 'JaVA')
     *
     * @param words список слов
     * @param limit параметр для ограничеия количества возвращаемых слов
     * @return  список слов, которые имеют дубликаты. Слова в верхнем регистре, отсортированные по длине,
     * в возрастающем порядке, если длина одинакова, то сортировать в алфавитном порядке
     */
    List<String> getDuplicates(List<String> words, long limit);

}
