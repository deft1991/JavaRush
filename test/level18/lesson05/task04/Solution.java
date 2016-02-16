package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources

C:\temp\file1.txt
C:\temp\file2.txt

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileInputStream stream1 = new FileInputStream(file1);
        FileOutputStream stream2 = new FileOutputStream(file2);
        byte[] buffer = new byte[stream1.available()];
        if(stream1.available()>0){
            int count = stream1.read(buffer);
        }
        byte[]reverse = new byte[buffer.length];
        int j=0;
        for(int i = buffer.length-1;i>=0;i--){
            reverse[j]=buffer[i];
            j++;
        }
        stream2.write(reverse,0,reverse.length);
        stream1.close();
        stream2.close();
    }
}
