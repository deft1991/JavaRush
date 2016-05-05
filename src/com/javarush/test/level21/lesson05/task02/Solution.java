package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if ((o.getClass() != this.getClass()))
            return false;
        Solution n = (Solution) o;
        if (n.first == null && n.last == null) {
            if (first == null && last == null)
                return true;
            else return false;
        }
        if (n.first != null && n.last == null) {
            if (first != null && last == null)
                return n.first == (first);
            else return false;
        }
        if (n.first == null && n.last != null) {
            if (first == null && last != null)
                return n.last == (last);
            else return false;
        } else return n.first == (first) && n.last == (last);
    }

    @Override
    public int hashCode() {
        if (first == null && last == null)
            return 0;
        if (first != null && last == null)
            return 1;
        if (first == null && last != null)
            return 2;
        else
            return first.hashCode() + last.hashCode();

    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        s.add(new Solution(null, null));
        s.add(new Solution(null, "Mouse"));
        s.add(new Solution("Mickey", null));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
        System.out.println(s.contains(new Solution("Mickey", "Mousce")));
        System.out.println(s.contains(new Solution(null, null)));
        System.out.println(s.contains(new Solution(null, "Mouse")));
        System.out.println(s.contains(new Solution("Mickey", null)));
    }
}
