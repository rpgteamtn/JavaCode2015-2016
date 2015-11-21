package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.ftcrobotcontroller.opmodes.DebrisLift;

/**
 * Created by Chaitu on 21-11-2015.
 */
public class TesterDebrisLift {
    DebrisLift DebrisLift;

    public void DebrisLiftTester() {
        DebrisLift.debrisLiftMotor.setPower(1);
        DebrisLift.debrisLiftMotor.sleep(10000);
        DebrisLift.debrisLiftMotor.setPower(-1);


    }
}
