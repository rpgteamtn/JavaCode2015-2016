package com.qualcomm.ftcrobotcontroller.opmodes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.DriveDriver;

/**
 * Created by Jonah on 10/31/2015.
 */
public class RPGautoOpmode extends LinearOpMode {
    boolean alliance;//blue  is true
    char rampHight;
    boolean whichRamp; //blue  is true
    boolean climers;
    boolean beacon;
    boolean start;// true is near mountain
    DriveDriver DriveDriver;

    double bot = 17;
    double halfBot = bot / 2;
    double botToMt = 6;

    double distA = 84;
    double distB = 16;
    double distC = 21;
    double distD = 45.5;
    double distE = 14;
    double distF = 40;
    double distG = -0;
    double distI= 41;
    double distJ = 51;
    double distK = 64 - halfBot;
    double distL = 67 - botToMt;
    double distM = 38 - halfBot;
    double distN = 86 - halfBot - botToMt;
    double distO = 101 - halfBot;
    double distP = 27 - halfBot - botToMt;


    double distPm = 15;
    double distLm = 18;
    double distMm = 33;
    double distHm = 54;

    double angA = 90;
    double angB = 135;
    double angC = 90;
    double angD = 45;
    double angE = 135;

    double power = .7;

    public void questionRampHight() {
        /*AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Write your message here.");
        builder1.setCancelable(true);
        builder1.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder1.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });*/
        char rampHeight = 'P';
    }

    public Boolean questionBool(String text) {
        //desplay answers and question
        Boolean answer = false; // add answer
        return answer;
    }

    public double reverseAngle(double num) {
        return num = num * -1;
    }

