package java1.lesson5;

public class PersonTest {

    private static Person[] persArray = new Person[5];

    public static void main(String[] args) {
        initPerson();
        printPersonOverFourty();
    }

    private static void printPersonOverFourty() {
        System.out.println("Employees over forty years old:");
        for (Person person : persArray) {
            if (person.getAge() >= 40) {
                System.out.println("-------------------------------");
                person.printInfo();
            }
        }
    }

    private static void initPerson() {
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000);
        persArray[1] = new Person("Petrov Petr", "Designer", "petovpetr@mail.ru", "375293435543", 35000);
        persArray[2] = new Person("Dmitriev Alexander", "Marketer", "alex.12345@gmail.ru", "375292345423", 32000);
        persArray[3] = new Person("Anastasia Guk", "Manager", "anastasia_8@yandex.ru", "375334568790", 27000);
        persArray[4] = new Person("Andrei Syrginevich", "Developer", "blr325@mail.ru", "375299994554", 34000);
    }
}