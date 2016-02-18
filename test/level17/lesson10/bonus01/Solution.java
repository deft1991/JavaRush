package com.javarush.test.level17.lesson10.bonus01;

import java.io.IOException;
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
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException
    {
        if (args.length < 2)
        {
            return;
        }
        if (args[0].equals("-c"))
        {
            String name = args[1] + " " + args[2];
            String sex = args[3];
            String d = args[4];
            create(name, sex, d);
        }
        if (args[0].equals("-u"))
        {
            int id = Integer.parseInt(args[1]);
            String name = args[2] + " " + args[3];
            String sex = args[4];
            Date d = new Date(args[5]);
            update(id, name, sex, d);
        }
        if (args[0].equals("-d"))
        {
            int id = Integer.parseInt(args[1]);
            delete(id);
        }
        if (args[0].equals("-i"))
        {
            int id = Integer.parseInt(args[1]);
            index(id);
        }
    }


    public static void create(String name, String sex, String d) throws ParseException
    {
        if (sex.equals("м"))
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date = sdf.parse(d);
            allPeople.add(Person.createMale(name, date));
            int id = allPeople.size() - 1;
            System.out.println(id);
        } else if (sex.equals("ж"))
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date = sdf.parse(d);
            allPeople.add(Person.createFemale(name, date));
            int id = allPeople.size() - 1;
            System.out.println(id);
        }

    }

    public static void update(int id, String name, String sex, Date bd)
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
        pers.setBirthDay(null);
        allPeople.set(id, pers);
    }

    // выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
    public static void index(int id)
    {
        Person pers = allPeople.get(id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        if (pers.getSex().equals(Sex.MALE))
        {
            System.out.println(pers.getName() + " " + "М" + " " + simpleDateFormat.format(pers.getBirthDay()));
        }
        if (pers.getSex().equals(Sex.FEMALE))
        {
            System.out.println(pers.getName() + " " + "Ж" + " " + simpleDateFormat.format(pers.getBirthDay()));
        }
    } //start here - начни тут
}


