package com.qualcomm.ftcrobotcontroller.opmodes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.ftcrobotcontroller.opmodes.DriveDriver;

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

    double distA = 84;
    double distB = 16;
    double distC = 21;
    double distD = 45.5;
    double distE = 14;
    double distF = 40;
    double distG = -0;
    double distI= 41;
    double distJ = 51

    double distP = 15;
    double distL = 18;
    double distM = 33;
    double distH = 54;

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
                    DriveDriver.turn(angE, power);//ang I
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

                    DriveDriver.moveDist(0, 0);//back up
                    if (whichRamp = true) {
                        DriveDriver.turn(0, 0, 0);
                        DriveDriver.moveDist(0, 0);
                        DriveDriver.turn(0, 0, 0);
                        DriveDriver.moveDist(0, 0);
                    } else {
                        DriveDriver.turn(0, 0, 0);
                        DriveDriver.moveDist(0, 0);
                        DriveDriver.turn(0, 0, 0);
                        DriveDriver.moveDist(0, 0);
                    }

                } else {
                    DriveDriver.moveDist(0, 0);
                    DriveDriver.turn(0, 0, 0);
                    DriveDriver.moveDist(0, 0);
                    DriveDriver.turn(0, 0, 0);
                    DriveDriver.moveDist(0, 0);
                }
                switch (rampHight) {
                    case 'P':
                        DriveDriver.moveDist(distP, power);
                    case 'L':
                        DriveDriver.moveDist(distL, power);
                    case 'M':
                        DriveDriver.moveDist(distM, power);
                    case 'H':
                        DriveDriver.moveDist(distH, power);
                }
            } else// near to line
            {
                if ((climers = true) || (beacon = true)) {
                    DriveDriver.moveDist((distA + distB), power);
                    DriveDriver.turn(0, 0, 0);// blue angle B
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
                        DriveDriver.turn(0, 0, 0);// angle C blue
                        DriveDriver.moveDist(distF, power);
                        DriveDriver.turn(0, 0, 0); // blue angle D
                        DriveDriver.moveDist(distG, power);
                    } else {
                        DriveDriver.turn(0, 0, 0);
                        DriveDriver.moveDist(0, 0);
                        DriveDriver.turn(0, 0, 0);
                        DriveDriver.moveDist(0, 0);
                    }

                } else {
                    if (whichRamp = true) {//blue ramp
                        DriveDriver.moveDist(distA, power);
                        DriveDriver.turn(0, 0, 0);//angle A
                        DriveDriver.moveDist((distD + distG), power);
                    } else {//red ramp
                        DriveDriver.moveDist(0, 0);
                        DriveDriver.turn(0, 0, 0);
                        DriveDriver.moveDist(0, 0);
                    }

                }
                switch (rampHight) {
                    case 'P':
                        DriveDriver.moveDist(distP, power);
                    case 'L':
                        DriveDriver.moveDist(distL, power);
                    case 'M':
                        DriveDriver.moveDist(distM, power);
                    case 'H':
                        DriveDriver.moveDist(distH, power);
                }

            }
        } else /* we are red*/

        {
            if (start = true)// near to mountain
            {
                if ((climers = true) || (beacon = true)) {
                    DriveDriver.moveDist(0, 0);
                    DriveDriver.turn(0, 0, 0);
                    DriveDriver.moveDist(0, 0);
                    DriveDriver.turn(0, 0, 0);
                    DriveDriver.moveDist(0, 0);

                    if ((climers = true) || (beacon = true)) {
                        //do climers and beacons
                    } else if ((climers = false) || (beacon = true)) {
                        //do beacons
                    } else if ((climers = true) || (beacon = false)) {
                        //do climers
                    } else {
                        //do nothing. this shouldnt accure
                    }

                    DriveDriver.moveDist(0, 0);//back up
                    if (whichRamp = true) {
                        DriveDriver.turn(0, 0, 0);
                        DriveDriver.moveDist(0, 0);
                        DriveDriver.turn(0, 0, 0);
                        DriveDriver.moveDist(0, 0);
                    } else {
                        DriveDriver.turn(0, 0, 0);
                        DriveDriver.moveDist(0, 0);
                        DriveDriver.turn(0, 0, 0);
                        DriveDriver.moveDist(0, 0);
                    }

                } else {
                    DriveDriver.moveDist(0, 0);
                    DriveDriver.turn(0, 0, 0);
                    DriveDriver.moveDist(0, 0);
                    DriveDriver.turn(0, 0, 0);
                    DriveDriver.moveDist(0, 0);
                }
                switch (rampHight) {
                    case 'P':
                        DriveDriver.moveDist(distP, power);
                    case 'L':
                        DriveDriver.moveDist(distL, power);
                    case 'M':
                        DriveDriver.moveDist(distM, power);
                    case 'H':
                        DriveDriver.moveDist(distH, power);
                }

            } else// near to line
            {
                if ((climers = true) || (beacon = true)) {
                    DriveDriver.moveDist((distA + distB), power);
                    DriveDriver.turn(0, 0, 0);// angle B
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
                        DriveDriver.turn(0, 0, 0);
                        DriveDriver.moveDist(distF, power);
                        DriveDriver.turn(0, 0, 0);
                        DriveDriver.moveDist(distG, power);
                    } else {
                        DriveDriver.turn(0, 0, 0);
                        DriveDriver.moveDist(distF, power);
                        DriveDriver.turn(0, 0, 0);
                        DriveDriver.moveDist(distG, power);
                    }

                } else {
                    if (whichRamp = true) {//blue ramp
                        DriveDriver.moveDist(distA, power);
                        DriveDriver.turn(0, 0, 0);//angle A
                        DriveDriver.moveDist((distD + distG), power);
                    } else {//red ramp
                        DriveDriver.moveDist(0, 0);
                        DriveDriver.turn(0, 0, 0);
                        DriveDriver.moveDist(0, 0);
                    }

                }
                switch (rampHight) {
                    case 'P':
                        DriveDriver.moveDist(distP, power);
                    case 'L':
                        DriveDriver.moveDist(distL, power);
                    case 'M':
                        DriveDriver.moveDist(distM, power);
                    case 'H':
                        DriveDriver.moveDist(distH, power);
                }

            }
        }
    }
}

