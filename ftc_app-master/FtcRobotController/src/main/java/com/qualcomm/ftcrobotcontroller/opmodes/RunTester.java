package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.ftcrobotcontroller.opmodes.Testers.TesterClimbers;
import com.qualcomm.ftcrobotcontroller.opmodes.Testers.TesterEncoders;
import com.qualcomm.ftcrobotcontroller.opmodes.Testers.TesterDebrisLift;
import com.qualcomm.ftcrobotcontroller.opmodes.Testers.TesterBeacon;
import com.qualcomm.ftcrobotcontroller.opmodes.Testers.TesterRobotLift;
import com.qualcomm.ftcrobotcontroller.opmodes.Testers.TesterDebrisDropper;

public class RunTester extends LinearOpMode
{
    TesterBeacon TesterBeacon;
    TesterClimbers TesterClimbers;
    TesterDebrisDropper TesterDebrisDropper;
    TesterDebrisLift TesterDebrisLift;
    TesterEncoders TesterEncoders;
    TesterRobotLift TesterRobotLift;
}
    @Override
    public void runOpMode() throws InterruptedException
    {
        TesterClimbers.testClimbers();
        TesterEncoders.testEncoders();
        TesterMotors.testMotors();
        TesterDebrisLift.testDebrisLift();
        TesterBeacon.testBeacon();
        TesterRobotLift.RobotLiftTester();
        TesterDebrisDropper.DebrisDropperTester();
    }