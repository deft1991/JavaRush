package com.javarush.test.level19.lesson10.home04;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим

C:\temp\file1.txt

*/

public class Solution
{
    public static List<String> words = new ArrayList<String>();

    static
    {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String stroka;
        while ((stroka = br.readLine()) != null)
        {
            String[] slova = stroka.split(" ");
            int count =0;
            for(int i=0;i<slova.length;i++)
            {
                for (String w : words)
                {
                    if (slova[i].equals(w))
                        count++;
                }
            }
            if (count==2)
                System.out.println(stroka);
        }
        br.close();
    }

}
