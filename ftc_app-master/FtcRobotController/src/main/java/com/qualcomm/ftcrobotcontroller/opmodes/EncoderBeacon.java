package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.lang.Override;

public class EncoderBeacon extends OpMode
{
    DcMotor beaconMotor;

    int ENCODER_CPR = 1440;     //Encoder Counts per Revolution
    double GEAR_RATIO = 2/1;      //Gear Ratio
    int WHEEL_DIAMETER = 2;     //Diameter of the wheel in inches

    double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
    double ROTATIONS = Dist / CIRCUMFERENCE;
    double finalDist = ENCODER_CPR * ROTATIONS * GEAR_RATIO;
}
@Override
public void init()
{
    beaconMotor = hardwareMap.dcMotor.get("debris_lift_motor");

    beaconMotor = setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
}
@Override
public void start()
{
    beaconMotor.setTargetPosition((int) COUNTS);

    beaconMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);

    beaconMotor.setPower(1);

}
@Override
public void loop()
{
    telemetry.addData("Motor Target", COUNTS);
    telemetry.addData("debris_lift_motor", beaconMotor.getCurrentPosition());
}