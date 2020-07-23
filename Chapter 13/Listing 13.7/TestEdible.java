
/**
 * Output:
 * Tiger: RROOAARR
 * Chicken: Fry it
 * Chicken: cock-a-doodle-doo
 * Apple: Make apple cider
 *
 * @author martinfall
 */
public class TestEdible {

    public static void main(String[] args) {
        Object[] objects = {new Tiger(), new Chicken(), new Apple()};

        for (int i = 0; i < objects.length; i++) {
            if (objects[i] instanceof Edible) {
                System.out.println(((Edible) objects[i]).howToEat());
            }

            if (objects[i] instanceof Animal) {
                System.out.println(((Animal) objects[i]).sound());
            }
        }
    }
}

interface Edible {

    /**
     * Describe how to eat
     */
    public abstract String howToEat();
}

/**
 * Return animal sound
 *
 * @author martinfall
 */
abstract class Animal {

    public abstract String sound();
}

class Tiger extends Animal {

    @Override
    public String sound() {
        return "Tiger: RROOAARR";
    }
}

class Chicken extends Animal implements Edible {

    @Override
    public String howToEat() {
        return "Chicken: Fry it";
    }

    @Override
    public String sound() {
        return "Chicken: cock-a-doodle-doo";
    }
}

abstract class Fruit implements Edible {
    // Data fields, constructors, and methods omitted here
}

class Apple extends Fruit {

    @Override
    public String howToEat() {
        return "Apple: Make apple cider";
    }
}

class Orange extends Fruit {

    @Override
    public String howToEat() {
        return "Orange: Make orange juice";
    }
}
