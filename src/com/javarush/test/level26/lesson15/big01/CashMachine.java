package com.javarush.test.level26.lesson15.big01;
import java.util.Locale;

/**
 * Created by Golitsyn.SN on 16.06.2016.
 */

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Operation op = ConsoleHelper.askOperation();
        String curCode = ConsoleHelper.askCurrencyCode();

       switch (op) {
            case DEPOSIT: {
                try {

                    String[] str = ConsoleHelper.getValidTwoDigits(curCode);
                    CurrencyManipulatorFactory.getManipulatorByCurrencyCode(curCode).addAmount(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }
           case INFO:{
               CurrencyManipulatorFactory.getManipulatorByCurrencyCode(curCode).getTotalAmount();
             //  System.out.println( CurrencyManipulatorFactory.getManipulatorByCurrencyCode(curCode).getTotalAmount());
           }
        }
    }
}

