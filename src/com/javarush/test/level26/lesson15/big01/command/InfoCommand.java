package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;

/**
 * Created by Golitsyn.SN on 16.06.2016.
 */
/*
2.2. В InfoCommand в цикле выведите [код валюты - общая сумма денег для выбранной валюты]
4. В InfoCommand используйте метод п.3. и выведите фразу "No money available.", если нет денег в банкомате.
*/

class InfoCommand implements Command {
    @Override
    public void execute() {
        Collection <CurrencyManipulator> manipulatorMap=CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if (manipulatorMap.isEmpty())
            ConsoleHelper.writeMessage("No money available.");
        for (CurrencyManipulator cm : manipulatorMap){
            if (cm.hasMoney())
                ConsoleHelper.writeMessage(cm.getCurrencyCode() + " - " + cm.getTotalAmount());
            else ConsoleHelper.writeMessage("No money available.");
        }

    }
}

