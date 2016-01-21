package com.qualcomm.ftcrobotcontroller.opmodes.Drivers;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
//import com.qualcomm.ftcrobotcontroller.opmodes.other.PushBotHardware;
import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.Timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


//This program keeps the functions for the drive train

public class DriveDriver{
    //Define the motors
    DcMotor driveMotorLB;//LB  is left back
    DcMotor driveMotorLF;//LF  is left front
    DcMotor driveMotorRB;//RB is Right Back
    DcMotor driveMotorRF;//RF  is right front
    double distTraveled;
    double distLeft;
    double speedGoing;
    double maxSpeed = 0.7;
    double BreakPoint;
    double encoders;
    Timer timer =  new Timer();
    // this FUnction allows other programs to use the drive driver functions
    public DriveDriver(DcMotor lb, DcMotor lf, DcMotor rb, DcMotor rf) {
        driveMotorLB = lb;
        driveMotorLF = lf;
        driveMotorRB = rb;
        driveMotorRF = rf;
    }

    //set motors get inputs of the left and right power and sends commands
    public void setMotors(double leftPower, double rightPower) {
        driveMotorRF.setPower(rightPower);//sets RF as the right power
        driveMotorRB.setPower(rightPower);//sets RB as the right power
        driveMotorLF.setPower(leftPower);//sets LF as the left power
        driveMotorLB.setPower(leftPower);//sets LB as the left power
    }

    //this function gets an input of the distance you want to travel IN INCHES and returns
// the number of clicks that the encoder needs to travel
    public double driveEncoderMath(double Dist) {

        int ENCODER_CPR = 1440;     //Encoder Counts per Revolution
        double GEAR_RATIO = 2 / 1;      //Gear Ratio
        int WHEEL_DIAMETER = 2;     //Diameter of the wheel in inches

        double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
        double ROTATIONS = Dist / CIRCUMFERENCE;
        double finalDist = ENCODER_CPR * ROTATIONS * GEAR_RATIO;

        return finalDist;
    }

    //this function resets the encoders to 0
    public void resetEncoders() {
        driveMotorLB.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        driveMotorLF.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        driveMotorRF.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        driveMotorRB.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
    }

//gets inputs of the distance IN INCHES and power and goes the distance you set at the power you set
  /*public void moveDist (double Dist, double power)
  {
      setMotors(0, 0);

    Dist = driveEncoderMath(Dist);// uses the Function driveEncoderMath to convert inchs to clicks
    resetEncoders();// sets the encoders to 0 so that we get an accurate distance

    //sets target possistion of each encoder
    driveMotorLB.setTargetPosition((int) Dist);
    driveMotorLF.setTargetPosition((int) Dist);
    driveMotorRB.setTargetPosition((int) Dist);
    driveMotorRF.setTargetPosition((int) Dist);

    //sets the run mode of the motors to the target positions
    driveMotorLB.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
    driveMotorLF.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
    driveMotorRB.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
    driveMotorRF.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);

    //uses the function setMotors to set the motors to the power inputed into the function
    setMotors(1, 1);
  }*/

    public void turn(double Degree, double power) throws InterruptedException {
        setMotors(0,0);

        TimeUnit.SECONDS.sleep(2);

        Degree = Degree * 7.375;
        Degree = Degree * 4;

        resetEncoders();
        driveMotorLB.setTargetPosition((int) Degree);
        driveMotorLF.setTargetPosition((int) Degree);
        driveMotorRB.setTargetPosition((int) Degree * -1);
        driveMotorRF.setTargetPosition((int) Degree * -1);

        driveMotorLB.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        driveMotorLF.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        driveMotorRB.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        driveMotorRF.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        
        setMotors(power, power * -1);
    }

    /*public void moveDist(double targetDist, double power) {
        targetDist = driveEncoderMath(targetDist);// uses the Function driveEncoderMath to convert inchs to clicks
    resetEncoders();// sets the encoders to 0 so that we get an accurate distance


        //sets target position of each encoder
        driveMotorLB.setTargetPosition((int) targetDist);
        driveMotorLF.setTargetPosition((int) targetDist);
        driveMotorRB.setTargetPosition((int) targetDist);
        driveMotorRF.setTargetPosition((int) targetDist);

        driveMotorLB.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        driveMotorLF.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        driveMotorRB.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        driveMotorRF.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);

        while (distTraveled < targetDist)
        {
            if (distTraveled < targetDist * 0.5 && speedGoing < maxSpeed) {
                speedGoing = speedGoing + 0.1;
                if (speedGoing == maxSpeed) {
                    BreakPoint = targetDist - distTraveled;
                }
            }
            if ((distTraveled < targetDist + 0.5) && (speedGoing == maxSpeed)) {
                speedGoing = speedGoing;
            }
            if (distTraveled > targetDist * 0.5 && speedGoing < maxSpeed) {
                speedGoing = speedGoing - 0.1;

            }
            if (distTraveled == BreakPoint) {
                speedGoing = speedGoing - 0.1;
            }

        }

        setMotors(speedGoing, speedGoing);
    }*/
    public void moveDist (double Dist, double power)
    {
        driveMotorLB.setPower(-1);
        Dist = Dist/9*1440;
        driveMotorLB.setPower(1);
        encoders = 0;
        resetEncoders();
        while(Dist>encoders) {
            encoders = ((driveMotorLB.getCurrentPosition()+driveMotorLF.getCurrentPosition()+driveMotorRB.getCurrentPosition()+driveMotorRF.getCurrentPosition())/4);
            setMotors(power, power);
        }
    }
}
