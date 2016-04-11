package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String stroka;
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> nums = new ArrayList<>();
        while ((stroka = br.readLine()) != null)
        {
            String[] slovo = stroka.split(" ");
            names.add(slovo[0]);
            nums.add(Double.parseDouble(slovo[1]));
        }
        for (int i = 0; i < names.size(); i++)
        {
            for (int j = names.size() - 1; j > i; j--)
            {
                if (names.get(i).equals(names.get(j)))
                {
                    Double d = nums.get(i);
                    d += nums.get(j);
                    nums.set(i, d);
                    nums.remove(j);
                    names.remove(j);
                }
            }
        }
        double count = 0.0;
        for (int i = 0; i < nums.size(); i++)
        {
        if (count<=nums.get(i))
            count=nums.get(i);
        }
        for (int i = 0; i < nums.size(); i++){
            if (nums.get(i).equals(count))
                System.out.println(names.get(i));
        }
        br.close();
    }
}
