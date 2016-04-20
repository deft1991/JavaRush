package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        try
        {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("Golitsyn");
            user1.setLastName("Sergey");
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);

            user1.setBirthDate(dateFormat.parse("05.03.1991"));
            javaRush.users.add(user1);
            User user2 = new User();
            user2.setFirstName("Kuzmenko");
            user2.setLastName("Valeria");
            user2.setMale(false);
            user2.setCountry(User.Country.UKRAINE);

            user2.setBirthDate(dateFormat.parse("14.03.1993"));
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            JavaRush loadedObject2 = new JavaRush();
            loadedObject.load(inputStream);
            loadedObject2.load(inputStream);
            System.out.println(user1.getFirstName() + " " + user1.getBirthDate() + " " + user1.getLastName() + " " + user1.getCountry() + " ");
            System.out.println(user1.isMale());
            System.out.println(loadedObject.users.get(0).getFirstName() + " " + loadedObject.users.get(0).getBirthDate() + " " + loadedObject.users.get(0).getLastName() + " " + loadedObject.users.get(0).getCountry());
            System.out.println(loadedObject.users.get(1).isMale());
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        }
        catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush
    {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            PrintWriter pw = new PrintWriter(outputStream);
            DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            if (users.size() > 0)
            {
                for (int i = 0; i < users.size(); i++)
                {
                    pw.println("User");
                    if (users.get(i).getFirstName() != null)
                    {
                        pw.println("firstName");
                        pw.println(users.get(i).getFirstName());
                    }
                    if (users.get(i).getLastName() != null)
                    {
                        pw.println("LastName");
                        pw.println(users.get(i).getLastName());
                    }
                    if (users.get(i).getBirthDate() != null)
                    {
                        pw.println("BirthDate");
                        pw.println(format.format(users.get(i).getBirthDate()));
                    }
                    if (users.get(i).isMale() == true)
                    {
                        pw.println("Male");
                        pw.println(users.get(i).isMale());
                    }
                    if (users.get(i).isMale() == false)
                    {
                        pw.println("Male");
                        pw.println(users.get(i).isMale());
                    }
                    if (users.get(i).getCountry() != null)
                    {
                        pw.print("Country" + "\n");
                        pw.print(users.get(i).getCountry() + "\n");
                    }
                }
            }
            pw.close();
        }

        public void load(InputStream inputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            String check;
            while (br.ready())
            {
                if (((check = br.readLine()).equals("User")))
                {
                    User user = new User();
                    if ((check = br.readLine()).equals("firstName"))
                    {
                        user.setFirstName(br.readLine());
                    }
                    if ((check = br.readLine()).equals("LastName"))
                        user.setLastName(br.readLine());
                    if ((check = br.readLine()).equals("BirthDate"))
                        user.setBirthDate(format.parse(br.readLine()));
                    if ((check = br.readLine()).equals("Male"))
                    {
                        boolean b = Boolean.parseBoolean(br.readLine());
                        user.setMale(b);
                    }
                    if ((check = br.readLine()).equals("Country"))
                    {
                        user.setCountry(User.Country.valueOf(br.readLine()));
                    }
                    users.add(user);
                }
            }
            br.close();
        }
    }
}

