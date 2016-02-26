package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
Пример параметров: -u 1 Миронов м 15/04/1990
Пример параметров: -d 1
Пример параметров: -i 1
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {

        if (args[0] != null)
        {
            // -c name sex bd
            // -c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
            if (args[0].equals("-c"))
            {
                Date itog = new Date(args[3]);
                System.out.println("-c");
                if (args[2].equals("м"))
                {
                    allPeople.add(Person.createMale(args[1], itog));
                }
                if (args[2].equals("ж"))
                {
                    allPeople.add(Person.createFemale(args[1], itog));
                }
                System.out.println(allPeople.size() - 1);
                System.out.println(allPeople.get(allPeople.size() - 1).getName() + " " +
                        itog + " " +
                        allPeople.get(allPeople.size() - 1).getSex());
            }
            // -u id name sex bd
            // -u  - обновляет данные человека с данным id
            if (args[0].equals("-u"))
            {
                Date d = new Date(args[4]);
                System.out.println("-u");
                if (args[3].equals("м"))
                    allPeople.set(Integer.parseInt(args[1]), Person.createMale(args[2], d));
                if (args[3].equals("ж"))
                    allPeople.set(Integer.parseInt(args[1]), Person.createFemale(args[2], d));

                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " " +
                        allPeople.get(Integer.parseInt(args[1])).getBirthDay() + " " +
                        allPeople.get(Integer.parseInt(args[1])).getSex());
            }
            // -d id
            // -d  - производит логическое удаление человека с id
            if (args[0].equals("-d"))
            {
                Person qqq = allPeople.get(Integer.parseInt(args[1]));
                qqq.setBirthDay(null);
                allPeople.set(Integer.parseInt(args[1]), qqq);
                System.out.println("-d");
                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " " +
                        allPeople.get(Integer.parseInt(args[1])).getBirthDay());
            }
            // -i id
            // -i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
            // Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
            if (args[0].equals("-i"))
            {
                Person qqq = allPeople.get(Integer.parseInt(args[1]));
                String rexSex=null;
                String name = qqq.getName();
                Sex sex = qqq.getSex();
                if (sex.equals(Sex.MALE))
                    rexSex = "м";
                if (sex.equals(Sex.FEMALE))
                    rexSex = "ж";

                String date = String.valueOf(qqq.getBirthDay());
                SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
              //  Date rezDate = format.parse(date);
                System.out.println("-i");
                System.out.println(name + " "+ rexSex+ " "+ date);
            }
        }
    }
}
