package com.javarush.test.level20.lesson10.home06;

import java.io.*;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/
public class Solution implements Serializable {
    public static void main(String[] args) {

    }
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream oos) throws NotSerializableException {
            throw new NotSerializableException("not now!");
        }
        private void readObject(ObjectInputStream ois) throws NotSerializableException {
            throw new NotSerializableException("not now");
        }
    }
}
