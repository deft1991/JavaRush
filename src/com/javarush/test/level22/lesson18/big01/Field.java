package com.javarush.test.level22.lesson18.big01;

import java.io.File;

/**
 * Created by Golitsyn.SN on 13.05.2016.
 */
public class Field {
    int width;
    int height;
    int matrix[][];

   public Field(int width,int height){
        this.width = width;
        this.height=height;
        matrix = new int[height][width];
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }
/**
 * *Задание 13
 Теперь приступим к реализации созданных методов.
 Напиши реализацию метода print в классе Field
 а) Метод должен выводить на экран прямоугольник.
 б) Высота прямоугольника равна height, ширина - width
 в) Если данная клетка пустая - вывести точку, если не пустая - английский X

 Подсказка:
 if (matrix[y][x]==0) ...
 */
    public void print(){
    //  int  pole[][] = new int[height][width];
        for (int y=0;y<getHeight();y++){
            for (int x=0;x<getWidth();x++) {
              if (getValue(x,y)==0)
                System.out.print(".");
                else
                  System.out.print("X");
            }
            System.out.println();
        }
      //  System.out.println(pole);
    }
    public void removeFullLines(){}

    public Integer getValue(int x, int y){
        if (x >= 0 && x < width && y >= 0 && y < height)
            return matrix[y][x];
        return null;
    }
    public void setValue(int x, int y, int value){
        matrix[y][x]=value;
    }

    public static void main(String[] args) {
        Field fff = new Field(10,20);
        fff.print();
    }

}
