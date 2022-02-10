package java1.lesson6;

public class AnimalsTest {


    public static void main(String[] args) {
        Dog dog = new Dog("Бобик");
        Cat cat = new Cat("Мурзик");
        startRunAndSwim(dog, cat);
        countAnimals(dog, cat);
    }

    private static void startRunAndSwim(Dog dog, Cat cat) {
        cat.run(150);
        cat.swim(20);
        dog.run(450);
        dog.swim(20);
    }

    private static void countAnimals(Dog dog, Cat cat) {
        int sumAnimals = cat.getCount() + dog.getCount();
        System.out.printf("Было создано %d животных,из них:\nКотов -- %d\nСобак -- %d",
                sumAnimals, cat.getCount(), dog.getCount());
    }
}
