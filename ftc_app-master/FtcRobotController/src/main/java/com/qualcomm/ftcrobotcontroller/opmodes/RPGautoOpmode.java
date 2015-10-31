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
public class RPGautoOpmode extends LinearOpMode
{
    boolean alliance;
    int rampHight;
    boolean whichRamp;
    boolean climers;
    boolean beacon;
    boolean start;
    DriveDriver DriveDriver;

    public int questionInt(String text,int min, int max)
    {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
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
                });
        int answer = 0; // add answer
        return answer;
    }

    public Boolean questionBool(String text)
    {
        //desplay answers and question
        Boolean answer = false; // add answer
        return answer;
    }

    @Override
    public void runOpMode() throws InterruptedException
    {
        alliance = questionBool("random text");// false = red and true = blue
        rampHight = questionInt("random text", 0, 3);
        whichRamp = questionBool("random text");
        climers = questionBool("random text");
        beacon = questionBool("random text");
        start = questionBool("random text");

        if(alliance = true/*we are blue*/)
        {
            if(start = true)// near to mountain
            {
                DriveDriver.moveDist(0,0);
            }
            else// near to line
            {

            }
        }
        else /* we are red*/
        {

        }
    }

}
