package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;


import java.io.IOException;
import java.util.Locale;

/**
 * Created by Golitsyn.SN on 16.06.2016.
 */

public class CashMachine
{
    public static void main(String... args) throws IOException
    {
        Locale.setDefault(Locale.ENGLISH);
        try
        {
            Operation operation;
            do
            {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            }
            while (!operation.equals(Operation.EXIT));
        }
        catch (InterruptOperationException e)
        {
            ConsoleHelper.writeMessage("До свидания !!!");
        }


    }
}