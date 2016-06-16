package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Golitsyn.SN on 16.06.2016.
 */
public class CommandExecutor {
  public static  Map<Operation, Command> map = new HashMap<Operation,Command>();
   static {
       map.put(Operation.INFO,new InfoCommand());
       map.put(Operation.DEPOSIT,new DepositCommand());
       map.put(Operation.WITHDRAW,new WithdrawCommand());
       map.put(Operation.EXIT,new ExitCommand());
   }
}
