package com.javarush.test.level20.lesson07.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("Pervoe imya", "Vtoroe imya", 25);
        Person mom = new Person("Luda", "Sergeeva", 52);
        Person dad = new Person("Koliya", "Golitsyn", 53);
        Person child1 = new Person("qqqqqqq", "aaaaaaaa", 12);
        Person child2 = new Person("wwwwwwwwww", "ssssssssss", 17);
        List<Person> childList = new ArrayList<>();
        childList.add(child1);
        childList.add(child2);
        person.setMother(mom);
        person.setFather(dad);
        person.setChildren(childList);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp.tmp"));
        oos.writeObject(person);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("temp.tmp"));
        Person res = null;
        res = (Person) ois.readObject();
        ois.close();
        System.out.println(person.firstName + " " + person.lastName + " " + person.age);
        System.out.println(res.firstName+" "+res.lastName+" "+res.age);
        System.out.println(person.children.get(0).firstName);
        System.out.println(res.children.get(0).firstName);
    }
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(){};

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            firstName = (String)in.readObject();
            lastName = (String)in.readObject();
            age = in.readInt();
            children = (List)in.readObject();
        }
    }
}
