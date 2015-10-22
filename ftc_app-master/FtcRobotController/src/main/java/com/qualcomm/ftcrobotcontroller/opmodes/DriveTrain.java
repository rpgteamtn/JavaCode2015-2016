package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import java.lang.Override;

public class DriveTrain extends OpMode {
    DcMotor driveMotorLF;
    DcMotor driveMotorLB;
    DcMotor driveMotorRF;
    DcMotor driveMotorRB;
    DriveDriver DriveDriver;

    @Override
    public void init() {
        // Connects program motors to actual motors
        // Applys to individual motors
        driveMotorLB = hardwareMap.dcMotor.get("leftFront_drive");
        driveMotorLF = hardwareMap.dcMotor.get("leftBack_drive");
        driveMotorRF = hardwareMap.dcMotor.get("rightFront_drive");
        driveMotorRB = hardwareMap.dcMotor.get("rightBack_drive");
        DriveDriver = new DriveDriver(driveMotorLB, driveMotorLF, driveMotorRB, driveMotorRF);

    }
    @Override
    public void loop() {
        // Sets values for joystick
        // Note: Applys to sides of robot not each motor
        float left = -gamepad1.left_stick_y;
        float right = -gamepad1.right_stick_y;
        // Sets power to each motor
        // Motors on same side move at same power
        DriveDriver.setMotors(left, right);

    }
}