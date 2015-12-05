package com.qualcomm.ftcrobotcontroller.opmodes.Drivers;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.


/**
 * Created by Jonah on 11/14/2015.
 */
public class BeaconDriver
{
    DcMotor beaconMotor;
    int counts = 10;

    public void beaconPusher(int power)
    {

        beaconMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        beaconMotor.setTargetPosition((int) counts);
        beaconMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        beaconMotor.setPower(power);

        Timer.sleep(5000);

        beaconMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        beaconMotor.setTargetPosition((int) counts);
        beaconMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        beaconMotor.setPower(-power);
    }
}
