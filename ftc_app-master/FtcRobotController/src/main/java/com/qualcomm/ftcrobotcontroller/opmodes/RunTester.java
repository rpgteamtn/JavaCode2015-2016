package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.ftcrobotcontroller.opmodes.Testers.TesterClimbers;
import com.qualcomm.ftcrobotcontroller.opmodes.Testers.TesterEncoders;
import com.qualcomm.ftcrobotcontroller.opmodes.Testers.TesterDebrisLift;
import com.qualcomm.ftcrobotcontroller.opmodes.Testers.TesterBeacon;
import com.qualcomm.ftcrobotcontroller.opmodes.Testers.TesterRobotLift;
import com.qualcomm.ftcrobotcontroller.opmodes.Testers.TesterDebrisDropper;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Josh Crabtree
 */

// Note: function will test all testers
public class RunTester extends LinearOpMode {
    // Calls upon other Testers
    // Uses constructors written in each Tester
    TesterBeacon TesterBeacon;
    TesterClimbers TesterClimbers;
    TesterDebrisDropper TesterDebrisDropper;
    TesterDebrisLift TesterDebrisLift;
    TesterEncoders TesterEncoders;
    TesterRobotLift TesterRobotLift;
    TesterMotors TesterMotors;

    @Override
    public void runOpMode() throws InterruptedException {
        // Runs testers
        // Every tester below will run in order they are placed
        TesterClimbers.testClimbers();
        TesterEncoders.testEncoders();
        TesterMotors.testMotors();
        TesterDebrisLift.testerDebrisLift();
        TesterBeacon.testBeacon();
        TesterRobotLift.RobotLiftTester();
        TesterDebrisDropper.DebrisDropperTester();
    }
}