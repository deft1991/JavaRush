package com.javarush.test.level20.lesson04.task04;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* Как сериализовать static?
Сделайте так, чтобы сериализация класса ClassWithStatic была возможной
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public void serializeStatic(ObjectOutputStream oos) throws IOException {
            oos.writeObject(staticString);
        }
        public void deserializeStatic(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            staticString = (String)ois.readObject();
        }
    }
}
