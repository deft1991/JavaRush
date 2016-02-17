package com.javarush.test.level18.lesson08.task04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* UnsupportedFileName
Измените класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt)
Например, first.txt или name.1.part3.txt
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException
*/

public class TxtInputStream extends FileInputStream {
    public TxtInputStream(String fileName) throws FileNotFoundException, UnsupportedFileNameException
    {
        super(fileName);
        //getFIleExtention(fileName); // второй вариант, он прошел проверку
       if(!(fileName.endsWith(".txt")))
           throw new UnsupportedFileNameException();
    }
  /*
  Второй вариант, именно он прошел проверку
  public String getFIleExtention(String fileName) throws UnsupportedFileNameException
    {
        int dotPos = fileName.lastIndexOf(".");
        if (fileName.substring(dotPos, (fileName.length())).equals(".txt"))
        {
            return fileName;
        }
        else throw new UnsupportedFileNameException();
    }*/

    public static void main(String[] args) throws FileNotFoundException, UnsupportedFileNameException
    {
        TxtInputStream txt = new TxtInputStream("C:\\temp\\file1.txt");
    }
}

