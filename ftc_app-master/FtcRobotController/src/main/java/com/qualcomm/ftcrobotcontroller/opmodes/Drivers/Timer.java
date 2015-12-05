package com.qualcomm.ftcrobotcontroller.opmodes.Drivers;

/**
 * Created by Jonah on 12/5/2015.
 */
public class Timer{

    public void Timer()
    {

    }


    public static void sleep(long sleepTime) {
        long wakeupTime = System.currentTimeMillis() + sleepTime;

        while (sleepTime > 0) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
            sleepTime = wakeupTime - System.currentTimeMillis();
        }
    }
}