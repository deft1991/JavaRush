package com.javarush.test.level23.lesson13.big01;

public class SnakeSection
{
    private int x;
    private int y;


    public SnakeSection(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    /*Задание:
а) реализовать методы  equals &amp; hashCode в классе SnakeSection.

Сигнатура методов:
public boolean equals(Object o)
public int hashCode()

Подсказка:
Используй Alt+Insert в Intellij IDEA*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SnakeSection)) return false;

        SnakeSection that = (SnakeSection) o;

        if (x != that.x) return false;
        return y == that.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
