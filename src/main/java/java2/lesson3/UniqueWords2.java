package java2.lesson3;

import java.util.ArrayList;

public class UniqueWords2 {
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
        ArrayList<String> uniqueWords = new ArrayList<>();
        printList(ARRAY, uniqueWords);
    }


    private static void printList(String[] array,ArrayList<String> uniqueWords) {
        printUniqueWords(array, uniqueWords);
        printDuplicateWords(array, uniqueWords);
    }

    private static void printDuplicateWords(String[] array, ArrayList<String> list) {
        for (String s : list) {
            int count = 0;
            for (String s1 : array) {
                if (s.equals(s1)) {
                    count++;
                }
            }
            if (count > 1) {
                System.out.println("Слово " + s + " повторяется " + count + " раз(a)");
            }
        }
    }

    private static void printUniqueWords(String[] array, ArrayList<String> list) {
        for (String s : array) {
            if (!list.contains(s)) {
                list.add(s);
            }
        }
        System.out.println("Список уникальных слов в массиве:");
        list.forEach(System.out::println);
        System.out.println("--------------------------------");
    }
}

