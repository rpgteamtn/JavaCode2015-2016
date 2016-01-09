package com.qualcomm.ftcrobotcontroller.opmodes.Drivers;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.Timer;


/**
 * Created by Jonah on 11/14/2015.
 */
public class BeaconDriver
{
    DcMotor beaconMotor;
    Timer Timer;
    int power = 1;
    int counts = 3;


    public void beaconPusher()
    {

        beaconMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        beaconMotor.setTargetPosition((int) counts);
        beaconMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        beaconMotor.setPower(power);
       // sleep(5000);

        beaconMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        beaconMotor.setTargetPosition((int) counts);
        beaconMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        beaconMotor.setPower(-power);
    }
}

