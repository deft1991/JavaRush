package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

   /* public static void main(String[] args) {
        Solution s = new Solution();
        s.fillInPropertiesMap();
        for (Map.Entry<String, String> pair : properties.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        System.out.println(properties.size());

    }*/

    public void fillInPropertiesMap() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        try {
            fileName = reader.readLine();
            reader.close();
            FileInputStream is = new FileInputStream(new File(fileName));
            load(is);
            FileOutputStream os = new FileOutputStream(new File("C:\\temp\\file2.txt"));
            Properties pr = new Properties();
            save(os);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) {
        Properties pr = new Properties();
        for (Map.Entry<String, String> pair : properties.entrySet()) {
            pr.put(pair.getKey(), pair.getValue());
        }
        pr.save(outputStream, null);
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) {
        Properties pr = new Properties();
        try {
            pr.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Enumeration<?> e = pr.propertyNames();
        while (e.hasMoreElements()) {
            String temp = (String) e.nextElement();
            properties.put(temp, pr.getProperty(temp));
        }
        try {
            inputStream.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        //implement this method - реализуйте этот метод
    }
}
