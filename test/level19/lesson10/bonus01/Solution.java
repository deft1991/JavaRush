package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5

C:\temp\file1.txt
C:\temp\file2.txt

*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1Name = reader.readLine();
        String file2Name = reader.readLine();
        reader.close();
        File file1 = new File(file1Name);
        File file2 = new File(file2Name);
        FileReader scanner1 = new FileReader(file1);
        FileReader scanner2 = new FileReader(file2);

        while(scanner1.ready()||scanner2.ready()){

            char s1 = (char) scanner1.read();
            char s2 = (char) scanner2.read();
            if (s1==(s2))
                lines.add(new LineItem(Type.SAME,String.valueOf(s1)));

            if(s1>s2)
                lines.add(new LineItem(Type.REMOVED,String.valueOf(s1)));

            if(s1<s2)
                lines.add(new LineItem(Type.ADDED,String.valueOf(s2)));
        }
        scanner1.close();
        scanner2.close();
        for(int i =0;i<lines.size();i++)
            System.out.println(lines.get(i).type+" "+lines.get(i).line);
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
