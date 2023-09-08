package app.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class Main {
    public static void main(String[] args) {
        List<Fruit> fruitList = new ArrayList<>();
        Apple apple = new Apple();
        apple.color = "red";
        apple.name = "apple";
        fruitList.add(apple);

        Banana banana = new Banana();
        banana.len = 101;
        fruitList.add(banana);

        Fruit fruit = fruitList.get(0);
        Fruit fruit2 = fruitList.get(1);
        System.out.println(fruit instanceof Apple);
        System.out.println(fruit instanceof Banana);
        System.out.println(1);
    }
}
