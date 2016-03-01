package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
// заполняем массив байтами.
        FileInputStream file = new FileInputStream(args[0]);
        byte[] buffer = new byte[file.available()];
        file.read(buffer);
        for (int i = 0; i < buffer.length; i++)
//            System.out.print(buffer[i] + " ");
// сортируем массив по возрастанию
        Arrays.sort(buffer);
//        System.out.println();
//        for (int i = 0; i < buffer.length; i++)
//            System.out.print(buffer[i] + " ");

        char[] chars = new char[buffer.length];
        for (int i = 0; i < chars.length; i++)
            chars[i] = (char) buffer[i];
//        System.out.println();
//        for (int i = 0; i < chars.length; i++)
//            System.out.print(chars[i] + " ");

// массив колличесво повторяемых элементов
        int[] count = new int[buffer.length];
        for (int i = 0; i < buffer.length; i++)
        {
            for (int j = 0; j < buffer.length; j++)
            {
                if (buffer[i] == buffer[j])
                    count[i]++;
            }
        }
//        System.out.println();
//        for (int i = 0; i < count.length; i++)
//            System.out.print(count[i] + " ");
// если элементы одинаковые то зануляем их
        for (int i = 0; i < buffer.length; i++)
        {
            for (int j = buffer.length - 1; j > i; j--)
            {
                if (buffer[i] == buffer[j])
                    buffer[j] = -1;
            }
        }
      /*  System.out.println();
        for (int i = 0; i < buffer.length; i++)
            System.out.print(buffer[i] + " ");*/

//        System.out.println();
        for (int i = 0; i < buffer.length; i++)
        {
            if (buffer[i] != -1)
            {
                System.out.println(chars[i]+" "+ count[i]);
            }
        }
        file.close();
    }
}
