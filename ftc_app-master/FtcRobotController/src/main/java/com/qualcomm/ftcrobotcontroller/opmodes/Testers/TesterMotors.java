package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

/**
 * Created by Natalie on 12/19/2015.
 */

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.DriveDriver;
import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.Timer;

public class TesterMotors {
    DriveDriver DriveDriver;
    Timer Timer;

    public void testMotors()
       {

           DriveDriver.setMotors(0.7, 0.7);
           Timer.sleep(2000);

       }

    public TesterMotors()
    {
    }
}
