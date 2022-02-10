package java1.lesson7;

import java.util.Scanner;

public class Plate {
    Scanner scanner = new Scanner(System.in);
    private int food = 50;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("В тарелке осталось " + food + " г. еды");
    }

    public void decreaseFood(int getAppetite) {
        food -= getAppetite;
    }

    public int getFood() {
        return food;
    }

    private int checkInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Введите целочисленное значение");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public int addFood() {
        System.out.println("Добавьте еды: ");
        int needFood = checkInt();
        while (needFood < 0) {
            System.out.println("Нельзя забирать еду у кота");
            needFood = checkInt();
        }
        food += needFood;
        return food;
    }
}
