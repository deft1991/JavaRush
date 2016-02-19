package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        int count = 0;
        if (args.length > 0)
        {
            FileInputStream in = new FileInputStream(args[0]);

            while (in.available() > 0)
            {
                String stroka = String.valueOf((char)in.read());
                Pattern pattern = Pattern.compile("[a-zA-z]");
                Matcher matcher = pattern.matcher(stroka);
                if (matcher.find())
                    count++;
            }
            in.close();
        }
        System.out.println(count);
    }
}
