package lesson7;
//Создаем класс кот, со свойствами имя, аппетит и сытость
public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    // конструктор класса
    public Cat(String name, int appetite) {
        this.appetite = appetite;
        this.name = name;
        this.fullness = false;
    }
    // проверка сытости
    public boolean isFullness() {
        return fullness;
    }
    //метод - умение кушать
    public void eat(Plate plate){
        if (plate.getFoodAmount() - appetite >= 0){
            plate.decreaseFood(appetite);
            fullness = true;

        }


    }
}

