package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources

C:\temp\file1.txt
C:\temp\file2.txt
C:\temp\file3.txt

*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();

        FileInputStream stream1 = new FileInputStream(file1);
        byte[]buffer = new byte[stream1.available()];
        FileOutputStream stream2 = new FileOutputStream(file2);
        FileOutputStream stream3 = new FileOutputStream(file3);
        if (stream1.available() > 0)
        {
            int count = stream1.read(buffer);
        }
      if (buffer.length%2==0){
          stream2.write(buffer,0,buffer.length/2);
          byte[]buff = new byte[buffer.length/2];
          int j=0;
              for (int i =(buffer.length/2) ; i < buffer.length; i++)
              {
                  buff[j] = buffer[i];
                    j++;
              }
          stream3.write(buff,0,buff.length);
      }
        else {
          stream2.write(buffer,0,(buffer.length/2)+1);
          byte[]buff = new byte[(buffer.length/2)];
          int j=0;
          for(int i=(buffer.length/2)+1;i<buffer.length;i++)
          {
              buff[j] = buffer[i];
              j++;
          }
              stream3.write(buff,0,buff.length);
          }
        stream1.close();
        stream2.close();
        stream3.close();

    }
}
