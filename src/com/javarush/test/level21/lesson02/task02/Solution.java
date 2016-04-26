package com.javarush.test.level21.lesson02.task02;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* Сравниваем модификаторы
Реализовать логику метода isAllModifiersContainSpecificModifier, который проверяет,
содержит ли переданный параметр allModifiers значение конкретного модификатора specificModifier
*/
public class Solution {
    public static void main(String[] args) {
        int modifiersOfThisClass = Solution.class.getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.PUBLIC));   //true 1/1
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.STATIC));   //false 1/8

        int modifiersOfMethod = getMainMethod().getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfMethod, Modifier.STATIC));      //true 9/8
    }

    /*0x00000001 = 00000001
      0x00000008 = 00001000
      0x00000009 = 00001001 */
    public static boolean isAllModifiersContainSpecificModifier(int allModifiers, int specificModifier) {
        System.out.println(Integer.toBinaryString(allModifiers));
        System.out.println(Integer.toBinaryString(specificModifier));
        return ((allModifiers) & (specificModifier))>0 ? true : false;

    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
