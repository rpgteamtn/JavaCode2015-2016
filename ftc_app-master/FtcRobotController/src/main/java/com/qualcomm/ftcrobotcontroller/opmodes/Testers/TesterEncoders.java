package com.qualcomm.ftcrobotcontroller.opmodes.Testers;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.Timer;

/**
 * Created by Jonah on 11/14/2015.
 */
public class TesterEncoders {
    DcMotor leftMotor;
    DcMotor rightMotor;
    int target = 15000;


    public void testEncoders() {
        while ((leftMotor.getCurrentPosition() < target) || (leftMotor.getCurrentPosition() < target)) {
            /**
             *  telemetry.addData("Motor Target", target);
             telemetry.addData("Left Position", leftMotor.getCurrentPosition());
             telemetry.addData("Right Position", rightMotor.getCurrentPosition());
             */

            leftMotor.setTargetPosition((int) target);
            rightMotor.setTargetPosition((int) target);

            leftMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
            rightMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);

            leftMotor.setPower(0.5);
            rightMotor.setPower(0.5);
        }
        /**
        telemetry.addData("Motor Target", target);
        telemetry.addData("Left Position", leftMotor.getCurrentPosition());
        telemetry.addData("Right Position", rightMotor.getCurrentPosition());
        Timer.sleep(60000); */
    }
}