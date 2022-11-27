package lesson8;

import java.awt.*;
import java.util.LinkedList;
// создание класса змейки
public class Snake {
    private LinkedList<Cell> snake; // создаем список, так как змейка будет расти
    private int direction; // обладает свойством направления движения
    private Food food;
    private Poison poison;
// конструктор змейки
    public Snake(int x, int y, int length, int direction){ // имеет начальные координаты, длину и напрвление движения
        snake = new LinkedList<>();
        for(int i = 0; i < length; i++){
            snake.add(new Cell(x-i, y, GameSnake.CELL_SIZE, Color.green)); // строит змейку поклеточно, заполняя клетки определенным цветом
        }
        this.direction = direction;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int size(){
        return snake.size();
    }
// метод определения напрвления движения - для того, чтобы змейка не могла пойти в обратном направлении
    public void setDirection(int direction){
        if(Math.abs(this.direction - direction) != 2){
            this.direction = direction;
        }
    }
// проверка - попадают ли координаты на змейку
    public boolean isInSnake(int x, int y){
        for(Cell cell : snake){
            if (cell.getX() == x && cell.getY() == y){
                return true;
            }
        }
        return false;
    }
// метод движения, изменения координат при нажатии на стрелки
    public void move() {
        int x = snake.getFirst().getX();
        int y = snake.getFirst().getY();
        switch (direction) {
            case GameSnake.KEY_LEFT: x--;
                if (x < 0)
                    x = GameSnake.CANVAS_WIDTH - 1;
                break;
            case GameSnake.KEY_RIGHT: x++;
                if (x == GameSnake.CANVAS_WIDTH)
                    x = 0;
                break;
            case GameSnake.KEY_UP: y--;
                if (y < 0)
                    y = GameSnake.CANVAS_HEIGHT - 1;
                break;
            case GameSnake.KEY_DOWN: y++;
                if (y == GameSnake.CANVAS_HEIGHT)
                    y = 0;
                break;
        }
        if(isInSnake(x, y) ||
                    poison.isPoison(x, y)){ // если происходит пересечение с ядом - игра завершается
            GameSnake.gameOver = true;
            return;
        }

        snake.addFirst(new Cell(x, y, GameSnake.CELL_SIZE, GameSnake.SNAKE_COLOR));

        if(food.isFood(x, y)){ // если змейка встречается с едой
            food.eat(); // она ее сьедает, и задняя клетка не стирается (змейка растет)
        }else{
            snake.removeLast(); // если еды нет, то задняя клетка стирается (змейка не растет)
        }

    }
// метод отрисовки змейки
    public void paint(Graphics2D graphics2D){
        for(Cell cell : snake){
            cell.paint(graphics2D);
        }
    }

    public void setPoison(Poison poison) {
        this.poison = poison;
    }
}
