package java1.lesson7;

public class Cat {
    private final String name;
    private final int appetite;
    protected boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void checkSatiety(Plate plate, int getFood) {
        if (!satiety) {
            eat(plate, getFood);
        } else System.out.println(name + " сыт");
    }

    private void eat(Plate plate, int getFood) {
        if (getFood >= appetite) {
            plate.decreaseFood(appetite);
            System.out.println(name + " съел " + appetite + " г. еды");
            satiety = true;
        } else {
            System.out.println("Кот " + name + " съел " + getFood + " г. еды." + " Нужно еще " + (appetite - getFood) + " г.");

            plate.addFood();
        }
    }

}
