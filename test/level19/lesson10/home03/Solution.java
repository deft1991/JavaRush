package com.javarush.test.level19.lesson10.home03;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException
    {
        String fileName = args[0];
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String stroka;
        Date d;
        while ((stroka = br.readLine()) != null)
        {
            String[] slova = stroka.split(" ");
            String name = "";
            for (int i = 0; i < slova.length - 3; i++)
            {
                name += slova[i] + " ";
            }
            int size = slova.length;
            d = new Date(Integer.parseInt(slova[size - 1]), Integer.parseInt(slova[size - 2]) - 1, Integer.parseInt(slova[size - 3]));
            //System.out.println(d);

            PEOPLE.add(new Person(name.substring(0,name.length()-1), d));
        }
        br.close();
        for (Person p : PEOPLE)
            System.out.println(p.getName() + " " + p.getBirthday());
    }

}
