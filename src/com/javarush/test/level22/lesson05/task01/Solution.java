package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
        //System.out.println(getPartOfString(null));
        // System.out.println(getPartOfString(""));
        //System.out.println(getPartOfString("abcde"));
        //   System.out.println(getPartOfString("a b c d e"));
        System.out.println(getPartOfString("Мама мыла грязную раму а папа?"));
        // System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));

    }

    public static String getPartOfString(String string) {
        // string = string.substring(string.indexOf(" ")+1);
        try {
            int i = 0;
            int index = 0;
            while (i < 5) {
                index = string.indexOf("@", index + 1);
                i++;
            }
            return string.substring(string.indexOf("@") + 1, index);
        } catch (Exception e) {
            throw new TooShortStringException();
        }

    }

    public static class TooShortStringException extends RuntimeException {
    }
}
