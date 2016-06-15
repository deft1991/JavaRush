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

C:\temp\file1.txt
// яа ад абв вга де
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String s = null;
        while (in.ready())
        {
            s = in.readLine();
        }
        String [] words = s != null ? s.split(" ") : new String[0];
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0)
            return new StringBuilder();
        if (words[0].equals(""))
            return new StringBuilder(words[0]);

        StringBuilder rez = new StringBuilder();

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,words);

        String s = words[0];
        rez = rez.append(s);
        list.remove(0);

        int count = 0;
        while (list.size() > 0) {
            Collections.shuffle(list);
            for (int i = 0; i < list.size(); i++) {
                String slovo = rez.toString().toUpperCase().toLowerCase();
                String find = list.get(i).toUpperCase().toLowerCase();
                if (slovo.toCharArray()[0] == find.toCharArray()[find.length() - 1]) {
                    rez.insert(0, list.get(i) + " ");
                    list.remove(i);
                    i=0;
                }
              else  if (slovo.toCharArray()[slovo.length() - 1] == find.toCharArray()[0]) {
                    rez.append(" " + list.get(i));
                    list.remove(i);
                    i=0;
                }
            }
           // Collections.shuffle(list);
            count++;
            if (count>list.size()){
                try {
                  //  System.out.println("try : "+list.get(0));
                    rez.append(" "+ list.get(0));
                    list.remove(0);
                    Collections.shuffle(list);
                    count=0;

                }
                catch (IndexOutOfBoundsException e){
                    break;
                }
            }
        }

        // C:\temp\file1.txt
        return rez;
    }
}
