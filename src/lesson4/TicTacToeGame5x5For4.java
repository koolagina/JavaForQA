package lesson4;

import java.util.*;


public class TicTacToeGame {
    //Напишем основной метод игрового цикла
    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }

        }
        System.out.println("Игра закончена");
    }

    //Объявляем параметры поля (массив map),
    // его размер (константа SIZE) и
    // число точек для победы (константа DOTS_TO_WIN)
    public static char[][] map;
    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;
    //Обьявляем именные константы для заполнения пустых и Х/О ячеек
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    //Инициализируем поле,
    // заполнив его ячейки символом = пустому полю
    public static void initMap() {
        int x = SIZE;
        int y = SIZE;
        map = new char[x][y];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    //Выводим поле в консоль
    public static void printMap() {
        //Распечатаем шапку игрового поля
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        //Распечатаем игровое поле
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //Напишем метод отвечающий за ход человека
    // Создаем Scanner для считывания данных из консоли
    public static Scanner sc = new Scanner(System.in);

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты Вашего хода в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); //Проведем проверку валидности ячейки
        map[x][y] = DOT_X;
    }

    //Напишем метод отвечающий за проверку возможности установки фишки в указанную ячейку
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[x][y] == DOT_EMPTY) return true;
        return false;
    }

    //Напишем метод отвечающий за ход компьютера
    //Добавим генератор случайных чисел
    public static Random rand = new Random();

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y)); //Проведем проверку валидности ячейки
        System.out.println("Компьютер поставил фишку в " + (x + 1) + " " + (y + 1));
        map[x][y] = DOT_O;
    }

    //Напишем метод проверяющий победу
    public static boolean checkWin(char symb) {
        if (checkWinRow(symb)) return true;
        if (checkWinColumn(symb)) return true;
        if (checkWinMainDiagonal(symb)) return true;
        if (checkWinSecondDiagonal(symb)) return true;
        return false;
    }
    // Проверка по строкам
    public static boolean checkWinRow(char symb) {

        for (char[] line : map) {
            Map<Character, Integer> counter = new HashMap<>();
            for (char x : line) {
                if (x == symb){
                    int newValue = counter.getOrDefault(x, 0) + 1;
                    counter.put(x, newValue);
                    for (int value : counter.values()) {
                        if (value == DOTS_TO_WIN) return true;
                    }
                }
            }
        }
        return false;
    }
    // Проверка по столбцам
public static boolean checkWinColumn(char symb) {
    char[][] transponMap = new char[SIZE][SIZE];
        for(int i = 0; i < SIZE; i++){
             for(int j = 0;j < SIZE; j++){
                 transponMap[i][j]=map[j][i];
             }
             for (char[] line : transponMap) {
                Map<Character, Integer> counter = new HashMap<>();
                for (char x : line) {
                    if (x == symb){
                        int newValue = counter.getOrDefault(x, 0) + 1;
                        counter.put(x, newValue);
                        for (int value : counter.values()) {
                            if (value == DOTS_TO_WIN) return true;
                        }
                    }
                }
            }
        }
        return false;
}
    // Проверка по главной диагонали (1.1 2.2 3.3)
    public static boolean checkWinMainDiagonal(char symb) {
        int value = 0;
        for (int i = 0; i < SIZE; i++) {
            if (symb == map[i][i]) {
                value++;
                if (value == DOTS_TO_WIN) return true;
            }
        }
        return false;
    }
    // Проверка по главной диагонали (3.1 2.2 1.3)
    public static boolean checkWinSecondDiagonal(char symb) {
        int value = 0;
        for (int i = 0; i < SIZE; i++) {
            if (symb == map[SIZE - 1 - i][i]) {
                value++;
                if (value == DOTS_TO_WIN) return true;
            }
        }
        return false;
    }
    //Напишем метод проверяющий ничью (поле заполнено)
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
}






