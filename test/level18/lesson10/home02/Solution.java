package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.text.NumberFormat;



public class Solution {
    public static void main(String[] args) throws IOException
    {
        int whiteSpase=0;
        int simvol=0;
        FileInputStream stream = new FileInputStream(args[0]);
        while(stream.available()>0){
               simvol++;
            if (stream.read()==' ')
            {
                whiteSpase++;
            }
        }
        stream.close();
        double d = (double)whiteSpase/simvol*100;
      //  double f = round(d, 2, BigDecimal.ROUND_HALF_UP);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(d));
      //  System.out.println(f);

    }
  /*  public static double round (double unrounded, int precision, int roundingMode)
    {
        BigDecimal bd = new BigDecimal(unrounded);
        BigDecimal rounded = bd.setScale(precision, roundingMode);
        return rounded.doubleValue();
    }*/
}
