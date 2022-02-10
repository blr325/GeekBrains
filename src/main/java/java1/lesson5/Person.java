package java1.lesson5;

import java.util.Random;

public class Person {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;
    Random random = new Random();

    public Person(String fullName, String position, String email, String phoneNumber, int salary) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = random.nextInt(15) + 35;
    }

    void printInfo() {
        System.out.printf("Full Name: %s.\nPosition Held: %s.\nEmail: %s.\nPhone Number: %s.\nSalary: %d.\nAge: %d.\n",
                fullName,position,email,phoneNumber,salary,age);
    }

    public int getAge() {
        return age;
    }
}
