package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.IOException;


/**
 * Created by Golitsyn.SN on 16.06.2016.
 */


class ExitCommand implements Command
{
    @Override
    public void execute() throws IOException, InterruptOperationException
    {
        ConsoleHelper.writeMessage("Вы действительно хотите выйти ? (y/n)");

        String var = ConsoleHelper.readString();

        while (!var.equalsIgnoreCase("y") && !var.equalsIgnoreCase("n"))
        {
            ConsoleHelper.writeMessage("Некорректный ответ, повторите !");
            var = ConsoleHelper.readString();
        }

        if (var.equalsIgnoreCase("y"))
            ConsoleHelper.writeMessage("До свидания !");


    }
}
