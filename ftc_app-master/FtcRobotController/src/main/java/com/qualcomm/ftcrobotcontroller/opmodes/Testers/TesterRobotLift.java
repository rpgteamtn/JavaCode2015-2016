package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.RobotLift;

public class TesterRobotLift
{
    RobotLift RobotLift;

    public void RobotLiftTester()
    {
        RobotLift.RobotLiftMotor.setPower(1);
        sleep(5000);
        RobotLift.RobotLiftMotor.setPower(-1);
        sleep(5000);
    }
    public TesterRobotLift(DcMotor TRL) { testerRobotLiftMotor = TRL; }
}