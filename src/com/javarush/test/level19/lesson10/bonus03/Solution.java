package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        String s = "Good news everyone!";

        StringTokenizer tokenizer =
                new StringTokenizer(s,"one");
        while (tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
            System.out.println(token);
        }
    /*    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "C:\\temp\\temp.txt"; // будет reader.readLine();
        String param = "span";                  // будет args[0]
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String stroka;
        StringBuilder sb = new StringBuilder();
        while ((stroka = br.readLine()) != null) {
            sb.append(stroka);
        }
        br.close();
        reader.close();
        System.out.println(sb);
        while (sb.toString().contains("<span")) {
            //TODO
            if (sb.toString().contains("<span")) {
                String kusok = sb.toString().substring(sb.toString().indexOf("<span"), sb.toString().indexOf("</span><span>") + 7);
                sb.delete(sb.indexOf("<span"), sb.indexOf("</span><span>") + 7);
                System.out.println(kusok);

                if (kusok.contains("<b>")) {
                    String temp = kusok.substring(kusok.indexOf("<span>"), kusok.indexOf("</span>") + 7);
                    System.out.println(temp);

                }
            }

        }*/
    }
}
