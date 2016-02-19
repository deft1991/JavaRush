package com.javarush.test.level18.lesson10.home03;

/* Два в одном
+Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();

        FileOutputStream stream1 = new FileOutputStream(file1);
        FileInputStream stream2 = new FileInputStream(file2);
        FileInputStream stream3 = new FileInputStream(file3);
        while (stream2.available() > 0)
        {
            stream1.write(stream2.read());
        }
        byte[]buffer = new byte[stream3.available()];//+stream2.available()];
        while(stream3.available()>0){
           int st3 = stream3.read(buffer);
            stream1.write(buffer,0,st3);
        }
        stream1.close();
        stream2.close();
        stream3.close();
    }
}
