package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.Timer;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Josh
 */

public class TesterRobotLift
{
    DcMotor RobotLiftMotor;

    public void RobotLiftTester()
    {
        // Function to run lift
        RobotLiftMotor.setPower(1);
        Timer.sleep(5000);
        RobotLiftMotor.setPower(-1);
        Timer.sleep(5000);
    }
     // Lets this program be refered by other programs
    public TesterRobotLift(){}
}