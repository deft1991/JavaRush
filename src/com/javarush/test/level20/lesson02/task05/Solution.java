package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Разберитесь почему не работает метод main()
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(java.lang.String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Object object = new Object();
            object.string1 = new String();   //string #1
            object.string2 = new String();   //string #2
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String(); //string #3
            loadedObject.string2 = new String(); //string #4

             object.string1.print();
             object.string2.print();

            loadedObject.load(inputStream);

              loadedObject.string1.print();
             loadedObject.string2.print();

             System.out.println(countStrings + "=========");

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);

            java.lang.String isString1Present = (string1 != null) ? "yes" : "no";
            printWriter.println(isString1Present);
            if (string1 != null) {
                printWriter.println(string1.number - 1);
            }
            java.lang.String isString2Present = string2 != null ? "yes" : "no";
            printWriter.println(isString2Present);
            if (string2 != null) {
                printWriter.println(string2.number - 1);
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws IOException {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            java.lang.String isString1Presented = "";
            if ((isString1Presented = reader.readLine()).equals("yes")) {
                countStrings = Integer.parseInt(reader.readLine());
                this.string1 = new String();
                countStrings = countStrings + 2;
            }
            java.lang.String isString2Presented = reader.readLine();
            if (isString2Presented.equals("yes")) {
                countStrings = Integer.parseInt(reader.readLine());
                this.string2 = new String();
                countStrings = countStrings + 2;
            }

        }
    }

    public static int countStrings;

    public static class String {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
