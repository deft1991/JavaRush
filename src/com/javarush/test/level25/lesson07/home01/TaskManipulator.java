package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private String threadName;
    private Thread t;

    // выводить каждые 50мс, если меньше 50

    @Override
    public void run() {
        try {
            Thread.sleep(0);
            while (!t.isInterrupted()) {

                System.out.println(threadName);
                Thread.sleep(87);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(String threadName) {
        this.threadName = threadName;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void stop() {
        t.interrupt();
    }
}
