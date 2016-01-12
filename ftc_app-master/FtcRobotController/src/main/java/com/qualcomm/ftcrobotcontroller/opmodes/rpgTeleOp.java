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
    DcMotor armMotor;
    com.qualcomm.ftcrobotcontroller.opmodes.Drivers.DriveDriver DriveDriver;
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
        armMotor = hardwareMap.dcMotor.get("armMotor");
        debrisLiftMotor = hardwareMap.dcMotor.get("debrisLiftMotor");
        DriveDriver = new DriveDriver(driveMotorLB, driveMotorLF, driveMotorRB, driveMotorRF);
        driveMotorRF.setDirection(DcMotor.Direction.REVERSE);
        driveMotorRB.setDirection(DcMotor.Direction.REVERSE);



    }
    @Override
    public void loop() {
        float left;
        float right;
        float armPower;
        float armLimit = 100; //WE NEED TO SET THIS TO A LEGIT NUMBER
        // Sets values for joystick
        // Note: Applies to sides of robot not each motor
        while ((!gamepad1.right_bumper && !gamepad1.left_bumper) || (gamepad1.right_bumper && gamepad1.left_bumper)) {
            left = -gamepad1.left_stick_y;
            right = -gamepad1.right_stick_y;
            // Sets power to each motor
            // Automatically connects motors to joystick
            DriveDriver.setMotors(left, right);
        }
        while (gamepad1.right_bumper == true) {
            left = -gamepad1.left_stick_y;
            right = -gamepad1.right_stick_y;
            DriveDriver.setMotors(left * smallPower, right * smallPower);
        }
        while (gamepad1.left_bumper == true) {
            left = -gamepad1.left_stick_y;
            right = -gamepad1.right_stick_y;
            DriveDriver.setMotors(left * mediumPower, right * mediumPower);
        }
        while (gamepad2.right_bumper) {
            debrisLiftMotor.setPower(1); //when right bumper is pressed, it spins forward
        }
        while (gamepad2.left_bumper) {
            debrisLiftMotor.setPower(-1); //when left bumper is pressed, it spins backwards
        }
        if(armMotorValue <= armLimit) {
            while (gamepad2.right_stick_y > 0) {
                armPower = gamepad2.right_stick_y;
                armMotor.setPower(armPower); //when the stick is forward, arm goes forward
            }
            while (gamepad2.right_stick_y < 0) {
                armPower = -gamepad2.right_stick_y;
                armMotor.setPower(armPower); //when the stick is backwards, arm goes backwards
            }
        }
    }
}