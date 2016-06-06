package com.javarush.test.level26.lesson02.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        if (array.length == 0)
            return new Integer[]{};

       final double mediana;
        if (array.length%2==0)
            mediana = ((double)array[array.length/2-1]+(double)array[array.length/2])/2;
        else
        mediana = array[array.length/2];

        Comparator<Integer> compareByMediana = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int rez = (int) ((Math.abs(o1-mediana)) - Math.abs(o2-mediana));
                if (rez==0)
                    rez = o1-o2;
                  return rez;
            }
        };
        Arrays.sort(array,compareByMediana);
      // Arrays.sort(array);
        //implement logic here
        return array;
    }

}