    @Override
    public void runOpMode() throws InterruptedException {
        alliance = questionBool("random text");// false = red and true = blue
        whichRamp = questionBool("random text");
        climers = questionBool("random text");
        beacon = questionBool("random text");
        start = questionBool("random text");
        questionRampHight();

        if (alliance = true/*we are blue*/) {
            if (start = true)// near to mountain
            {
                if ((climers = true) || (beacon = true)) {
                    DriveDriver.moveDist(distI, power);
                    DriveDriver.turn(reverseAngle(angE), power);//ang I
                    DriveDriver.moveDist((distA+distB-distJ), power);
                    DriveDriver.turn(reverseAngle(angB), power);// blue angle B
                    DriveDriver.moveDist((distC + distE), power);

                    if ((climers = true) || (beacon = true)) {
                        //do climers and beacons
                    } else if ((climers = false) || (beacon = true)) {
                        //do beacons
                    } else if ((climers = true) || (beacon = false)) {
                        //do climers
                    } else {
                        //do nothing. this shouldnt accure
                    }

                    DriveDriver.moveDist(23 - halfBot, -power);//back up
                    if (whichRamp = true) {
                        DriveDriver.moveDist(13 , -power);
                        DriveDriver.turn(angA, power);
                        DriveDriver.moveDist(24, power);
                        DriveDriver.turn(45, power);
                        DriveDriver.moveDist(23 - botToMt, power);
                    } else {
                        DriveDriver.turn(180, power);
                        DriveDriver.moveDist(distO, power);
                        DriveDriver.turn(angB, power);
                        DriveDriver.moveDist(distP, power);
                    }

                } else {
                    DriveDriver.moveDist(distM, power);
                    DriveDriver.turn(angB, power);
                    DriveDriver.moveDist(distN, power);

                }
                switch (rampHight) {
                    case 'P':
                        DriveDriver.moveDist(distPm, power);
                    case 'L':
                        DriveDriver.moveDist(distLm, power);
                    case 'M':
                        DriveDriver.moveDist(distMm, power);
                    case 'H':
                        DriveDriver.moveDist(distHm, power);
                }
            } else// near to line
            {
                if ((climers = true) || (beacon = true)) {
                    DriveDriver.moveDist((distA + distB), power);
                    DriveDriver.turn(reverseAngle(angB), power);// blue angle B
                    DriveDriver.moveDist((distC + distE), power);

                    if ((climers = true) || (beacon = true)) {
                        //do climers and beacons
                    } else if ((climers = false) || (beacon = true)) {
                        //do beacons
                    } else if ((climers = true) || (beacon = false)) {
                        //do climers
                    } else {
                        //do nothing. this shouldnt accure
                    }

                    DriveDriver.moveDist(distE, power);//back up
                    if (whichRamp = true) {//blue ramp
                        DriveDriver.turn(reverseAngle(angC),power);// angle C blue
                        DriveDriver.moveDist(distF, power);
                        DriveDriver.turn(reverseAngle(angD),power); // blue angle D
                        DriveDriver.moveDist(distG, power);
                    } else {
                        DriveDriver.turn(180, power);
                        DriveDriver.moveDist(distM, power);
                        DriveDriver.turn(angB, power);
                        DriveDriver.moveDist(distN, power);
                    }

                } else {
                    if (whichRamp = true) {//blue ramp
                        DriveDriver.moveDist(distA, power);
                        DriveDriver.turn(angA,power);//angle A
                        DriveDriver.moveDist((distD + distG), power);
                    } else {//red ramp
                        DriveDriver.moveDist(distK, power);
                        DriveDriver.turn(angA, power);
                        DriveDriver.moveDist(distL, power);
                    }

                }
                switch (rampHight) {
                    case 'P':
                        DriveDriver.moveDist(distPm, power);
                    case 'L':
                        DriveDriver.moveDist(distLm, power);
                    case 'M':
                        DriveDriver.moveDist(distMm, power);
                    case 'H':
                        DriveDriver.moveDist(distHm, power);
                }

            }
        } else /* we are red*/

        {
            if (start = true)// near to mountain
            {
                if ((climers = true) || (beacon = true)) {
                    DriveDriver.moveDist(distI, power);
                    DriveDriver.turn(angE, power);
                    DriveDriver.moveDist(distA + distB - distJ, power);
                    DriveDriver.turn(angB, power);
                    DriveDriver.moveDist(distC + distE, power);

                    if ((climers = true) || (beacon = true)) {
                        //do climers and beacons
                    } else if ((climers = false) || (beacon = true)) {
                        //do beacons
                    } else if ((climers = true) || (beacon = false)) {
                        //do climers
                    } else {
                        //do nothing. this shouldnt accure
                    }

                    DriveDriver.moveDist(distE, -power);//back up
                    if (whichRamp = true) {
                        DriveDriver.moveDist(13, -power);
                        DriveDriver.turn(angA, power);
                        DriveDriver.moveDist(24, power);
                        DriveDriver.turn(45, power);
                        DriveDriver.moveDist(23 - botToMt, power);
                    } else {
                        DriveDriver.turn(180, power);
                        DriveDriver.moveDist(distO, power);
                        DriveDriver.turn(angB, power);
                        DriveDriver.moveDist(distP, power);
                    }

                } else {
                    DriveDriver.moveDist(distM, power);
                    DriveDriver.turn(angB, power);
                    DriveDriver.moveDist(distN, power);
                }
                switch (rampHight) {
                    case 'P':
                        DriveDriver.moveDist(distPm, power);
                    case 'L':
                        DriveDriver.moveDist(distLm, power);
                    case 'M':
                        DriveDriver.moveDist(distMm, power);
                    case 'H':
                        DriveDriver.moveDist(distHm, power);
                }

            } else// near to line
            {
                if ((climers = true) || (beacon = true)) {
                    DriveDriver.moveDist((distA + distB), power);
                    DriveDriver.turn(angB, power);// angle B
                    DriveDriver.moveDist((distC + distE), power);

                    if ((climers = true) || (beacon = true)) {
                        //do climers and beacons
                    } else if ((climers = false) || (beacon = true)) {
                        //do beacons
                    } else if ((climers = true) || (beacon = false)) {
                        //do climers
                    } else {
                        //do nothing. this shouldnt accure
                    }

                    DriveDriver.moveDist(distE, power);//back up
                    if (whichRamp = true) {//blue ramp
                        DriveDriver.turn(angC, power);
                        DriveDriver.moveDist(distF, power);
                        DriveDriver.turn(angD, power);
                        DriveDriver.moveDist(distG, power);
                    } else {
                        DriveDriver.turn(180, power);
                        DriveDriver.moveDist(distM, power);
                        DriveDriver.turn(angB, power);
                        DriveDriver.moveDist(distN, power);
                    }

                } else {
                    if (whichRamp = true) {//blue ramp
                        DriveDriver.moveDist(distA, power);
                        DriveDriver.turn(angA,power);//angle A
                        DriveDriver.moveDist((distD + distG), power);
                    } else {//red ramp
                        DriveDriver.moveDist(distK, power);
                        DriveDriver.turn(angA, power);
                        DriveDriver.moveDist(distL, power);
                    }

                }
                switch (rampHight) {
                    case 'P':
                        DriveDriver.moveDist(distPm, power);
                    case 'L':
                        DriveDriver.moveDist(distLm, power);
                    case 'M':
                        DriveDriver.moveDist(distMm, power);
                    case 'H':
                        DriveDriver.moveDist(distHm, power);
                }

            }
        }
    }
}

