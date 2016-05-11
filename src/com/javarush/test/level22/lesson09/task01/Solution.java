package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот

C:\temp\temp.txt
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fr = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        String line="";
        while ((line=fr.readLine())!=null)
            sb.append(line+" ");
        fr.close();
        reader.close();
        System.out.println(sb);
        String[]slova = sb.toString().split(" ");
        for(int i=0;i<slova.length;i++){
            for(int j=i+1;j<slova.length;j++){
                StringBuilder rev = new StringBuilder(slova[j]).reverse();
                if (slova[i].equals(rev.toString())) {
                    Pair pair = new Pair();
                    pair.first = slova[i];
                    pair.second = slova[j];
                    result.add(pair);
                }
            }
        }
            for (Pair p : result)
                System.out.println(p.first+" "+p.second);
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
