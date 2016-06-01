package com.javarush.test.NVirt;

/**
 * Created by Golitsyn.SN on 01.06.2016.
 */
public class VirtTab {
    final static int N = 997; // размер таблицы
  static Pair[] table = new Pair[N];

    char[] key = "1234567890".toCharArray();
    int[] value = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 11, 12, 12, 12};

    public boolean put(char[] key, int[] value) {
        Pair p = new Pair(key, value);
        int d = 1;
        int h = p.hashCode();
        try {
            if (table[h].isDeleted()) {
                table[h] = new Pair(key, value);
                return true;
            }
            // проверка элементов таблицы пока не найдем пустой или удаленный элемент
            // или пока индекс снова не станет равным h
            for (int i = (h + d); i != h; i = (i + 2) % table.length) {
                if (table[i].isDeleted() || table[i].getKey() == key) {
                    table[i] = new Pair(key, value);
                    return true;
                }
                d += 2;
            }
            return false;
        } catch (NullPointerException e) {
            table[h] = new Pair(key, value);
            return true;
        }
    }
    public int[] get(char[] key) {
        Pair p = new Pair();
        p.setKey(key);
        int d = 1;
        int h = p.hashCode();
        try {
            if (table[h].getKey() == key && !table[h].isDeleted() && table[h] != null)
                return table[h].getValue();
            for (int i = h + d; i != h; i = (i + 1) % table.length) {
                if (table[i].getKey() == key && !table[i].isDeleted() && table[i] != null)
                    return table[i].getValue();
                d += 2;
            }
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }
    public boolean del(char[] key) {
        Pair p = new Pair();
        p.setKey(key);
        int d = 1;
        int h = p.hashCode();
        try {
            if (table[h].getKey() == key) {
                table[h].deletePair();
                return true;
            }
            for (int i = h + d; i != h; i = (i + 1) % table.length) {
                if (table[i].getKey() == key) {
                    table[h].deletePair();
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

}
