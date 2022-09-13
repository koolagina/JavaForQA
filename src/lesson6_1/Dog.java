package lesson6_1;

class Dog extends Animal {
    //Задаем переменные
    private static int counter = 1;
    private final static int MAX_RUN_DISTANCE = 500;
    private final static int MAX_SWIM_DISTANCE = 10;

    //При создании экземпляра класса в конструкторе определяется максимальная длина прыжка, бега конкретно для собаки
    public Dog() {
        super(MAX_RUN_DISTANCE, MAX_SWIM_DISTANCE, counter++);
    }
    @Override
    public String kindOfAnimal() {
        return "Пёс";
    }

}
