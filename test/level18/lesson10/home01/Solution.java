package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution
{
    public static void main(String[] args)
    {
        int count = 0;
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'q', 'x', 'y', 'z'};
        for (int i = 0; i < args.length; i++)
        {
            for (int j = 0; j < alphabet.length; j++)
            {
                if (args[i].toLowerCase().equals(alphabet[j]))
                    count++;
            }
        }
    }
}
