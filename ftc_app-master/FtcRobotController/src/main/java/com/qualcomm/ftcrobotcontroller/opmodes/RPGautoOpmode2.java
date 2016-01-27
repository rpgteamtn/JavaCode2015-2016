package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.DriveDriver;
import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.Timer;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.Timer;
import java.util.concurrent.TimeUnit;


/**
 * Created by Jonah on 1/21/2016.
 */
public class RPGautoOpmode2 extends LinearOpMode {
    boolean start = true;// true is near mountain
    DcMotor driveMotorLF;
    DcMotor driveMotorLB;
    DcMotor driveMotorRF;
    DcMotor driveMotorRB;
    DcMotor debrisLiftMotor;
    DriveDriver driveDriver;
    Timer timer =  new Timer();

    int DistA=116;
    int DistB=82;

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

        waitForStart();

        debrisLiftMotor.setPower(1);
        if(start == true)
        {
            driveDriver.moveTime(driveDriver.distToTime(DistB),-1);
        }

        else if(start == false)
        {
            driveDriver.setMotors(-1, -1);
            timer.sleepMill(4000);
            driveDriver.setMotors(0, 0);
        }

        else
        {

        }

        debrisLiftMotor.setPower(0);
    }
}
