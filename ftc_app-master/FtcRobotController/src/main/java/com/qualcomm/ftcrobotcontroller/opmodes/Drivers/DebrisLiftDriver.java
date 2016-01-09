package com.qualcomm.ftcrobotcontroller.opmodes.Drivers;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by Natalie on 10/17/2015.
 */
public class DebrisLiftDriver extends OpMode {

    DcMotor debrisLiftMotor;
    int counts = 10;

    @Override
    public void init() {
        //get references to motors from hardware map
        debrisLiftMotor = hardwareMap.dcMotor.get("debris_lift_motor");
    }

    @Override
    public void loop() {
        //get values from buttons on gamepad
        if (gamepad1.dpad_up) {
            debrisLiftMotor.setPower(1);
        }
        if (gamepad1.dpad_down) {
            debrisLiftMotor.setPower(-1);
        }
        if (gamepad1.x) {
            debrisLiftMotor.setPower(0);
        }
    }

    public DebrisLiftDriver(DcMotor DL) {
        debrisLiftMotor = DL;
    }

    public void runDebris(int power) {
        // Sends readouts as program runs
        // Measures speed and distance in power and rotation counts
        debrisLiftMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        debrisLiftMotor.setTargetPosition(counts);

        debrisLiftMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        debrisLiftMotor.setPower(power);
    }
}


