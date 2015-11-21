package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Jonah on 11/14/2015.
 */
public class BeaconDriver extends OpMode
{
    DcMotor beaconMotor;

    @Override
    public void init()
    {
        //get references to motors from hardware map
        beaconMotor = hardwareMap.dcMotor.get("debris_lift_motor");
    }

    @Override
    public void loop()
    {
        //get values from buttons on gamepad
        if(gamepad1.dpad_up )
        {
            beaconMotor.setPower(1);
        }
        if(gamepad1.dpad_down)
        {
            beaconMotor.setPower(-1);
        }
    }

}

