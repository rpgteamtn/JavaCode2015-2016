package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.ClimberDriver;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Jonah on 12/5/2015.
 */
public class TesterClimbers {
    ClimberDriver climberDriver;

    public void testClimbers() {
        climberDriver.dropClimbers();
    }


    public TesterClimbers(){}
}