package java2.lesson3;

import java.util.Map;
import java.util.TreeMap;

public class UniqueWords {
    private static final String[] ARRAY = {
            "Привет", "Привет", "Привет",
            "Пока", "Пока",
            "Лицо",
            "Рука",
            "Нога", "Нога",
            "Стул",
            "Стол",
    };

    public static void main(String[] args) {

        Map<String, Integer> uniqueWords = new TreeMap<>();
        for (String word : ARRAY) {
            Integer count = uniqueWords.getOrDefault(word,0);
            uniqueWords.put(word, ++count);
        }
        for (Map.Entry<String, Integer> entry : uniqueWords.entrySet()) {
            System.out.printf("Cлово %s повторяется - %d раз %n", entry.getKey(), entry.getValue());

        }
    }
}
