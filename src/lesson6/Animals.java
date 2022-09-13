package lesson6;
//1. Создать классы Собака и Кот с наследованием от класса Животное.
//2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//4. * Добавить подсчет созданных котов, собак и животных.
public abstract class Animals {
    public String name;
    public String kind;

    public Animals(String name, String kind) {
        this.name = name;
        this.kind = kind;
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Бобик");
        dog.print();
        dog.run(510, dog.getMaxDistanceForRun());
        dog.swim(5, dog.getMaxDistanceForSwim());
        System.out.println();
        Dog dog1 = new Dog("Трезор");
        dog1.print();
        dog1.run(400, dog1.getMaxDistanceForRun());
        dog1.swim(25, dog1.getMaxDistanceForSwim());
        System.out.println();
        System.out.println("Создано обьектов класса Dog: " + dog.getCount());
        System.out.println();
        Cat cat = new Cat("Муся");
        cat.print();
        cat.run(120, cat.getMaxDistanceForRun());
        cat.swim(5, cat.getMaxDistanceForSwim());
        System.out.println("Создано обьектов класса Cat: " + cat.getCount());
        System.out.println();
        System.out.println("Создано обьектов класса Animal: " + (cat.getCount()+dog.getCount()));
    }
    public void run(int runDistance, int maxDistanceForRun) {
        if (runDistance < maxDistanceForRun) System.out.println(name + " пробежал " + runDistance + " метров");
        else System.out.println(name + " пытался, но не смог пробежать " + runDistance + " метров");
    }
    public void swim(int swimDistance, int maxDistanceForSwim) {
        if (swimDistance < maxDistanceForSwim) System.out.println(name + " проплыл " + swimDistance + " метров");
        else System.out.println(name + " пытался, но не смог проплыть " + swimDistance + " метров");
    }
    @Override
    public String toString(){
        return String.format("Имя: %s \tВид: %s \n",
                name, kind);}
    public void print(){
        System.out.println(this);
    }

}
