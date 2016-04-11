package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String file1Name = args[0];
        String file2Name = args[1];
        File file1 = new File(file1Name);
        File file2 = new File(file2Name);
        BufferedReader file1Reader = new BufferedReader(new FileReader(file1));
        FileWriter fileWriter = new FileWriter(file2);

        ArrayList<String> list = new ArrayList<String>();
        String stroka;
        char[] cifri = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        while ((stroka = file1Reader.readLine()) != null)
        {
            String[] slova = stroka.split(" ");
            for (int i = 0; i < slova.length; i++)
            {
                char[] simvoli = slova[i].toCharArray();
                for (char c : simvoli)
                {
                    for (char k : cifri)
                    {
                        if (c == k)
                        {
                            list.add(slova[i]);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < list.size(); i++)
        {
            for (int j = list.size() - 1; j > i; j--)
            {
                if (list.get(i).equals(list.get(j)))
                {
                    list.remove(i);
                }
            }

        }
        String qq = "";
        for (String s : list)
        {
            qq += s + " ";
        }


        fileWriter.write(qq.substring(0, qq.length() - 1));
        file1Reader.close();
        fileWriter.close();
    }

}
