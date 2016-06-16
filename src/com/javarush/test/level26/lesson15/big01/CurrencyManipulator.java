package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Golitsyn.SN on 16.06.2016.
 */

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>(); //  карта номинал - колличество

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }
    }

    // считаем сумму определенной валюты. умножаем номинал на колличество и складываем
    public int getTotalAmount(){
        int summ=0;
        for(Map.Entry<Integer,Integer> pair : denominations.entrySet()){
            summ +=pair.getKey()*pair.getValue();
        }
        return summ;
    }
}
