package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.DriveDriver;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.Timer;
import com.qualcomm.ftccommon.DbgLog;
import com.qualcomm.robotcore.util.ElapsedTime;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.String;

/**
 * Created by Jonah on 1/19/2016.
 */
public class DrivingTest extends LinearOpMode{
    String startDate;
    ElapsedTime runtime = new ElapsedTime();
    String RPGtime = new String("");
    boolean overTen = false;
    DriveDriver driveDriver;
    DcMotor driveMotorLF;
    DcMotor driveMotorLB;
    DcMotor driveMotorRF;
    DcMotor driveMotorRB;
    DcMotor debrisLiftMotor;
    Timer timer = new Timer();
    String thing;

    @Override
    public void runOpMode() throws InterruptedException {
        driveMotorLB = hardwareMap.dcMotor.get("driveMotorLB");
        driveMotorLF = hardwareMap.dcMotor.get("driveMotorLF");
        driveMotorRF = hardwareMap.dcMotor.get("driveMotorRF");
        driveMotorRB = hardwareMap.dcMotor.get("driveMotorRB");
        debrisLiftMotor = hardwareMap.dcMotor.get("debrisLiftMotor");
        //debrisServo = hardwareMap.servo.get("debrisServo");

        driveDriver = new DriveDriver(driveMotorLB, driveMotorLF, driveMotorRB, driveMotorRF);
        driveMotorRF.setDirection(DcMotor.Direction.REVERSE);
        driveMotorRB.setDirection(DcMotor.Direction.REVERSE);



    /*for (int x = 1;x<50;x++){
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
        driveMotorLB.setPower(-1);
        timer.sleepMill(4000);
        driveMotorLB.setPower(0);
        driveDriver.moveDist(9, .5);*/

        driveDriver.moveTime(5000,1);
    }
}