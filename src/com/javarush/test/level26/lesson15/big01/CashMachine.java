package com.javarush.test.level26.lesson15.big01;
import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;

import java.util.Locale;

/**
 * Created by Golitsyn.SN on 16.06.2016.
 */
/*2. Давайте запустим прогу и пополним счет на EUR 100 2 и USD 20 6, и посмотрим на INFO.
Ничего не понятно, т.к. создались 2 манипулятора: первый для EUR, второй для USD.
Давайте улучшим логику InfoCommand. Надо вывести баланс по каждому манипулятору.
2.2. В InfoCommand в цикле выведите [код валюты - общая сумма денег для выбранной валюты]
Запустим прогу и пополним счет на EUR 100 2 и USD 20 6, и посмотрим на INFO.
Все работает правильно?
 EUR - 200
 USD - 120
Отлично!
*/

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Operation op;

        do{
            op = ConsoleHelper.askOperation();
            CommandExecutor.execute(op);
        }while(!op.equals(Operation.EXIT));
    }
}

