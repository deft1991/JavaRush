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
        int[] arrInt = randInt();
        char[] gettingChar = arrChar;

        System.out.print("arr char : ");
        for (char c : arrChar)
            System.out.print(c + " ");
        System.out.println();

        System.out.print("arr int : ");
        for (int c : arrInt)
            System.out.print(c + " ");
        System.out.println();

        //  пара для добавления в таблицу
        Pair testPair = new Pair(arrChar, arrInt);
        vt.put(testPair.getKey(), testPair.getValue());
        System.out.print("Result put : ");
        System.out.println(vt.put(testPair.getKey(), testPair.getValue()));
        System.out.println("linesCount after put : "+linesCount());
        System.out.println("***************************************");

        int[] resultGet = vt.get(gettingChar);
        System.out.print("resultGet : ");
        for (int c : resultGet)
            System.out.print(c + " ");
        System.out.println();
        System.out.println("linesCount after get : "+linesCount());
        System.out.println("******************************************");

        // удаляем пару
        vt.del(gettingChar);
        resultGet = vt.get(gettingChar);
        try {
            System.out.println(resultGet.length);
        } catch (NullPointerException e) {
            System.out.println("resultGet == null");
        }
        System.out.println("linesCount after del : "+linesCount());
        System.out.println("**********************************************");

        //проверяем что бы ключ небыл слишком большим
        // выбрасываем исключение, если ключ больше, чем может быть
        /*Pair testPairTwo = new Pair();
        char[] bigChar = new char[]{'1', '2', '3', '4', '5', '5', '6', '7', '8', '9', '0', '1', '1', '1', '1', '1', '1', '1', '2', '1', '4', '5', '5', '6', '7', '8', '9', '0', '1', '1', '1', '1', '1', '1'};
        testPairTwo.setKey(bigChar);
        System.out.println(testPairTwo.getKey());*/

        // добавляем еще пары и проверяем колличество не пустых пар
        char[] gettingChar3 = randChar();
        int[] arrInt3 = randInt();
        char[] gettingChar4 = randChar();
        int[] arrInt4 = randInt();
        char[] gettingChar5 = randChar();
        int[] arrInt5 = randInt();
        char[] gettingChar6 = randChar();
        int[] arrInt6 = randInt();
        char[] gettingChar7 = randChar();
        int[] arrInt7 = randInt();
        Pair testPairThree = new Pair(gettingChar3,arrInt3);
        Pair testPair4 = new Pair(gettingChar4,arrInt4);
        Pair testPair5 = new Pair(gettingChar5,arrInt5);
        Pair testPair6 = new Pair(gettingChar6,arrInt6);
        Pair testPair7 = new Pair(gettingChar7,arrInt7);
        vt.put(testPairThree.getKey(),testPairThree.getValue());
        System.out.println(testPairThree.getKey());
        System.out.println("Lines count : "+ linesCount());
        System.out.println("********************************************");
        vt.put(testPair4.getKey(),testPairThree.getValue());
        System.out.println(testPair4.getKey());
        System.out.println("Lines count : "+ linesCount());
        System.out.println("********************************************");
        vt.put(testPair5.getKey(),testPairThree.getValue());
        System.out.println(testPair5.getKey());
        System.out.println("Lines count : "+ linesCount());
        System.out.println("********************************************");
        vt.put(testPair6.getKey(),testPairThree.getValue());
        System.out.println(testPair6.getKey());
        System.out.println("Lines count : "+ linesCount());
        System.out.println("********************************************");
        vt.put(testPair7.getKey(),testPairThree.getValue());
        System.out.println(testPair7.getKey());
        System.out.println("Lines count : "+ linesCount());
        System.out.println("********************************************");

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

    static int linesCount() {
        int count = 0;
        for (int i = 0; i < vt.table.length; i++) {
            // try {
            if (vt.table[i] == null)
                continue;
            if (vt.table[i].getKey() != null && !vt.table[i].isDeleted())
                count++;

            //  } catch (NullPointerException e) {
            //  }
        }
        return count;
    }
}
