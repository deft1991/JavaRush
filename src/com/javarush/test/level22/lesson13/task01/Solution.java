package com.javarush.test.level22.lesson13.task01;

import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static void main(String[] args) {
        String[] s = getTokens("level22.lesson13.task01", ".");
        for (String qq : s)
            System.out.print(qq);
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        String[] slova = new String[stringTokenizer.countTokens()];
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            //slova[i] = "\""+stringTokenizer.nextToken()+"\", ";
            slova[i] = stringTokenizer.nextToken();
            i++;
        }
        // slova[slova.length-1]=slova[slova.length-1].substring(0,slova[slova.length-1].indexOf(","));
        return slova;
    }
}
