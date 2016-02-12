package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> rez = new ArrayList<Integer>();
        int min = Integer.MAX_VALUE;
        while(file.available()>0){
            list.add(file.read());
        }
        // заполняем массив колличеством повторений элементов
        int[] count = new int[list.size()];
        for (int i=0;i< list.size();i++){
            for(int j=0;j<list.size();j++){
                if (list.get(i).equals(list.get(j))){
                    count[i]++;
                }
            }
        }
        // определяем минимум повторений
        for(int i =0;i<count.length;i++){
            if (count[i]<min){
                min = count[i];
            }
        }
        for (int i=0;i<list.size();i++){
            if (count[i]==min){
                rez.add(list.get(i));
            }
        }
        for(int i=0;i<list.size();i++)
            System.out.print(list.get(i) + " ");
        System.out.println();
        for(int i=0;i<count.length;i++)
            System.out.print(count[i]+ " ");
        System.out.println();
        for(int i=0;i<rez.size();i++)
            System.out.print(rez.get(i) + " ");
    }
}
