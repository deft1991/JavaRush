package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution  {
    public static void main(String[] args) {
        try {
            Solution s = new Solution();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp.tmp"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("temp.tmp"));
            Person savedPerson = new Person("qqq", "aaa", "russia", Sex.MALE);
            oos.writeObject(savedPerson);
            oos.flush();
            oos.close();
            Person loadedPerson = (Person) ois.readObject();
            ois.close();
            System.out.printf("%s  %s %s %s \n", savedPerson.firstName, savedPerson.lastName, savedPerson.country, savedPerson.sex.toString());
            System.out.println(savedPerson.logger);
            System.out.printf("%s  %s %s %s \n", loadedPerson.firstName, loadedPerson.lastName, loadedPerson.country, loadedPerson.sex.toString());
            System.out.println(loadedPerson.logger);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }
}
