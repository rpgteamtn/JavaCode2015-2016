package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.ftcrobotcontroller.opmodes.DebrisLift;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Chaitu on 21-11-2015.
 */
public class TesterDebrisLift extends LinearOpMode {
    DebrisLift DebrisLift;

    public void DebrisLiftTester() {
        DebrisLift.debrisLiftMotor.setPower(1);
        sleep(10000);
        DebrisLift.debrisLiftMotor.setPower(-1);
        sleep(10000);

    }
}
