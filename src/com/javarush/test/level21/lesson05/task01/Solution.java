package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (n.getClass() != this.getClass()) {
            return false;
        }
        Solution s = (Solution) n;
        if (s.first == null && s.last == null) {
            if (first == null && last == null) {
                return true;
            }
            else return false;
        }
        if (s.first != null && s.last == null) {
            if (first != null && last == null) {
                return s.first.equals(first);
            }
            else return false;
        }
        if (s.first == null && s.last != null) {
            if (first == null && last != null) {
                return s.last.equals(last);
            } else return false;
        }
        else {
            return s.first.equals(first)&&s.last.equals(last);
        }
    }

    public int hashCode() {
        if (first == null && last == null) {
            return 0;
        }
        if (first == null && last != null) {
            return 1;
        }
        if (first != null && last == null) {
            return 2;
        } else
            return 31 * (first.hashCode() + last.hashCode());
    }


    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
