package com.javarush.test.level25.lesson02.task02;

import java.util.ArrayList;
import java.util.List;

import static com.javarush.test.level25.lesson02.task02.Solution.Wheel.*;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution {
    public static void main(String[] args) {
        Car car = new Car();
        for (Wheel w : car.wheels)
            System.out.println(w);
    }
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            try{
                wheels = new ArrayList<>(4);
                Wheel[] arr = Wheel.values();
            for(int i=0;i<loadWheelNamesFromDB().length;i++){
                if (FRONT_LEFT.toString().equals(loadWheelNamesFromDB()[i])) {
                    wheels.add(arr[0]);
                }
                if (FRONT_RIGHT.toString().equals(loadWheelNamesFromDB()[i]))
                    wheels.add(arr[1]);
                if (BACK_LEFT.toString().equals(loadWheelNamesFromDB()[i]))
                    wheels.add(arr[2]);
                if (BACK_RIGHT.toString().equals(loadWheelNamesFromDB()[i]))
                    wheels.add(arr[3]);
            }
            }
            catch(IllegalArgumentException e){
                System.out.println("если что-то не то с колесами, то это не машина!");
            }
            //init wheels here
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }
}
