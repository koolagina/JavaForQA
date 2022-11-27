package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameSnake extends JFrame {
    // объявление постоянных
    final String TITLE_OF_PROGRAM = "Classic Game Snake"; // название игры
    final String GAME_OVER_MSG = "GAME OVER"; // надпись при окончании игры
    final static int CELL_SIZE = 20;           // размер клетки
    final static int CANVAS_WIDTH = 30;        // ширина клетки
    final static int CANVAS_HEIGHT = 25;       // высота клетки
    final static Color SNAKE_COLOR = Color.darkGray; // цвет змейки
    final static Color FOOD_COLOR = Color.green; // цвет еды
    final static Color POISON_COLOR = Color.orange; //цвет яда

    // коды стрелок управления
    final static int KEY_LEFT = 37;
    final static int KEY_UP = 38;
    final static int KEY_RIGHT = 39;
    final static int KEY_DOWN = 40;
    final int START_SNAKE_SIZE = 5;          // начальный размер змейки
    final int START_SNAKE_X = CANVAS_WIDTH/2;  //   стартовая точка
    final int START_SNAKE_Y = CANVAS_HEIGHT/2; //   появления змейки
    final int SNAKE_DELAY = 150;               // задержка отрисовки
    int snakeSize = 0;                         // текущий "добавочный размер змейки"
    static boolean gameOver = false;           // проверка на окончание игры


    Canvas canvas; // инициализация поля
    Snake snake; // инициализация змейки
    Food food; // инициализация еды
    Poison poison; //инициализация яда

    public static void main(String[] args) {
        new GameSnake().game();
    } //запуск игры, главный метод

    // конструктор игры
    public GameSnake(){
        setTitle(TITLE_OF_PROGRAM); // что будет написано в верхней части окна
        setDefaultCloseOperation(EXIT_ON_CLOSE); // завершить программу при нажатии кнопки "закрыть"

        canvas = new Canvas(); // создаем поле
        canvas.setBackground(Color.white); // фон поля - белый
        canvas.setPreferredSize(new Dimension(CELL_SIZE * CANVAS_WIDTH - 10,                      // задаем размеры поля
                                                    CELL_SIZE * CANVAS_HEIGHT - 10));

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                snake.setDirection(e.getKeyCode());
            }
        });  // запускаем "слушатель" клавиш управления

        add(canvas);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);  // нельзя растянуть поле
        setVisible(true); // поле видимо
    }

// метод игры
    private void game() {
        snake = new Snake( // создаем змейку
            START_SNAKE_X, // указываем ее координаты,
            START_SNAKE_Y,
            START_SNAKE_SIZE, // размер
            KEY_RIGHT // и направление движения
        );
        food = new Food(snake); // создаем еду
        snake.setFood(food);

        poison = new Poison(snake); //создаем яд
        poison.setFood(food);
        food.setPoison(poison);
        snake.setPoison(poison);

        while(!gameOver){ // запускаем цикл до завершения игры
            snake.move(); // передаем змейке метод движения

            if (snake.size() > snakeSize){
                snakeSize = snake.size();
                setTitle(TITLE_OF_PROGRAM + ":" + snakeSize); // при увеличении змейки - счетчик меняет название вверху окна
            }

            if(food.isEaten()){ // если еда съедена
                food.appear(); //- она добавляется в другом месте,
                poison.add(); // дополнительный яд появляется
            }
            canvas.repaint(); // поле перерисовывается
            sleep(SNAKE_DELAY); // с задержкой
        }
        JOptionPane.showMessageDialog(this, GAME_OVER_MSG); // когда игра окончена - выходит сообщение
    }
// метод задержки
    private void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
// метод отрисовки внешней графики
    class Canvas extends JPanel {    // class for rendering (drawing)
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2D = (Graphics2D) g;
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            snake.paint(g2D);
            food.paint(g2D);
            poison.paint(g2D);
        }
    }
}
