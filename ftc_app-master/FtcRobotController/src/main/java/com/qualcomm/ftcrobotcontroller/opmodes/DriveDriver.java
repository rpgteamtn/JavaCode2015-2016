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

public class DriveDriver
{
  DcMotor driveMotorLB;
  DcMotor driveMotorLF;
  DcMotor driveMotorRB;
  DcMotor driveMotorRF;


  public DriveDriver(DcMotor lb, DcMotor lf, DcMotor rb, DcMotor rf)
  {
      driveMotorLB = lb;
      driveMotorLF = lf;
      driveMotorRB = rb;
      driveMotorRF = rf;
  }

  public void setMotors(double leftPower, double rightPower)
  {
    driveMotorRF.setPower(rightPower);
    driveMotorRB.setPower(rightPower);
    driveMotorLF.setPower(leftPower);
    driveMotorLB.setPower(leftPower);
  }


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


  public void resetEncoders()
  {
    driveMotorLB.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
    driveMotorLF.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
    driveMotorRF.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
    driveMotorRB.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
  }


  public void moveDist(int Dist, double power)
  {
    double distToGo = driveEncoderMath(Dist);
    resetEncoders();

    driveMotorLB.setTargetPosition((int) distToGo);
    driveMotorLF.setTargetPosition((int) distToGo);
    driveMotorRB.setTargetPosition((int) distToGo);
    driveMotorRF.setTargetPosition((int) distToGo);

    driveMotorLB.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
    driveMotorLF.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
    driveMotorRB.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
    driveMotorRF.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);

    setMotors(power, power);
  }

}
