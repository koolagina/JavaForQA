package lesson8;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static lesson8.GameSnake.*;

// создание подкласса яд
public class Poison extends Cell{
    private List<Cell> poison; // создаем список, так как яд будет накапливаться
    private Random random;
    private Food food;
    private Snake snake;
// конструктор яда
    public Poison(Snake snake){
        super(-1, -1, CELL_SIZE, POISON_COLOR); //координаты, размер и цвет яда
        poison = new ArrayList<>();
        random = new Random();
        this.snake = snake;
    }

    public void setFood(Food food) {
        this.food = food;
    }
    // проверка клетки - яд ли это
    public boolean isPoison(int x, int y){
        for(Cell cell : poison) {
            if((cell.getX() == x) && (cell.getY() == y)) return true;
        }
        return false;
    }
// метод добавления яда на поле
    public void add(){
        int x, y;
        do{
            x = random.nextInt(CANVAS_WIDTH);  // в рандомном месте
            y = random.nextInt(CANVAS_HEIGHT);
        }while(snake.isInSnake(x, y)
                    || isPoison(x, y)   //но не должен попадать на змейку или еду, или яд
                    || food.isFood(x, y));
        poison.add(new Cell(x, y, GameSnake.CELL_SIZE, GameSnake.POISON_COLOR));
    }
// метод отрисовки яда в игре
    public void paint(Graphics2D graphics2D){
        for(Cell cell : poison){
            cell.paint(graphics2D);
        }
    }
}
