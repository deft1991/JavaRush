package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {
    public static class A {
        public String name = "A";

        public A() {
        }

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp.tmp"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("temp.tmp"));

        Solution sol = new Solution();
        Solution.B test = sol.new B("qqq");
        oos.writeObject(test);

        oos.flush();
        oos.close();

        System.out.println(test.name);
        B load = (B) ois.readObject();
        ois.close();
        System.out.println(load.name);
    }
}
