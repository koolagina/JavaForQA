package lesson7;
//приложение для кормления котика
public class FeedingApp {
    public static void main(String[] args) {
        //создаем массив котиков
        Cat barsik = new Cat("Barsik", 7);
        Cat pushok = new Cat("Pushok", 10);
        Cat musya = new Cat("Musya", 5);
        Cat[] cats = {barsik, pushok, musya};
        //создаем тарелку с кормом
        Plate plate = new Plate(20);
        // кормим котиков
        for(int i=0; i< cats.length; i++) {
            cats[i].eat(plate);
            if (cats[i].isFullness()==false){
                System.out.println("В тарелке осталось: " + plate+ " шт. еды. Котик под номером "+i+" голоден. Добавляю 10 кусочков корма! Не забудьте покормить этого котика!");
                plate.addFood(10);

            }
        }

        System.out.println("В тарелке осталось: " + plate+ " шт. еды.");
        System.out.println("Сытость котиков: Барсик: "+barsik.isFullness()+", Пушок: "+pushok.isFullness()+", Муся: "+musya.isFullness());


    }
}