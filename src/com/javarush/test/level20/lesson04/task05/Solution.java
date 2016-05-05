package com.javarush.test.level20.lesson04.task05;

import java.io.*;

/* Как сериализовать что-то свое?
Сделайте так, чтобы сериализация класса Object была возможной
*/
public class Solution {
    public static void main(java.lang.String[] args) throws IOException, ClassNotFoundException {
        Object ob = new Object();
        ob.string1 = new String();
        ob.string2 = new String();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp.tmp"));
        oos.writeObject(ob);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("temp.tmp"));
        Object deserializeOb = new Object();
        deserializeOb = (Object) ois.readObject();
        ois.close();
        System.out.println(ob);
        System.out.println(deserializeOb);

    }

    public static class Object implements Serializable {
        public String string1;
        public String string2;

    }

    public static int countStrings;

    public static class String implements Serializable {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
