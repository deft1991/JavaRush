package com.javarush.level17.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {

        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException
    {
        for (int i = 0; i < args.length; i++)
        {
                //start here - начни тут
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                //String s = reader.readLine();
                if (args[i].equals("c"))
                {
                    String name = reader.readLine();
                    String sex = reader.readLine();
                    Date d = new Date(reader.readLine());
                    create(name, sex, d);
                }
                if (args[i].equals("u"))
                {
                    int id = Integer.parseInt(reader.readLine());
                    String name = reader.readLine();
                    Sex sex = Sex.valueOf(reader.readLine());
                    Date d = new Date(reader.readLine());
                    update(id, name, sex, d);
                }
                if (args[i].equals("d"))
                {
                    int id = Integer.parseInt(reader.readLine());
                    delete(id);
                }
                if (args[i].equals("i"))
                {
                    int id = Integer.parseInt(reader.readLine());
                    index(id);
                }
            }
        }


    public static void create(String name, String sex, Date d)
    {
        if (sex.equals("м"))
        {
            allPeople.add(Person.createMale(name, d));
            int id = allPeople.size() - 1;
            System.out.println(id);
        } else if (sex.equals("ж"))
        {
            allPeople.add(Person.createFemale(name, d));
            int id = allPeople.size() - 1;
            System.out.println(id);
        }

    }

    public static void update(int id, String name, Sex sex, Date bd)
    {
        if (sex.equals("м"))
        {
            allPeople.set(id, Person.createMale(name, bd));
        } else if (sex.equals("ж"))
        {
            allPeople.add(id, Person.createFemale(name, bd));
        }
    }

    public static void delete(int id)
    {
        Person pers = allPeople.get(id);
        pers.setName(null);
        pers.setBirthDay(null);
        pers.setSex(null);
        allPeople.set(id, pers);
    }

// выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
    public static void index(int id)
    {
        Person pers = allPeople.get(id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
        if (pers.getSex().equals(Sex.MALE))
        {
            System.out.println(pers.getName() + " " + "М"+" "+simpleDateFormat.format(pers.getBirthDay()));
        }
        if (pers.getSex().equals(Sex.FEMALE))
        {
            System.out.println(pers.getName() + " " + "Ж" +" "+ simpleDateFormat.format(pers.getBirthDay()));
        }
    }
}
