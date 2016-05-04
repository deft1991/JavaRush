package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Golitsyn.SN on 04.05.2016.
 */
/*
Задание 11
С классом Hippodrome почти закончили.
Добавь в конец метода main вызов run().

Подсказка:
run() - это нестатический метод, поэтому вызвать его можно только у объекта.
А где взять объект?

Подсказка 2:
game.run();
*/
public class Hippodrome {
    public ArrayList<Horse> horses = new ArrayList<Horse>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses() {
        return horses;
    }
    public void run(){
     for (int i =0;i<100;i++){
         try {
             move();
             print();
             Thread.sleep(200);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
    }
    public void move(){
     for (Horse horse : getHorses()){
         horse.move();
     }
    }
    public void print(){
     for (Horse horse : getHorses()){
         horse.print();
     }
        System.out.println();
        System.out.println();
    }
/*
Задание 15
Добавим определение победителя.
В классе Hippodrome сделаем два метода:
public Horse getWinner() и public void printWinner()

Метод getWinner должен возвращать лошадь пробежавшую самую большую дистанцию.
Метод printWinner выводит на экран имя победителя в виде:
Winner is <NAME>!
Пример:
Winner is Lucky!
*/
    public Horse getWinner(){
        double maxDist = Double.MIN_VALUE;
        int index=0;
        for (int i =0;i<horses.size();i++){
            if (horses.get(i).getDistance()>maxDist){
                maxDist=horses.get(i).getDistance();
                index = i;
            }
        }
        return horses.get(index);
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName()+"!");
    }

    public static void main(String[] args) {
        game = new Hippodrome();
        Horse firstHorse = new Horse("Sleven", 3, 0);
        Horse secondHorse = new Horse("Lucky", 3, 0);
        Horse thirdHorse = new Horse("Gomer", 3, 0);
        game.getHorses().add(firstHorse);
        game.getHorses().add(secondHorse);
        game.getHorses().add(thirdHorse);

        game.run();
        game.printWinner();
    }


}
