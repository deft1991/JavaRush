package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by Golitsyn.SN on 16.06.2016.
 */

public class ConsoleHelper {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        while (true) {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    public static String askCurrencyCode() {
        while (true) {
            writeMessage("Введите код валюты: ");
            String str = readString();
            if (str.length() != 3) {
                writeMessage("Неверный код валюты! Введите заново.");
            } else {
                return str.toUpperCase();
            }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) {
        while (true) {
            writeMessage("Введите два целых положительных числа. Первое - номинал, второе - количество банкнот: ");
            String userInput = readString();
            String[] strmas = userInput.split(" ");
            try {
                if (strmas.length == 2 && Integer.parseInt(strmas[0]) >= 0 && Integer.parseInt(strmas[1]) >= 0) {
                    return strmas;
                } else {
                    writeMessage("Введены неверные данные, повторите ввод!");
                }
            } catch (NumberFormatException ex) {
                writeMessage("Введены неверные данные, повторите ввод!");
            }
        }
    }

    public static Operation askOperation() {
        writeMessage("Введите код операции: 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
        while(true){
            try {
                String operationCode = readString();
                int code = Integer.parseInt(operationCode);
                if (code ==1||code == 2||code==3||code==4)
                {
                Operation op = Operation.getAllowableOperationByOrdinal(code);
                return op;
                }
                else{
                    writeMessage("Введен неверный код. Попробуй еще.");
                }
            }catch (Exception e){
                writeMessage("try again");
                continue;
            }
        }
    }
}
