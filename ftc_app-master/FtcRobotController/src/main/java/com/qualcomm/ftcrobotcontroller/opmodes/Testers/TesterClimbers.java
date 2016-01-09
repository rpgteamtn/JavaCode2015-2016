package com.qualcomm.ftcrobotcontroller.opmodes.Testers;

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.ClimberDriver;

/**
 * Created by Jonah on 12/5/2015.
 */
public class TesterClimbers {
    ClimberDriver climberDriver;
    // Tests ClimberDriver

    public void testClimbers() {
        climberDriver.dropClimbers();
    }

    // Constructor
    // Can be called upon by other programs
    public TesterClimbers(){}
}