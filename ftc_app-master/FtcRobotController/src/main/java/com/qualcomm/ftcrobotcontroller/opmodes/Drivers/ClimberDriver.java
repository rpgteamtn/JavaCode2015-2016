package com.qualcomm.ftcrobotcontroller.opmodes.Drivers;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by Jonah on 12/5/2015.
 */
public class ClimberDriver {
    
    DcMotor ClimerMotor;
    int counts = 10;
    double power = 1;

    public ClimberDriver(DcMotor cm) {
        ClimerMotor = cm;
    }

    public void dropClimers()
    {
        beaconMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        beaconMotor.setTargetPosition(counts);

        beaconMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        beaconMotor.setPower(power);
    }

}
