package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
+productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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
    public static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception
    {
        String quantity=String.valueOf(args[args.length-1]);
        String price=String.valueOf(args[args.length-2]);
        String name="";
        for(int i=1;i<args.length-2;i++){
            name+=args[i]+" ";
        }
        list.add(name.substring(0,name.length()-1));
        list.add(price);
        list.add(quantity);
        findId();

    }

   /* public static void createListFields(String stroka) throws IOException
    {
        String[] arguments = stroka.split(" ");
        String quantity = arguments[arguments.length - 1];
        String price = arguments[arguments.length - 2];
        String name = "";
        for (int i = 1; i < arguments.length - 2; i++)
        {
            name += arguments[i] + " ";
        }
        String productName = name.substring(0, name.length()-1);
        list.add(productName);
        list.add(price);
        list.add(quantity);
    }*/

    public static void findId() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        fileName = reader.readLine();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        int maxId= 0;
        while ((line = br.readLine()) != null)
        {
            String[]massiv = line.split(" ");
            if (massiv[0].length()<8)
            {
                if (maxId < Integer.parseInt(massiv[0]))
                    maxId = Integer.parseInt(massiv[0]);
            }
            else{
                String znach = massiv[0].substring(0,8);
                if (maxId < Integer.parseInt(znach))
                    maxId = Integer.parseInt(znach);
            }
        }
        reader.close();
        br.close();
        FileWriter fileWriter = new FileWriter(fileName, true);
        String idForWrite = formatPriceAndId(String.valueOf(maxId+1));
        String nameForWrite = formatName(list.get(0));
        String priceForWrite = formatPriceAndId(list.get(1));
        String quantutyForWrite = formatQuantity(list.get(2));
        fileWriter.write("\n" + idForWrite + nameForWrite + priceForWrite + quantutyForWrite);
        fileWriter.close();

    }

    public static String formatName(String name)
    {
        if (name.length() > 30)
        {
            name = name.substring(0, 30);
        } else
        {
            int size = 30 - name.length();
            for (int i = 0; i < size; i++)
                name += " ";
        }
        return name;
    }

    public static String formatPriceAndId(String price)
    {
        if (price.length() > 8)
            price = price.substring(0, 8);
        else
        {
            int size = 8 - price.length();
            for (int i = 0; i < size; i++)
                price += " ";
        }
        return price;
    }


    public static String formatQuantity(String quantity)
    {
        if (quantity.length() > 4)
            quantity = quantity.substring(0, 4);
        else
        {
            int size = 4 - quantity.length();
            for (int i = 0; i < size; i++)
                quantity += " ";
        }
        return quantity;
    }
}
