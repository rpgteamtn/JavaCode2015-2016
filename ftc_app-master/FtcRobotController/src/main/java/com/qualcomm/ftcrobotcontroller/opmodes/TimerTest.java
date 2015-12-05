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
        driveMotorLB = hardwareMap.dcMotor.get("MotorLB");
        driveMotorLF = hardwareMap.dcMotor.get("MotorLF");
        driveMotorRB = hardwareMap.dcMotor.get("MotorRB");
        driveMotorRF = hardwareMap.dcMotor.get("MotorRF");

        driveMotorRB.setDirection(DcMotor.Direction.REVERSE);
        driveMotorRF.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        DriveDriver.setMotors(1,1);
        Timer.sleep(10);
        DriveDriver.setMotors(-1,-1);
        Timer.sleep(10);
    }
}
