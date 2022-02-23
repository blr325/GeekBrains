package java2.lesson3;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class PhoneBook implements UsePhoneBook {
    private static Map<String, Set<String>> phoneBook = new HashMap<>();

    public PhoneBook() {
    }

    @Override
    public void add(String surname, String phoneNumber) {
        Set<String> phones = phoneBook.getOrDefault(surname,new HashSet<>());
        phones.add(phoneNumber);
        phoneBook.put(surname,phones);
//        if (phones == null) {
//            Set<String> phonesSet = new HashSet<>();
//            phonesSet.add(phoneNumber);
//            phoneBook.put(surname, phonesSet);
//        } else {
//            phones.add(phoneNumber);
//            phoneBook.put(surname, phones);
//        }
    }

    @Override
    public Set<String> get(String surname) {
        return phoneBook.get(surname);
    }
}

