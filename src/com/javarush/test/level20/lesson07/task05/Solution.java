package com.javarush.test.level20.lesson07.task05;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.
Hint/Подсказка:
Конструктор не вызывается при сериализации, только инициализируются все поля.
*/
public class Solution implements Serializable, Runnable {
    transient private Thread runner;
    private int speed;
    private int dateForTest;

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Solution test = new Solution(15);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp.txt"));
        oos.writeObject(test);
        oos.flush();
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("temp.txt"));
        Solution load = (Solution)ois.readObject();
        System.out.println(test.dateForTest);
        System.out.println(load.dateForTest);


    }
    public Solution(int speed) {
        dateForTest = new GregorianCalendar().getTime().getSeconds();
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, does not matter
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException, InterruptedException {
        in.defaultReadObject();
        startRunner();
    }
    private void startRunner() throws InterruptedException {
        runner = new Thread(this);
        runner.start();
        dateForTest = 111123123;

    }
}
