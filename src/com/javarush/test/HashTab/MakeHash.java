package com.javarush.test.HashTab;

/**
 * Created by Golitsyn.SN on 31.05.2016.
 */
public class MakeHash<T> {
    public int returnHash(T x){
        return x.hashCode();
    }
}
