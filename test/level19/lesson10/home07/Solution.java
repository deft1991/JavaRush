package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String file1Name = args[0];
        String file2Name = args[1];
        File file2 = new File(file2Name);
        BufferedReader br = new BufferedReader(new FileReader(file1Name));
        FileWriter fileWriter = new FileWriter(file2);
        String stroka;
        String forWrite="";
        while((stroka=br.readLine())!=null){
            String[]slova = stroka.split(" ");
            for(int i=0;i<slova.length;i++){
                if (slova[i].length()>6)
                    forWrite +=slova[i]+",";
            }
        }
        br.close();
        fileWriter.write(forWrite.substring(0,forWrite.length()-1));
        fileWriter.close();

    }
}
