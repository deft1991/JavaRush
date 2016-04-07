package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные

-e C:\temp\file1.txt C:\temp\file2.txt
-d C:\temp\file2.txt C:\temp\file1.txt

*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        if (args[0] != null)
        {
            if (args[0].equals("-e"))
            {
            crypt(args[1],args[2]);
            }
            if (args[0].equals("-d"))
            {
            deCrypt(args[1],args[2]);
            }
        }
    }
    static void crypt(String fileName,String fileOutputName) throws IOException
    {
        System.out.println(fileName);
        System.out.println(fileOutputName);
        File fileInp = new File(fileName);
        File fileOut = new File(fileOutputName);
        BufferedReader br = new BufferedReader(new FileReader(fileInp));
        BufferedWriter wr = new BufferedWriter(new FileWriter(fileOut));
        String stroka;
        int c;
        char[]buffer = new char[(char)fileInp.length()];
        while((c=br.read())!=-1){
            wr.write(c+'1');
        }
        br.close();
        wr.close();
    }
    static void deCrypt(String fileName,String fileOutputName) throws IOException
    {
        System.out.println(fileName);
        System.out.println(fileOutputName);
        File fileInp = new File(fileName);
        File fileOut = new File(fileOutputName);
        BufferedReader br = new BufferedReader(new FileReader(fileInp));
        BufferedWriter wr = new BufferedWriter(new FileWriter(fileOut));
        String stroka;
        int c;
        char[]buffer = new char[(char)fileInp.length()];
        while((c=br.read())!=-1){
            wr.write(c-'1');
        }
        br.close();
        wr.close();
    }

}
