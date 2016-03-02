package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        try
        {
            String fileName;
            while (!(fileName = reader.readLine()).equals("exit"))
            {
                list.add(fileName);
            }
            reader.close();
            for (String s : list)
            {
                ReadThread rt = new ReadThread(s);
                rt.start();
                rt.join();
            }
            // System.out.println(resultMap);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static class ReadThread extends Thread
    {
        private String fileName;

        public ReadThread(String fileName)
        {
            this.fileName = fileName;
        }

        @Override
        public void run()
        {
            ArrayList<Integer> listInt = new ArrayList<>();
            try
            {
                FileInputStream stream = new FileInputStream(fileName);
                while (stream.available() > 0)
                {
                    listInt.add(stream.read());
                }
                stream.close();

                int max = 0, find = 0;

                for (int i = 0; i < listInt.size(); i++)
                {
                    int freq = Collections.frequency(listInt, listInt.get(i));
                    if (freq > max)
                    {
                        max = freq;
                        find = listInt.get(i);
                    }
                }
                resultMap.put(fileName, find);
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
