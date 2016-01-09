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
    // Sets power value and how many counts be made
    int power = 1;
    int counts = 3;


    public void beaconPusher()
    {
        // Moves pusher forward to press button
        beaconMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        beaconMotor.setTargetPosition((int) counts);
        beaconMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        beaconMotor.setPower(power);
        //sleep(5000);
        // Pusher will move back away from button
        beaconMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        beaconMotor.setTargetPosition((int) counts);
        beaconMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        beaconMotor.setPower(-power);
    }
}

