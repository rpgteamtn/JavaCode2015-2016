package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
//import com.qualcomm.ftcrobotcontroller.opmodes.other.PushBotHardware;
import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.Timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Chaitu on 2016-01-26.
 */

public class WheelDistanceTesters {

    public void moveDist(double Dist, double power) {
        DcMotor driveMotorLB;//LB  is left back
        DcMotor driveMotorLF;//LF  is left front
        DcMotor driveMotorRB;//RB is Right Back
        DcMotor driveMotorRF;//RF  is right front
        double distTraveled;
        double distLeft;
        double speedGoing;
        double maxSpeed = 0.7;
        double BreakPoint;
        double encoders;

        public WheelDistanceTesters(DcMotor lb, DcMotor lf, DcMotor rb, DcMotor rf) {
            driveMotorLB = lb;
            driveMotorLF = lf;
            driveMotorRB = rb;
            driveMotorRF = rf;

        driveMotorLB.setPower(-1);
        Dist = Dist / 9 * 1440;
        driveMotorLB.setPower(1);
        encoders = 0;
        resetEncoders();
        while (Dist > encoders) {
            encoders = ((driveMotorLB.getCurrentPosition() + driveMotorLF.getCurrentPosition() + driveMotorRB.getCurrentPosition() + driveMotorRF.getCurrentPosition()) / 4);
            setMotors(power, power);
        }
    }
}

