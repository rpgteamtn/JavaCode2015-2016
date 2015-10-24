package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Natalie on 10/17/2015.
 */
public class DebrisLiftDriver extends OpMode
{

    DcMotor debrisLiftMotor;

    @Override
    public void init()
    {
        //get references to motors from hardware map
        debrisLiftMotor = hardwareMap.dcMotor.get("debris_lift_motor");
    }

    @Override
    public void loop()
    {
        //get values from buttons on gamepad
        if(gamepad1.dpad_up )
        {
            debrisLiftMotor.setPower(1);
        }
        if(gamepad1.dpad_down)
        {
            debrisLiftMotor.setPower(-1);
        }
    }
}
