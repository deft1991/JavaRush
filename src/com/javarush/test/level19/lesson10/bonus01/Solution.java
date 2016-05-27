package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5

C:\temp\file1.txt
C:\temp\file2.txt

*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static List<String> list1 = new ArrayList<String>();
    public static List<String> list2 = new ArrayList<String>();
    public static List<LineItem> sameList = new ArrayList<>();
    public static List<LineItem> remAddList = new ArrayList<>();
    static int min=0;
    static int index;

    public static void bugaga(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1name = reader.readLine();
            String file2name = reader.readLine();
            reader.close();

            BufferedReader br1 = new BufferedReader(new FileReader(file1name));
            String line="";
            while ((line = br1.readLine())!=null)
                list1.add(line);
            br1.close();
            BufferedReader br2 = new BufferedReader(new FileReader(file2name));
            while ((line = br2.readLine())!=null)
                list2.add(line);
            br2.close();

            min = Math.min(list1.size(),list2.size());

            for(index=0;index<min;index++){
                if (list1.get(index).equals(list2.get(index))) {
                    sameList.add(new LineItem(Type.SAME, list1.get(index)));
                }
                if (list1.get(index).compareTo(list2.get(index))>0){
                    remAddList.add(new LineItem(Type.REMOVED,list1.get(index)));
                }
                if (list1.get(index).compareTo(list2.get(index))<0){
                    remAddList.add(new LineItem(Type.ADDED,list2.get(index)));
                }
            }


 /*
C:\temp\file1.txt
C:\temp\file2.txt
 */
            if (min==list1.size()&&list2.size()==min){
            }
            if (min==list1.size()) {
                remAddList.add(new LineItem(Type.ADDED, list2.get(min)));
            }
            if (min==list2.size()) {
                remAddList.add(new LineItem(Type.ADDED, list1.get(min)));
            }

            System.out.println(list1.size()+" "+list2.size());
            System.out.println(min);
            for (int i=0;i<min;i++){
                lines.add(new LineItem(sameList.get(i).type,sameList.get(i).line));
                lines.add(new LineItem(remAddList.get(i).type,remAddList.get(i).line));
            }
            System.out.println(lines.get(0).type+" "+lines.get(0).type);

        }
        catch (IndexOutOfBoundsException e)
        {

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
            bugaga();
           for (LineItem li : lines)
               System.out.println(li.type+" "+li.line);
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
