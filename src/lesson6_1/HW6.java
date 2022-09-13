package lesson6_1;

import java.util.ArrayList;
import java.util.List;
import static lesson6_1.KindOfAnimal.*;

public class HW6 {

    public static void main(String[] args) {

            final List<Animal> animals = new ArrayList<>();
            animals.add(Animal.of(CAT));
            animals.add(Animal.of(DOG));
            animals.add(Animal.of(CAT));

            animals.forEach(animal -> {
                // методы run,swim,jump отрабатывают по разному для созданных экземпляров класса Dog,Cat,
                // хотя фактически всегда обращаемся к переменной типа Animal (коллекция типизирована суперклассом Animal)
                // это и есть одно из возможных проявлений полифорфизма
                System.out.println(animal.run(100));
                System.out.println(animal.swim(5));
                });

        }

    }

