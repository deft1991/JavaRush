package com.javarush.test.HashTab;

import com.javarush.test.level22.lesson09.task01.Solution;

/**
 * Created by Golitsyn.SN on 31.05.2016.
 */
public class OpenAdressHashTab<T1, T2> extends MakeHash<T1> implements HashTab<T1, T2> {
    private Pair<T1, T2>[] table;

    public OpenAdressHashTab() {
        table = new Pair[10000];
    }

    public OpenAdressHashTab(int m) {
        table = new Pair[m];
    }

    @Override

    public boolean put(T1 key, T2 value) {
        int hash = returnHash(key);
            if (table[hash] == null || table[hash].isDeleted()) {
                table[hash] = new Pair<>(key, value);
                return true;
            }
            for (int i = hash + 1; i != hash; i = (i + 1) % table.length) {
                if (table[i] == null || table[i].isDeleted() || table[i] == key) {
                    table[i] = new Pair<T1, T2>(key, value);
                    return true;
                }
            }
            return false;
        }

    @Override
    public T2 get(T1 key) {
        int h = returnHash(key);
        if (table[h].getKey()==key && !table[h].isDeleted())
            return table[h].getValue();
        for (int i = h+1;i!=h;i=(i+1)%table.length)
        {
            if (table[i].getKey()==key && !table[i].isDeleted())
                return table[i].getValue();
        }
        return null;
    }

    @Override
    public boolean delete(T1 key) {
        int h = returnHash(key);

        if (table[h].getKey()==key) {
            table[h].deletePair();
            return true;
        }
        for (int i = h+1;i!=h;i=(i+1)%table.length){
            if (table[i].getKey()==key && !table[i].isDeleted()){
                table[i].deletePair();
                return true;
            }
        }
        return false;
    }
}
