package lesson8;

import java.util.Random;

import static lesson8.GameSnake.*;
// создание подкласса еда
public class Food extends Cell{
    private Random random;
    private Snake snake;
    private Poison poison;
// конструктор еды
    public Food(Snake snake){
        super(-1, -1, CELL_SIZE, FOOD_COLOR);
        random = new Random();
        this.snake = snake;
    }
// проверка клетки - еда ли это
    public boolean isFood(int x, int y){
        return (getX() == x) && (getY() == y);
    }
// проверка еды - если еда съедена - хвост не двигается
    public boolean isEaten() {
        return (getX() == -1);
    }
// после съедения координаты еды сбрасываются за пределы поля
    public void eat(){
        set(-1, -1);
    }
// дабавление новой еды
    public void appear(){
        int x, y;
        do{
            x = random.nextInt(CANVAS_WIDTH); // в рандомном месте
            y = random.nextInt(CANVAS_HEIGHT);
        }while(snake.isInSnake(x, y)
                    || poison.isPoison(x, y)); //но не должна попадать на змейку или яд
        set(x, y);
    }

    public void setPoison(Poison poison) {
        this.poison = poison;
    }
}
