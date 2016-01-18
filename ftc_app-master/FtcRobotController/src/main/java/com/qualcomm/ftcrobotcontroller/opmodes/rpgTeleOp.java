package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.DriveDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

import java.lang.Override;

/**
 * Created by Jonah on 12/19/2015.
 */
public class rpgTeleOp extends OpMode {
    DcMotor driveMotorLF;
    DcMotor driveMotorLB;
    DcMotor driveMotorRF;
    DcMotor driveMotorRB;
    DcMotor debrisLiftMotor;
    DcMotor armMotor;
    //Servo debrisServo;

    DriveDriver DriveDriver;
    int armMotorValue;
    float left;
    float right;
    float armPower;
    float servoOpen = 100;
    float servoClosed = 100;
    boolean OC;
    boolean servoSwitched = false;

    double mediumPower = 0.75;
    double smallPower = 0.5;

    double diameter = 1.95;
    double circumference = diameter * Math.PI;
    double maxlength = 30;
    double rotations = maxlength / circumference;
    double CPR = 1440;
    double armLimit = rotations * CPR;

    // Overrides previous function
    @Override
    public void init() {
        // Connects program motors to actual motors
        // Applys to individual motors
        // Programs for ran on driverMotor now apply to robot motors
        driveMotorLB = hardwareMap.dcMotor.get("driveMotorLB");
        driveMotorLF = hardwareMap.dcMotor.get("driveMotorLF");
        driveMotorRF = hardwareMap.dcMotor.get("driveMotorRF");
        driveMotorRB = hardwareMap.dcMotor.get("driveMotorRB");
        armMotor = hardwareMap.dcMotor.get("armMotor");
        debrisLiftMotor = hardwareMap.dcMotor.get("debrisLiftMotor");
        //debrisServo = hardwareMap.servo.get("debrisServo");

        DriveDriver = new DriveDriver(driveMotorLB, driveMotorLF, driveMotorRB, driveMotorRF);
        driveMotorRF.setDirection(DcMotor.Direction.REVERSE);
        driveMotorRB.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {

        // Sets values for joystick
        // Note: Applies to sides of robot not each motor


        if (gamepad2.left_stick_y != 0 || gamepad2.right_stick_y != 0) {
            if ((!gamepad2.right_bumper || !gamepad2.left_bumper)) {
                left = -gamepad2.left_stick_y;
                right = -gamepad2.right_stick_y;
                // Sets power to each motor
                // Automatically connects motors to joystick
                DriveDriver.setMotors(left, right);
            } else if (gamepad2.right_bumper) {
                left = -gamepad2.left_stick_y;
                right = -gamepad2.right_stick_y;
                DriveDriver.setMotors(left * smallPower, right * smallPower);
            } else if (gamepad2.left_bumper) {
                left = -gamepad2.left_stick_y;
                right = -gamepad2.right_stick_y;
                DriveDriver.setMotors(left * mediumPower, right * mediumPower);
            }
        }

        armMotorValue = armMotor.getCurrentPosition();
        if ((armMotorValue <= armLimit) && (gamepad1.right_stick_y != 0)) {
            armPower = -gamepad1.right_stick_y;
            armMotor.setPower(armPower); //when the stick is forward, arm goes forward
            armMotorValue = armMotor.getCurrentPosition();
        }

        if (gamepad2.dpad_up) {
            debrisLiftMotor.setPower(1);
        }
        if (gamepad2.dpad_down) {
            debrisLiftMotor.setPower(-1);
        }

        /*if(gamepad2.a) {
            if(!servoSwitched){
            if(OC)
            {
               // debrisServo.setPosition(servoClosed);
                OC = false;
                servoSwitched = true;
            }
            if(!OC) {
                //debrisServo.setPosition(servoOpen);
                OC = true;
                servoSwitched = true;
            }
        }
        }
        if((!gamepad2.a)&&(servoSwitched = true))
        {
            servoSwitched = false;
        }
    }*/
    }
}