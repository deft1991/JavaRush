package com.javarush.test.level22.lesson05.home01;

public class ThisUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForSecondThread(t, e, string));
        } else {
            System.out.println(getFormattedStringForOtherThread(t, e, string));
        }
    }

    /*
    3. Реализуйте логику трех protected методов в ThisUncaughtExceptionHandler используя вызовы соответствующих методов согласно следующему шаблону:
    a) 1# : TooShortStringFirstThreadException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1
    б) java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : TooShortStringSecondThreadException : 2#
    в) RuntimeException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : 3#
    */
    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        String sb = String.format(string,e.getClass().getSimpleName(),e.getCause(),t.getName());
        return sb;
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        String sb = String.format(string,e.getCause(),e.getClass().getSimpleName(),t.getName());
        return sb;
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        String sb = String.format(string,t.getName(),e.getClass().getSimpleName(),e.getCause());
        return sb;
    }
}

