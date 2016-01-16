package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.DriveDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import java.lang.Override;

/**
 * Created by Jonah on 12/19/2015.
 */
public class rpgTeleOp extends OpMode{
    DcMotor driveMotorLF;
    DcMotor driveMotorLB;
    DcMotor driveMotorRF;
    DcMotor driveMotorRB;
    DcMotor debrisLiftMotor;
    DcMotor debrisArmMotor;
    DriveDriver DriveDriver;
    double mediumPower = 0.75;
    double smallPower = 0.5;

    float left;
    float right;
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
        debrisLiftMotor = hardwareMap.dcMotor.get("debrisLiftMotor");
        debrisArmMotor = hardwareMap.dcMotor.get("debrisArmMotor");
        DriveDriver = new DriveDriver(driveMotorLB, driveMotorLF, driveMotorRB, driveMotorRF);
        driveMotorRF.setDirection(DcMotor.Direction.REVERSE);
        driveMotorRB.setDirection(DcMotor.Direction.REVERSE);

    }
    @Override
    public void loop() {
        // Sets values for joystick
        // Note: Applies to sides of robot not each motor
        if((!gamepad1.right_bumper && !gamepad1.left_bumper) ||(gamepad1.right_bumper && gamepad1.left_bumper) ) {
             left = -gamepad1.left_stick_y;
             right = -gamepad1.right_stick_y;
            // Sets power to each motor
            // Automatically connects motors to joystick
            DriveDriver.setMotors(left, right);
        }
        else if(gamepad1.right_bumper == true) {
             left = -gamepad1.left_stick_y;
             right = -gamepad1.right_stick_y;
            DriveDriver.setMotors(left * smallPower, right * smallPower);
        }
        else if(gamepad1.left_bumper == true) {
            float left = -gamepad1.left_stick_y;
            float right = -gamepad1.right_stick_y;
            DriveDriver.setMotors(left * mediumPower, right * mediumPower);
        }
        if(gamepad2.right_bumper == true)
        {
            debrisLiftMotor.setPower(1);
        }
        if(gamepad2.left_bumper == true)
        {
            debrisLiftMotor.setPower(-1);
        }
        if(gamepad2.right_stick_y
        {
            debrisArmMotor.setPower(1);
        }
        if(-gamepad2.right_stick_y)
        {
            debrisArmMotor.setPower(-1);
        }
    }
}