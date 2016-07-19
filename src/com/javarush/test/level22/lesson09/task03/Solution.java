package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена

/home/user/temp/file1.txt
*/
public class Solution {
    public static void main(String[] args) {
        //...
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String stroka = br.readLine();
            // закомитить перед тестом
            System.out.println(stroka);
            String [] slova = stroka.trim().split(" ");
            StringBuilder result = getLine(slova);
            System.out.println(result.toString());
            System.out.println((int)(Math.random()*slova.length));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static StringBuilder getLine(String... words) {
        int rand = (int) (Math.random()*words.length);
        ArrayList<String>list = new ArrayList<>();
        // добавил все слова в лист
        Collections.addAll(list, words);
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(rand));
        list.remove(rand);
        for (int i = 0; i< list.size();i++){

        }
          return sb;
    }
}
