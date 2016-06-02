package com.javarush.test.NVirt;

/**
 * Created by Golitsyn.SN on 01.06.2016.
 */
public class TestHashTab {
 static VirtTab vt = new VirtTab();

    public static void main(String[] args) {
        // создаем рандомные массивы
        VirtTab vt = new VirtTab();
        char[] arrChar = randChar();
        char[] gettingChar = arrChar;
        int[]arrInt = randInt();
        for (char c : arrChar)
            System.out.print(c+" ");
        System.out.println();
        for (int c : arrInt)
            System.out.print(c+" ");
        System.out.println();
        // пара для добавления в таблицу
        Pair testPair = new Pair(arrChar,arrInt);
        vt.put(testPair.getKey(),testPair.getValue());
        System.out.println(vt.put(testPair.getKey(),testPair.getValue()));
        int[]resultGet = vt.get(gettingChar);
        for (int c : resultGet)
            System.out.print(c+" ");
        System.out.println();
        vt.del(gettingChar);
       resultGet= vt.get(gettingChar);
       try {
           System.out.println(resultGet.length);
       }catch (NullPointerException e){
           System.out.println("resultGet == null");
       }


    }
   static char[] randChar(){
        char[]c = new char[(int) (Math.random()*Pair.WORDLEN)];
        for (int i=0;i<c.length;i++){
            c[i]= (char) (Math.random()*1000+1);
        }
        return c;
    }
   static int[] randInt(){
        int[]c = new int[(int) (Math.random()*Pair.NOC)];
        for (int i=0;i<c.length;i++){
            c[i]= (int)(Math.random()*1000+1);
        }
        return c;
    }
}
