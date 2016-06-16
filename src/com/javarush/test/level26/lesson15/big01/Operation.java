package com.javarush.test.level26.lesson15.big01;

/**
 * Created by Golitsyn.SN on 16.06.2016.
 */
public enum Operation {
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

  public static Operation getAllowableOperationByOrdinal(Integer i) {

      switch (i) {
          case 1:
              return Operation.INFO;

          case 2:
              return Operation.DEPOSIT;

          case 3:
              return Operation.WITHDRAW;

          case 4:
              return Operation.EXIT;

          default:
              throw new IllegalArgumentException();
      }
  }
}
