package com.javarush.test.HashTab;

/**
 * Created by Golitsyn.SN on 31.05.2016.
 */

// базовый интерфейс

public interface HashTab<T1,T2> {
    boolean put(T1 key,T2 value);
    T2 get(T1 key);
    boolean delete (T1 key);
}
