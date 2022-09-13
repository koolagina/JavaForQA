package lesson6_1;

    class Cat extends Animal {
        //Задаем переменные
        private static int counter = 1;
        private final static int MAX_RUN_DISTANCE = 200;
        private final static int MAX_SWIM_DISTANCE = 0;

        //При создании экземпляра класса в конструкторе определяется максимальная длина прыжка, бега конкретно для кота
        public Cat() {
            super(MAX_RUN_DISTANCE, MAX_SWIM_DISTANCE, counter++);
        }
        @Override
        public String kindOfAnimal() {
            return "Кот"; }
    }
