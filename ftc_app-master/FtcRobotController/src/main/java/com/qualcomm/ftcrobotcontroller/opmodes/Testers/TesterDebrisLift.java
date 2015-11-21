package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.ftcrobotcontroller.opmodes.DebrisLift;

/**
 * Created by Chaitu on 21-11-2015.
 */
public class TesterDebrisLift {
    DebrisLift DebrisLift;

    public void DebrisLiftTester() {
        for (int i = 1; i < 6; i++) {
            DebrisLift.debrisLiftMotor.setPower(1);
        }
    }
}
