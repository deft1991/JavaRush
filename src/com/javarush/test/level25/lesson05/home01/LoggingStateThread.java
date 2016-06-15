package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Golitsyn.SN on 15.06.2016.
 */
public class LoggingStateThread extends Thread {
    Thread target;
    State state;

    public LoggingStateThread(Thread target) {
        this.target = target;
        state = this.target.getState();
        setDaemon(true);
    }

    @Override
    public void run()
    {
        State state = this.target.getState();
        System.out.println(state);
        while (state != State.TERMINATED)
        {
            if (state != this.target.getState())
            {
                state = this.target.getState();
                System.out.println(state);
            }
        }
    }
}


