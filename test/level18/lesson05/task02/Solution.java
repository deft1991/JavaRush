package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        int sum=0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream stream = new FileInputStream(reader.readLine());
        while(stream.available() > 0){
            int count = stream.read(); // читаем блок размером с файл
            list.add(count);
        }
        reader.close();
        stream.close();
        for(int i =0;i< list.size();i++){
           if(list.get(i).equals(44))
               sum++;
        }
        System.out.println(sum);
    }
}
