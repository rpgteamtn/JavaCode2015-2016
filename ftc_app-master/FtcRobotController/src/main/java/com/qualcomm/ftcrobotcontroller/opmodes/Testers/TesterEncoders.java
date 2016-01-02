package com.qualcomm.ftcrobotcontroller.opmodes.Testers;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Jonah on 11/14/2015.
 */
public class TesterEncoders extends OpMode
{
    @Override
    public void init()
    {
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");

        rightMotor = setDirection(DcMotor.Direction.REVERSE);

        leftMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        //get references to motors from hardware map
        telemetry.addData("encoder values", enc);
    }

    @Override
    public void loop()
    {
        //get values from buttons on gamepad
        telemetry.addData("Motor Target", COUNTS);
        telemetry.addData("Left Position",leftMotor.getCurrentPosition());
        telemetry.addData("Right Position", rightMotor.getCurrentPosition());
    }
    public TesterEncoders (DcMotor TE){
        leftMotor.setTargetPosition((int) COUNTS);
        rightMotor.setTargetPosition((int) COUNTS);

        leftMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        rightMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);

        leftMotor.setPower(0.5);
        rightMotor.setPower(0.5);
    }
}
