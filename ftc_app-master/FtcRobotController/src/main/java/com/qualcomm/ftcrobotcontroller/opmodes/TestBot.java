package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class TestBot extends OpMode
{
    DcMotor testMotor;
    Servo testServo;
    // Sets values for Servos
    final double SERVO_OPEN = 1.0;
    final double SERVO_CLOSED = 0.5;

    @Override
    public void init()
    {
        // Connects motors and Servos to program
        testMotor = hardwareMap.dcMotor.get("testMotor");
        testServo = hardwareMap.servo.get("testServo");
        testMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop()
    {
        // Sets value for controller
        float yValue = -gamepad1.left_stick_y;
        //
        if(Math.abs(yValue) >= 0.01)
        {
            testMotor.setPower(yValue);
        }
        else
        {
            testMotor.setPower(0);
        }
        // Tells what to do when certain buttons are pressed
        // Controls Servo
        if(gamepad1.a)
        {
            testServo.setPosition(SERVO_OPEN);
        }

        if(gamepad1.b)
        {
            testServo.setPosition(SERVO_CLOSED);
        }
    }
}
