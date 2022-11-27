package lesson7;
//Создаем класс тарелка, со свойством - кол-во еды
public class Plate {
    private int foodAmount;
    //конструктор тарелки
    public Plate(int foodAmount){
        this.foodAmount = foodAmount;
    }
    //добавление корма
    public void addFood(int amount){
        foodAmount += amount;
    }
    //уменьшение корма при его поедании
    public void decreaseFood(int amount){
        foodAmount -= amount;
    }

    @Override
    public String toString() {
        return String.valueOf(foodAmount);
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
