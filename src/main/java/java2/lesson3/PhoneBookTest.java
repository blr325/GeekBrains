package java2.lesson3;

import org.jetbrains.annotations.NotNull;

public class PhoneBookTest {
    public static void main(String[] args) {
        PhoneBook phoneBook = getPhoneBook();

        System.out.println("Cписок номеров по фамилии Иванов - " + phoneBook.get("Иванов"));
        System.out.println("Cписок номеров по фамилии Сидоров - " + phoneBook.get("Сидоров"));
    }

    @NotNull
    private static PhoneBook getPhoneBook() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+375292425522");
        phoneBook.add("Иванов", "+375335423123");
        phoneBook.add("Сидоров", "+375334568710");
        phoneBook.add("Козлов", "+375446784563");
        phoneBook.add("Сухарев", "+375445430987");
        phoneBook.add("Иванов", "+375291023456");
        phoneBook.add("Сидоров", "+375294524576");
        return phoneBook;
    }
}
