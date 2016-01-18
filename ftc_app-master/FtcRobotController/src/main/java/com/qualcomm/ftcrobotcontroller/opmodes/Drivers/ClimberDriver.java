package com.qualcomm.ftcrobotcontroller.opmodes.Drivers;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by Jonah on 12/5/2015.
 */
public class ClimberDriver {
    
    DcMotor ClimberMotor;
    int counts = 10;
    double power = 1;

    public ClimberDriver(DcMotor cm) {
        ClimberMotor = cm;
    }

    public void dropClimbers()
    {
        // Encoders will measure distance travelled
        ClimberMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        ClimberMotor.setTargetPosition(counts);
        // Keeps track of power
        ClimberMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        ClimberMotor.setPower(power);
    }

}
