package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources

C:\temp\file1.txt
C:\temp\file2.txt

*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        RandomAccessFile stream1 = new RandomAccessFile(file1, "rw");
        RandomAccessFile stream2 = new RandomAccessFile(file2, "r");

        for (int i = 0; i < stream2.length(); i++)
            list2.add(stream2.read());
        for (int i = 0; i < stream1.length(); i++)
            list1.add(stream1.read());

        stream1.seek(0);

        for (int i = 0; i < list2.size(); i++)
            stream1.write(list2.get(i));

        stream1.seek(stream1.length());

        for (int i = 0; i < list1.size(); i++)
            stream1.write(list1.get(i));

        stream1.close();
        stream2.close();

       /* BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileInputStream stream1 = new FileInputStream(file1);
        byte[] buffer1 = new byte[stream1.available()];
        stream1.read(buffer1);
        stream1.close();

        FileInputStream stream2 = new FileInputStream(file2);
        byte[] buffer2 = new byte[stream2.available()];
        stream2.read(buffer2);
        stream2.close();

        FileOutputStream streamOut = new FileOutputStream(file1);
        streamOut.write(buffer2);
        streamOut.write(buffer1);
        streamOut.close();*/
    }


}
