package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
/**
 * Created by Jonah on 1/11/2016.
 */
public class EncoderLiftTestThing extends OpMode {
    DcMotor armMotor;
    float power;

    @Override
    public void init() {
        armMotor = hardwareMap.dcMotor.get("armMotor");
    }

    public void loop() {
        while (-gamepad1.left_stick_y != 0)
        {
            power = -gamepad1.left_stick_y;
            armMotor.setPower(power);
        }
        telemetry.addData ("1", "Encoder Value" + armMotor.getCurrentPosition());
    }
}
