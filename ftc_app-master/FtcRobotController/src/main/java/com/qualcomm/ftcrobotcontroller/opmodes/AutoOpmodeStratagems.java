package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Jonah on 11/21/2015.
 */
public class AutoOpmodeStratagems {
    boolean alliance;//blue  is true
    char rampHight;
    boolean whichRamp; //blue  is true
    boolean climers;
    boolean beacon;
    boolean start;// true is near mountain

    public void PlanA()
    {

    }

    public AutoOpmodeStratagems(boolean Alliance, char RampHight, boolean WhichRamp;, boolean Climers, boolean Beacon, boolean Start)
    {
        alliance = Alliance;
        rampHight = RampHight;
        whichRamp = WhichRamp;
        climers = Climers;
        beacon = Beacon;
        start = Start;
    }
}
