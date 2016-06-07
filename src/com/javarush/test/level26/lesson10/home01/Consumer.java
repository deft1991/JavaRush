package com.javarush.test.level26.lesson10.home01;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Golitsyn.SN on 07.06.2016.
 */
public class Consumer implements Runnable {
    protected BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(queue.take().toString());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was deTerminated", Thread.currentThread().getName()));
        }
    }
}
