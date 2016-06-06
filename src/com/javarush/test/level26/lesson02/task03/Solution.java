package com.javarush.test.level26.lesson02.task03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;




/* Убежденному убеждать других не трудно.
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напишите public static компаратор CustomizedComparator, который будет:
1. в конструкторе принимать список компараторов
2. сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т
В конструктор передается как минимум один компаратор
*/
public class Solution {
    public static class CustomizedComparator<T> implements Comparator<T> {
        ArrayList<Comparator<T>> list;

        CustomizedComparator(Comparator<T>...list) {
            this.list = new ArrayList<>(list.length);
            Collections.addAll(this.list,list);
        }
        public int compare(T o1,T o2){
            int rez=0;
            for (int i=0;i<this.list.size();i++){
                rez = this.list.get(i).compare(o1,o2);
                if(rez!=0){
                    return rez;
                }
            }
            return 0;
        }
    }

}

