package com.javarush.test.HashTab;

/**
 * Created by Golitsyn.SN on 31.05.2016.
 */
public class Pair<T1,T2> {
    private final T1 key;
    private final T2 value;
    private boolean isDeleted;

    public Pair(T1 key, T2 value) {
        this.key = key;
        this.value = value;
    }

    public T1 getKey() {
        return key;
    }

    public T2 getValue() {
        return value;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public boolean deletePair(){
        if (!this.isDeleted){
            this.isDeleted = true;
            return true;
        }
        else return false;
    }
}
