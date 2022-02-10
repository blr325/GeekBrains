package java1.lesson7;

public class Test {
    public static void main(String[] args) {
        Plate plate = new Plate(30);
        createCat();
        eatFromPlate(createCat(), plate);

    }

    private static Cat[] createCat() {
        return new Cat[]{
                new Cat("Мурзик", 40),
                new Cat("Мур ", 30),
                new Cat("Федор", 35)
        };
    }

    private static void eatFromPlate(Cat[] cat, Plate plate) {
        for (Cat value : cat) {
            while (!value.satiety) {
                value.checkSatiety(plate, plate.getFood());
            }
            plate.info();
        }
    }
}
