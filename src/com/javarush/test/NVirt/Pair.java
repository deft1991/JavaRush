package com.javarush.test.NVirt;

/**
 * Created by Golitsyn.SN on 31.05.2016.
 */
public class Pair {
    final static int WORDLEN = 32; // максимальная длинна ключей
    final static int NOC = 16; // макс число элементов в слове
    char[] key;
    int[] value;
    private boolean deleted;

    public Pair(){};
    public Pair(char[] key, int[] value) throws ArrayIndexOutOfBoundsException {
        if (key.length > WORDLEN)
            throw new ArrayIndexOutOfBoundsException("Слишком длинный ключ");
        if (value.length > NOC)
            throw new ArrayIndexOutOfBoundsException("Слишком длинное значение");
        this.key = key;
        this.value = value;
        this.deleted = false;
    }

    @Override
    public int hashCode() {
        int h = 0;
        for (int i = 0; i < key.length; i++) {
            h = (256 * h + key.length) % VirtTab.N;
        }
        return h;
    }

    public void setKey(char[] key) {
        this.key = key;
    }

    public char[] getKey() {
        return key;
    }

    public int[] getValue() {
        return value;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public boolean deletePair() {
        if (!this.deleted) {
            this.deleted = true;
            return true;
        } else return false;
    }
}
