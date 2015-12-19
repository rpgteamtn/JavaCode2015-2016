package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.DebrisLift;

/**
 * Created by Chaitu on 21-11-2015.
 */
public class TesterDebrisLift{
        DebrisLift DebrisLift;

    public void DebrisLiftTester() {
        DebrisLift.debrisLiftMotor.setPower(1);
        sleep(10000);
        DebrisLift.debrisLiftMotor.setPower(-1);
        sleep(10000);

    }
    public TesterDebrisLift(DcMotor TDL) { debrisLiftMotor = TDL; }
}