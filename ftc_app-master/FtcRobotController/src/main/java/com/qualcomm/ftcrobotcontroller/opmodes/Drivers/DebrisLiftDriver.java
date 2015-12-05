package com.qualcomm.ftcrobotcontroller.opmodes.Drivers;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by Natalie on 10/17/2015.
 */
public class DebrisLift extends OpMode

    DcMotor debrisLiftMotor;
    int counts = 10;
    double power = debrisLiftMotor.setPower();

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
        if(gamepad1.x)
        {
            debrisLiftMotor.setPower(0);
        }
    }

    public DebrisLift(DcMotor DL) { debrisLiftMotor = DL; }

    public  void runDebris()
        {
            DebrisLift.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
            DebrisLift.setTargetPosition(counts);

            DebrisLift.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
            DebrisLift.setPower(power);
        }

