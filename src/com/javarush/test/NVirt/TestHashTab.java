package com.javarush.test.NVirt;

/**
 * Created by Golitsyn.SN on 01.06.2016.
 *
 * Искренне надеюсь, что понял Н.Вирта и мое решение Вас устроит
 *
 */
public class TestHashTab {
    static VirtTab vt;

    public static void main(String[] args) {
        // создаем рандомные массивы
        vt = new VirtTab();
        char[] arrChar = randChar();
        char[] gettingChar = arrChar;
        int[] arrInt = randInt();
        for (char c : arrChar)
            System.out.print(c + " ");
        System.out.println();
        for (int c : arrInt)
            System.out.print(c + " ");
        System.out.println();
        //  пара для добавления в таблицу
        Pair testPair = new Pair(arrChar, arrInt);
        vt.put(testPair.getKey(), testPair.getValue());
        System.out.println(vt.put(testPair.getKey(), testPair.getValue()));
        int[] resultGet = vt.get(gettingChar);
        for (int c : resultGet)
            System.out.print(c + " ");
        System.out.println();
        vt.del(gettingChar);
        resultGet = vt.get(gettingChar);
        try {
            System.out.println(resultGet.length);
        } catch (NullPointerException e) {
            System.out.println("resultGet == null");
        }

        //проверяем что бы ключ небыл слишком большим
        // выбрасываем исключение, если ключ больше, чем может быть
        /*Pair testPairTwo = new Pair();
        char[] bigChar = new char[]{'1', '2', '3', '4', '5', '5', '6', '7', '8', '9', '0', '1', '1', '1', '1', '1', '1', '1', '2', '1', '4', '5', '5', '6', '7', '8', '9', '0', '1', '1', '1', '1', '1', '1'};
        testPairTwo.setKey(bigChar);
        System.out.println(testPairTwo.getKey());*/


    }

    static char[] randChar() {
        char[] c = new char[(int) (Math.random() * Pair.WORDLEN)];
        for (int i = 0; i < c.length; i++) {
            c[i] = (char) (Math.random() * 1000 + 1);
        }
        return c;
    }

    static int[] randInt() {
        int[] c = new int[(int) (Math.random() * Pair.NOC)];
        for (int i = 0; i < c.length; i++) {
            c[i] = (int) (Math.random() * 1000 + 1);
        }
        return c;
    }
}
