/*
 * Copyright (c) 2015 Qualcomm Technologies Inc
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted
 * (subject to the limitations in the disclaimer below) provided that the following conditions are
 * met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions
 * and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 * and the following disclaimer in the documentation and/or other materials provided with the
 * distribution.
 *
 * Neither the name of Qualcomm Technologies Inc nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS LICENSE. THIS
 * SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF
 * THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

import java.text.SimpleDateFormat;
import java.util.Date;


//This program keeps the functions for the drive train

public class DriveDriver
{
  //Define the motors
      DcMotor driveMotorLB;//LB  is left back
      DcMotor driveMotorLF;//LF  is left front
      DcMotor driveMotorRB;//RB is Right Back
      DcMotor driveMotorRF;//RF  is right front

      // this FUnction allows other programs to use the drive driver functions
      public DriveDriver(DcMotor lb, DcMotor lf, DcMotor rb, DcMotor rf)
      {
          driveMotorLB = lb;
          driveMotorLF = lf;
          driveMotorRB = rb;
          driveMotorRF = rf;
      }

      //set motors get inputs of the left and right power and sends commands
      public void setMotors(double leftPower, double rightPower)
      {
        driveMotorRF.setPower(rightPower);//sets RF as the right power
        driveMotorRB.setPower(rightPower);//sets RB as the right power
        driveMotorLF.setPower(leftPower);//sets LF as the left power
        driveMotorLB.setPower(leftPower);//sets LB as the left power
      }

    //this function gets an input of the distance you want to travel IN INCHES and returns
    // the number of clicks that the encoder needs to travel
      public double driveEncoderMath(int Dist)
      {

        int ENCODER_CPR = 1440;     //Encoder Counts per Revolution
        double GEAR_RATIO = 1;      //Gear Ratio
        int WHEEL_DIAMETER = 0;     //Diameter of the wheel in inches

       double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
        double ROTATIONS = Dist / CIRCUMFERENCE;
        double finalDist = ENCODER_CPR * ROTATIONS * GEAR_RATIO;

        return finalDist;
      }

    //this function resets the encoders to 0
      public void resetEncoders()
      {
        driveMotorLB.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        driveMotorLF.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        driveMotorRF.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        driveMotorRB.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
      }

    //gets inputs of the distance IN INCHES and power and goes the distance you set at the power you set
      public void moveDist(int Dist, double power)
      {
        double distToGo = driveEncoderMath(Dist);// uses the Function driveEncoderMath to convert inchs to clicks
        resetEncoders();// sets the encoders to 0 so that we get an accurate distance

        //sets target possistion of each encoder
        driveMotorLB.setTargetPosition((int) distToGo);
        driveMotorLF.setTargetPosition((int) distToGo);
        driveMotorRB.setTargetPosition((int) distToGo);
        driveMotorRF.setTargetPosition((int) distToGo);

        //sets the run mode of the motors to the target positions
        driveMotorLB.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        driveMotorLF.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        driveMotorRB.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        driveMotorRF.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);

        //uses the function setMotors to set the motors to the power inputed into the function
        setMotors(power, power);
      }

      public void turn(double Lpower, double Rpower, int time)
      {
        setMotors(Lpower, Rpower);
        double newTime = time * 1000;

        sleep(newTime);

      }
}
