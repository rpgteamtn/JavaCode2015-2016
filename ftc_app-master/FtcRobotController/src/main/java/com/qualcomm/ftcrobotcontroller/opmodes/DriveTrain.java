package com.qualcomm.ftcrobotcontroller.opmodes;
// Allows use of other classes in program
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import java.lang.Override;
// Defines driveMotors as motors
// Names class
// Is public so can use any previous class

/**
 * Created by Josh
 */
public class DriveTrain extends OpMode {
    DcMotor driveMotorLF;
    DcMotor driveMotorLB;
    DcMotor driveMotorRF;
    DcMotor driveMotorRB;
    DriveDriver DriveDriver;
    double mediumPower = 0.75;
    double smallPower = 0.5;
// Overrides previous function
    @Override
    public void init()
    {
        // Connects program motors to actual motors
        // Applys to individual motors
        // Programs for ran on driverMotor now apply to robot motors
        driveMotorLB = hardwareMap.dcMotor.get("driveMotorLB");
        driveMotorLF = hardwareMap.dcMotor.get("driveMotorLF");
        driveMotorRF = hardwareMap.dcMotor.get("driveMotorRF");
        driveMotorRB = hardwareMap.dcMotor.get("driveMotorRB");
        DriveDriver = new DriveDriver(driveMotorLB, driveMotorLF, driveMotorRB, driveMotorRF);
        driveMotorRF.setDirection(DcMotor.Direction.REVERSE);
        driveMotorRB.setDirection(DcMotor.Direction.REVERSE);

    }
    @Override
    public void loop() {
        // Sets values for joystick
        // Note: Applies to sides of robot not each motor
        while((!-gamepad1.right_bumper && !-gamepad1.left_bumper) ||(-gamepad1.right_bumper && -gamepad1.left_bumper) ) {
            float left = -gamepad1.left_stick_y;
            float right = -gamepad1.right_stick_y;
            // Sets power to each motor
            // Automatically connects motors to joystick
            DriveDriver.setMotors(left, right);
        }
        while(-gamepad1.right_bumper == true) {
            float left = -gamepad1.left_stick_y;
            float right = -gamepad1.right_stick_y;
            DriveDriver.setMotors(left * smallPower);
        }
        while(-gamepad1.left_bumper == true) {
            float left = -gamepad1.left_stick_y;
            float right = -gamepad1.right_stick_y;
            DriveDriver.setMotors(left * mediumPower);
        }


        }
    }


}