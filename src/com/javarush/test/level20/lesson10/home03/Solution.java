package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс Test.HelloWorld не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp.txt"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("temp.txt"));
            Solution s = new Solution();
            Solution.B savedObject = s.new B("testik");
            oos.writeObject(savedObject);
            oos.flush();
            oos.close();
            Solution.B loadedObject = (B) ois.readObject();
            System.out.println(savedObject.name);
            System.out.println(loadedObject.name);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static class A {
        protected String name = "Test.HelloWorld";

        public A(String name) {
            this.name += name;
        }

        public A() {

        }


        private void writeObject(ObjectOutputStream oos) throws NotSerializableException {
            throw new NotSerializableException("Not now");
        }

        private void readObject(ObjectInputStream ois) throws NotSerializableException {
            throw new NotSerializableException("Not now!");
        }
    }

    public class B extends A implements Serializable {


        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream oos) throws IOException {
            oos.writeObject(name);
        }

        private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
           name= (String)ois.readObject();
        }
    }
}
