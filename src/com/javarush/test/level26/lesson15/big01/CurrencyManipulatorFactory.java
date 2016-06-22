package com.javarush.test.level26.lesson15.big01;

import java.util.*;

/**
 * Created by Golitsyn.SN on 16.06.2016.
 */


public final class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> manipulators = new HashMap<>();
    private CurrencyManipulatorFactory(){}
  public  static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (manipulators.containsKey(currencyCode)) {
            return manipulators.get(currencyCode);
        } else {
            CurrencyManipulator cur = new CurrencyManipulator(currencyCode);
            manipulators.put(currencyCode, cur);
            return cur;
        }
    }
    public static Collection getAllCurrencyManipulators(){
        return manipulators.values();
    }

}


