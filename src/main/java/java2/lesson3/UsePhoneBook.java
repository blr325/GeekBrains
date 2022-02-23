package java2.lesson3;

import java.util.Set;

public interface UsePhoneBook {
    void add(String surname, String phoneNumber);
    Set<String> get(String surname);
}
