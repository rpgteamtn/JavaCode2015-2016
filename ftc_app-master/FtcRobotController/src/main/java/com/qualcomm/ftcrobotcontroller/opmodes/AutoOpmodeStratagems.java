package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Jonah on 11/21/2015.
 */
public class AutoOpmodeStratagems {
    Boolean alliance;//blue  is true
    char rampHight;
    boolean whichRamp; //blue  is true
    boolean climers;
    boolean beacon;
    boolean start;// true is near mountain

    public void planAB()
    {
         alliance=true;
         rampHight='M';
         whichRamp=true;
         climers=true;
         beacon=true;
         start=false;
    }
    public void planAR()
    {
        alliance=false;
        rampHight='L';
        whichRamp=false;
        climers=true;
        beacon=true;
        start=false;
    }
    public void planBB()
    {
        alliance=true;
        rampHight='M';
        whichRamp=true;
        climers=true;
        beacon=true;
        start=true;
    }
    public void planBR()
    {
        alliance=false;
        rampHight='M';
        whichRamp=false;
        climers=true;
        beacon=true;
        start=true;
    }
    public void planCB()
    {
        alliance=true;
        rampHight='M';
        whichRamp=true;
        climers=true;
        beacon= false;
        start=false;
    }
    public void planCR()
    {
        alliance=false;
        rampHight= 'M';
        whichRamp=false;
        climers=true;
        beacon=false;
        start=false;
    }
    public void planDB()
    {
        alliance=true;
        rampHight='M';
        whichRamp=true;
        climers=true;
        beacon=false;
        start=true;
    }
    public void planDR()
    {
        alliance=false;
        rampHight='M';
        whichRamp=false;
        climers=true;
        beacon=false;
        start=true;
    }
    public AutoOpmodeStratagems(boolean Alliance, char RampHight, Boolean WhichRamp, boolean Climers, boolean Beacon, boolean Start)
    {
        alliance = Alliance;
        rampHight = RampHight;
        whichRamp = WhichRamp;
        climers = Climers;
        beacon = Beacon;
        start = Start;
    }
}
