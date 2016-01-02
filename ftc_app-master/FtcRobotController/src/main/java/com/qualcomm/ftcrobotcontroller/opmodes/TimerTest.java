package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.Timer;
import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.DriveDriver;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.sql.Driver;

/**
 * Created by Jonah on 12/5/2015.
 */
public class TimerTest extends OpMode{
    Timer Timer;
    DriveDriver DriveDriver;

    DcMotor driveMotorLB;//LB  is left back
    DcMotor driveMotorLF;//LF  is left front
    DcMotor driveMotorRB;//RB is Right Back
    DcMotor driveMotorRF;//RF  is right front
    public void init()
    {
        driveMotorLB = hardwareMap.dcMotor.get("driveMotorLB");
        driveMotorLF = hardwareMap.dcMotor.get("driveMotorLF");
        driveMotorRB = hardwareMap.dcMotor.get("driveMotorRB");
        driveMotorRF = hardwareMap.dcMotor.get("driveMotorRF");

        driveMotorRB.setDirection(DcMotor.Direction.REVERSE);
        driveMotorRF.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        if(this.getRuntime() < 1.0) {
            DriveDriver.setMotors(1, 1);
        }
        this.resetStartTime();
        if(this.getRuntime()< 1.0) {
            DriveDriver.setMotors(-1, -1);
        }
    }
}
