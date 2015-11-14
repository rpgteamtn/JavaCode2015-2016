package com.qualcomm.ftcrobotcontroller.opmodes.Testers;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by Jonah on 11/14/2015.
 */
public class TesterEncoders extends OpMode
{
    @Override
    public void init()
    {
        //get references to motors from hardware map
        telemetry.addData("ecoder values", enc);
    }

    @Override
    public void loop()
    {
        //get values from buttons on gamepad
        telemetry.addData()
    }
}
