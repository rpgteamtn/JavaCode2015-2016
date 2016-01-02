package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.Timer;
import com.qualcomm.robotcore.hardware.DcMotor;

public class TesterRobotLift
{
    DcMotor RobotLiftMotor;

    public void RobotLiftTester()
    {
        RobotLiftMotor.setPower(1);
        Timer.sleep(5000);
        RobotLiftMotor.setPower(-1);
        Timer.sleep(5000);
    }
    public TesterRobotLift(){}
}