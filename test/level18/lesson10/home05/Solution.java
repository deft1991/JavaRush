package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4

C:\temp\file1.txt
C:\temp\file2.txt

*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileInputStream stream1 = new FileInputStream(file1);
        FileWriter stream2 = new FileWriter(file2,true);

        String stroka = new String();
        byte[] buffer = new byte[stream1.available()];
        stream1.read(buffer);
        // создаем строку
        for (int i = 0; i < buffer.length; i++)
            stroka = stroka + (char) buffer[i];
        // создали массив значений из файла
        String[] parts = stroka.split(" ");
        /*for (int i = 0; i < parts.length; i++)
            System.out.println(parts[i]);*/
        for(int i =0;i<parts.length;i++){
            Double j =Double.parseDouble(parts[i]);
            int rez = round(j);
            String konec = String.valueOf(rez);
            stream2.write(rez + " ");
            stream2.flush();
        }
        stream1.close();
        stream2.close();
    }

    // Алгоритм округления до целого
    public static int round(double i)
    {
        float newI = Math.round(i);
        int rez = (int) newI;
        return rez;
    }
}
