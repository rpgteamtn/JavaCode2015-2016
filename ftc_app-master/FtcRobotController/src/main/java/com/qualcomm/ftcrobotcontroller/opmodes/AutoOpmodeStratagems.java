package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Jonah on 11/21/2015.
 */
public class AutoOpmodeStratagems {
    char alliance;//blue  is true
    char rampHight;
    char whichRamp; //blue  is true
    boolean climers;
    boolean beacon;
    boolean start;// true is near mountain

    public void planAB()
    {
         alliance='B';
         rampHight='M';
         whichRamp='B';
         climers=true;
         beacon=true;
         start=false;
    }
    public void planAR()
    {
        alliance='R';
        rampHight='M';
        whichRamp='R';
        climers=true;
        beacon=true;
        start=false;
    }
    public void planBB()
    {
        alliance='B';
        rampHight='M';
        whichRamp='B';
        climers=true;
        beacon=true;
        start=true;
    }
    public void planBR()
    {
        alliance='R';
        rampHight='M';
        whichRamp='R';
        climers=true;
        beacon=true;
        start=true;
    }
    public void planCB()
    {
        alliance='B';
        rampHight='M';
        whichRamp='B';
        climers=true;
        beacon= false;
        start=false;
    }
    public void planCR()
    {
        alliance='R';
        rampHight= 'M';
        whichRamp='R';
        climers=true;
        beacon=false;
        start=false;
    }
    public void planDB()
    {
        alliance='B';
        rampHight='M';
        whichRamp='B';
        climers=true;
        beacon=false;
        start=true;
    }
    public void planDR()
    {
        alliance='R';
        rampHight='M';
        whichRamp='R';
        climers=true;
        beacon=false;
        start=true;
    }
    public AutoOpmodeStratagems(char Alliance, char RampHight, char WhichRamp, boolean Climers, boolean Beacon, boolean Start)
    {
        alliance = Alliance;
        rampHight = RampHight;
        whichRamp = WhichRamp;
        climers = Climers;
        beacon = Beacon;
        start = Start;
    }
}
