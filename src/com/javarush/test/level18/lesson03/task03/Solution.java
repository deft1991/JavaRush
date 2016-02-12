package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> rez = new ArrayList<Integer>();
        int max = Integer.MIN_VALUE;

        while(file.available()>0){
            int data = file.read();
            list.add(data);
        }
        int[] count=new int[list.size()];
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size();j++){
                if(list.get(i).equals(list.get(j))){
                    count[i]++;
                }
            }
        }

        for(int i=0;i<count.length;i++){
            if (count[i]>max)
                max=count[i];
        }
        for(int i=0;i<list.size();i++){
              if (count[i]==max )
                  rez.add(list.get(i));

        }
        for(int i=rez.size()-1;i>0;i--){
            for(int j=0;j<i;j++){
                if (rez.get(i).equals(rez.get(j)))
                    rez.set(i,0);
            }
        }
        for(int i=0;i<rez.size();i++)
        {
            if (rez.get(i)>0)
            System.out.print(rez.get(i) + " ");
        }
    }
}
