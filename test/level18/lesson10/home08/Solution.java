package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.lang.management.BufferPoolMXBean;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
+Читайте с консоли имена файлов, пока не будет введено слово "exit"
+Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        String fileName;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!(fileName = reader.readLine()).equals("exit"))
        {
            ReadThread thread = new ReadThread(fileName);
        }
    }
    public static class ReadThread extends Thread
    {
        private String fileName;

        public ReadThread(String fileName)
        {
            this.fileName = fileName;
            start();
            //implement constructor body
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public  void run()
        {
            poisk(fileName);
        }
    }

    public static void poisk(String fileName)
    {
        try
        {
            FileInputStream stream = new FileInputStream(fileName);
            HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();
            byte[] buffer = new byte[stream.available()];
            if (stream.available() > 0)
                stream.read(buffer);
            stream.close();
            int count = 0, max = 0;
            for (int i = 0; i < buffer.length; i++)
            {
                for (int j = 0; j < buffer.length - 1; j++)
                {
                    if (buffer[i] == buffer[j])
                        count++;
                }
                map.put(buffer[i], count);
                count=0;
            }
            for (Map.Entry<Byte, Integer> pair : map.entrySet())
            {
                if (pair.getValue() > max)
                {
                    max = pair.getValue();
                }
            }
            synchronized (resultMap)
            {
                for (Map.Entry<Byte, Integer> pair : map.entrySet())
                {
                    if (pair.getValue().equals(max))
                    {
                        resultMap.put(fileName, (int) pair.getKey());
                    }
                }
            }
            stream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
