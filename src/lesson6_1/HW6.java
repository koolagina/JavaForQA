package lesson6_1;

import java.util.ArrayList;
import java.util.List;
import static lesson6_1.KindOfAnimal.*;

public class HW6 {

    public static void main(String[] args) {
//Создаем массив из экземпляров класса
        final List<Animal> animals = new ArrayList<>();
        animals.add(Animal.of(CAT));
        animals.add(Animal.of(DOG));
        animals.add(Animal.of(CAT));

        // Методы run,swim отрабатывают по разному для созданных экземпляров классов Dog,Cat(коллекция типизирована суперклассом Animal)
        animals.forEach(animal -> {
            System.out.println(animal.run(100));
            System.out.println(animal.swim(5));
        });
    }
}

