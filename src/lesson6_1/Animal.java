package lesson6_1;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

//Создаем абстрактный класс - родитель
abstract class Animal {
    private final int id;
    private final int maxRunDistance;
    private final int maxSwimDistance;

//Конструктор для создания экземпляров класса, наследующих класс Animal
    public Animal(int maxRunDistance, int maxSwimDistance, int id) {
        this.id = id;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        }

// Оговариваем в контракте интересующие нас случаи
    @Contract("_ -> new")
    public static @NotNull Animal of(KindOfAnimal kindOfAnimal){
        switch(kindOfAnimal){
            case CAT: return new Cat();
            case DOG: return new Dog();
            default: throw new UnsupportedOperationException();
        }
    }

//Создаем метод описывающий бег
    public String run(int distance) {
        return print ("run",distance<= maxRunDistance,distance);
    }
//Создаем метод описывающий плавание
    public String swim(int distance) {
        return print ("swim",distance<= maxSwimDistance,distance);
    }


//Создаем метод возвращающий ответ
    private String print(String move, boolean done, int distance){
        if (done) return kindOfAnimal()+id +"."+move+"("+distance+")"+"; -> " + kindOfAnimal() + " преодолел:  "+distance+" метров";
        return kindOfAnimal()+id +"."+move+"("+distance+")"+"; -> " + kindOfAnimal() + " не смог преодолеть:  "+distance+" метров";
    }

// Реализация паттерна шаблонный метод
    public abstract String kindOfAnimal();
}
    enum KindOfAnimal {
        CAT,DOG
    }


