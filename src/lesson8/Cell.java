package lesson8;

import java.awt.*;
// создаем суперкласс клетки
public class Cell {
    private int x; // координаты клетки
    private int y;
    private int size; // размер клетки
    private Color color; // цвет клетки
// конструктор клетки
    public Cell(int x, int y, int size, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }
// сеттер
    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }
// геттеры
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
// метод отрисовки
    public void paint(Graphics2D graphics2D){
        graphics2D.setColor(color); //цвет заливки клетки
        graphics2D.fillOval(x * size, y * size, size, size); // форма клетки (овал)
    }
}
