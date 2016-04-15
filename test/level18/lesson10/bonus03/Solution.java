package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234

C:\temp\file1.txt

*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    static String fileName = "";

    static
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException
    {
        if (args[0] != null)
        {
            if (args[0].equals("-u"))
            {
                update(args[1], args[2], args[3], args[4]);
            }
            if (args[0].equals("-d"))
            {
                delete(args[1]);
            }
        }
    }

    // -u id productName price quantity
    /*Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id

1       Шорты пляжные синие           159.00  12
2       Шорты пляжные черные с рисунко173.00  17
13      Куртка для сноубордистов, разм10173.991234

*/
    public static void update(String id, String productName, String price, String quantity) throws IOException
    {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String stroka;
        String updateProduct = formatIdAndPrice(id) + formatProductName(productName) + formatIdAndPrice(price) + formatQuantity(quantity);
        ArrayList<String> list = new ArrayList<>();
        while ((stroka = fileReader.readLine()) != null)
        {
            String[] arrWords = stroka.split(" ");
            if (arrWords[0].length() < 8)
            {
                if (id.equals(arrWords[0]))
                    list.add(updateProduct+"\n");
                else list.add(stroka+"\n");
            } else
            {
                String findId = arrWords[0].substring(0, 8);
                if (id.equals(findId))
                {
                    list.add(updateProduct+"\n");
                } else list.add(stroka+"\n");
            }

        }
        fileReader.close();
        FileWriter fileWriter = new FileWriter(fileName);
        for(int i=0;i<list.size();i++)
            fileWriter.write(list.get(i));
        fileWriter.close();
    }

    public static void delete(String id) throws IOException
    {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> list = new ArrayList<>();
        String stroka;
        while ((stroka = fileReader.readLine()) != null)
        {
            String[] arrWords = stroka.split(" ");
            if (arrWords[0].length() < 8)
            { // если айди из цифорок то его длинна максимум 8 символов
                if (id.equals(arrWords[0]))
                    continue;
                else list.add(stroka + "\n");
            } else
            { // если айди больше 8 символов то он не сплитится и нужно отделить слово
                String findId = arrWords[0].substring(0, 8);
                System.out.println(findId);
                if (id.equals(findId))
                    continue;
                else list.add(stroka + "\n");
            }
        }
        fileReader.close();
        FileWriter fileWriter = new FileWriter(fileName);
        for (int i = 0; i < list.size(); i++)
            fileWriter.write(list.get(i));
        fileWriter.close();
    }

    public static String formatIdAndPrice(String idOrPrice)
    {
        if (idOrPrice.length() < 8)
        {
            int size = idOrPrice.length();
            for (int i = 0; i < (8 - size); i++)
            {
                idOrPrice += " ";
            }
        } else idOrPrice = idOrPrice.substring(0, 8);
        return idOrPrice;
    }

    public static String formatProductName(String productName)
    {
        if (productName.length() < 30)
        {
            int size = productName.length();
            for (int i = 0; i < (30 - size); i++)
            {
                productName += " ";
            }
        } else productName = productName.substring(0, 30);
        return productName;
    }

    public static String formatQuantity(String quantity)
    {
        if (quantity.length() < 4)
        {
            int size = quantity.length();
            for (int i = 0; i < (4 - size); i++)
            {
                quantity += " ";
            }
        } else quantity = quantity.substring(0, 4);
        return quantity;
    }
}
