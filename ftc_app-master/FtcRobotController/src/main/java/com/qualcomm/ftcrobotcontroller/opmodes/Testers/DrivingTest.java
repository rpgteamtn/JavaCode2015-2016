package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.DriveDriver;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.Timer;
import com.qualcomm.ftccommon.DbgLog;

/**
 * Created by Jonah on 1/19/2016.
 */
public class DrivingTest extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {
    DriveDriver driveDriver;
    DcMotor driveMotorLF;
    DcMotor driveMotorLB;
    DcMotor driveMotorRF;
    DcMotor driveMotorRB;
    Timer timer =  new Timer();
    String thing;

    driveMotorLB = hardwareMap.dcMotor.get("driveMotorLB");
    driveMotorLF = hardwareMap.dcMotor.get("driveMotorLF");
    driveMotorRF = hardwareMap.dcMotor.get("driveMotorRF");
    driveMotorRB = hardwareMap.dcMotor.get("driveMotorRB");
    //debrisServo = hardwareMap.servo.get("debrisServo");

    driveDriver = new DriveDriver(driveMotorLB, driveMotorLF, driveMotorRB, driveMotorRF);
    driveMotorRF.setDirection(DcMotor.Direction.REVERSE);
    driveMotorRB.setDirection(DcMotor.Direction.REVERSE);

waitForStart();


    for (int x = 1;x<50;x++){
        driveDriver.setMotors(1, 1);
    DbgLog.msg(("loop 1: " + x));
        timer.sleepMill(100);
    }
        timer.sleepMill(2000);
        DbgLog.msg(("middle"));

        timer.sleepMill(2000);

        for (int x = 1;x<50;x++){
        driveDriver.setMotors(-1, -1);
        DbgLog.msg(("loop 2: " + x));
        timer.sleepMill(100);

    }
        timer.sleepMill(2000);

        driveDriver.setMotors(0, 0);

        timer.sleepMill(2000);
    //driveDriver.moveDist(12, .1);
        //driveDriver.moveDist(12, .2);
        //driveDriver.moveDist(12, .3);
        //driveDriver.moveDist(12, .4);
        //driveDriver.moveDist(12, .5);
        //driveDriver.moveDist(12, .6);
        //driveDriver.moveDist(12, .7);
        //driveDriver.moveDist(12, .8);
        //driveDriver.moveDist(12, .9);
        //driveDriver.moveDist(12, 1);
    }

}
