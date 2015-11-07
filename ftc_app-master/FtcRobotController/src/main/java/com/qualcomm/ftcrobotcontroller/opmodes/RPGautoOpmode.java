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
    boolean alliance;
    char rampHight;
    boolean whichRamp;
    boolean climers;
    boolean beacon;
    boolean start;
    DriveDriver DriveDriver;

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
                    DriveDriver.moveDist(0, 0);
                    //turnC 45???
                    DriveDriver.moveDist(0, 0);
                    //turn
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
                        //turnD
                        DriveDriver.moveDist(0, 0);
                        //turnE
                        DriveDriver.moveDist(0, 0);
                    } else {
                        //turn
                        DriveDriver.moveDist(0, 0);
                        //turn
                        DriveDriver.moveDist(0, 0);
                    }

                } else {
                    DriveDriver.moveDist(0, 0);
                    //turn
                    DriveDriver.moveDist(0, 0);
                    //turn
                    DriveDriver.moveDist(0, 0);
                }
                switch (rampHight) {
                    case 'P':
                        DriveDriver.moveDist(0, 0);
                    case 'L':
                        DriveDriver.moveDist(0, 0);
                    case 'M':
                        DriveDriver.moveDist(0, 0);
                    case 'H':
                        DriveDriver.moveDist(0, 0);
                }
            } else// near to line
            {
                if ((climers = true) || (beacon = true)) {
                    DriveDriver.moveDist(0, 0);
                    //turnC 45???
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
                        //turnD
                        DriveDriver.moveDist(0, 0);
                        //turnE
                        DriveDriver.moveDist(0, 0);
                    } else {
                        //turn
                        DriveDriver.moveDist(0, 0);
                        //turn
                        DriveDriver.moveDist(0, 0);
                    }

                } else {
                    if (whichRamp = true) {
                        DriveDriver.moveDist(0, 0);
                        //turnD
                        DriveDriver.moveDist(0, 0);
                    } else {
                        DriveDriver.moveDist(0, 0);
                        //turn
                        DriveDriver.moveDist(0, 0);
                    }

                }
                switch (rampHight) {
                    case 'P':
                        DriveDriver.moveDist(0, 0);
                    case 'L':
                        DriveDriver.moveDist(0, 0);
                    case 'M':
                        DriveDriver.moveDist(0, 0);
                    case 'H':
                        DriveDriver.moveDist(0, 0);
                }

            }
        } else /* we are red*/

        {
            if (start = true)// near to mountain
            {
                if ((climers = true) || (beacon = true)) {
                    DriveDriver.moveDist(0, 0);
                    //turnC 45???
                    DriveDriver.moveDist(0, 0);
                    //turn
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
                        //turnD
                        DriveDriver.moveDist(0, 0);
                        //turnE
                        DriveDriver.moveDist(0, 0);
                    } else {
                        //turn
                        DriveDriver.moveDist(0, 0);
                        //turn
                        DriveDriver.moveDist(0, 0);
                    }

                } else {
                    DriveDriver.moveDist(0, 0);
                    //turn
                    DriveDriver.moveDist(0, 0);
                    //turn
                    DriveDriver.moveDist(0, 0);
                }
                switch (rampHight) {
                    case 'P':
                        DriveDriver.moveDist(0, 0);
                    case 'L':
                        DriveDriver.moveDist(0, 0);
                    case 'M':
                        DriveDriver.moveDist(0, 0);
                    case 'H':
                        DriveDriver.moveDist(0, 0);
                }

            } else// near to line
            {
                if ((climers = true) || (beacon = true)) {
                    DriveDriver.moveDist(0, 0);
                    //turnC 45???
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
                        //turnD
                        DriveDriver.moveDist(0, 0);
                        //turnE
                        DriveDriver.moveDist(0, 0);
                    } else {
                        //turn
                        DriveDriver.moveDist(0, 0);
                        //turn
                        DriveDriver.moveDist(0, 0);
                    }

                } else {
                    if (whichRamp = true) {
                        DriveDriver.moveDist(0, 0);
                        //turnD
                        DriveDriver.moveDist(0, 0);
                    } else {
                        DriveDriver.moveDist(0, 0);
                        //turn
                        DriveDriver.moveDist(0, 0);
                    }

                }
                switch (rampHight) {
                    case 'P':
                        DriveDriver.moveDist(0, 0);
                    case 'L':
                        DriveDriver.moveDist(0, 0);
                    case 'M':
                        DriveDriver.moveDist(0, 0);
                    case 'H':
                        DriveDriver.moveDist(0, 0);
                }

            }
        }
    }
}

