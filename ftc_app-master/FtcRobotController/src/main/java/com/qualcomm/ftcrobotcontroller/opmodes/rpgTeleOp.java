package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.opmodes.Drivers.DriveDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

import java.lang.Override;

/**
 * Created by Jonah on 12/19/2015.
 */
public class rpgTeleOp extends OpMode {
    DcMotor driveMotorLF;
    DcMotor driveMotorLB;
    DcMotor driveMotorRF;
    DcMotor driveMotorRB;
    DcMotor debrisLiftMotor;
    DcMotor armMotor;
    Servo debrisServo;
    Servo churroServo;
    Servo LiftServo;
    Servo DoorServo;

    DriveDriver DriveDriver;
    int armMotorValue;
    double left;
    double right;

    float armPower;

    double debrisServoOpen = .37;//switch to 105 when the new string is attached
    double debrisServoClosed = .07;
    double LiftServoOpen = .37;
    double LiftServoClosed = .07;
    double DoorServoOpen = 0;
    double DoorServoClosed = 1;
    double churroServoOpen = 0;
    double churroServoClosed = 1;

    char debrisOC = 'C';
    boolean debrisServoSwitched = false;

    double mediumPower = 0.75;
    double smallPower = 0.5;

    double diameter = 1.95;
    double circumference = diameter * Math.PI;
    double maxlength = 30;
    double rotations = maxlength / circumference;
    double CPR = 1440;
    double armLimit = rotations * CPR;

    double triggerMargen = .8;
    char churroOC = 'O';
    boolean churroServoSwitched = false;

 /* This does not work with the servos. Possibly too many digits after decimal point.
    public double conversion(int servoValue) {
        return servoValue = servoValue / 255;
    }
*/
    // Overrides previous function
    @Override
    public void init() {
        // Connects program motors to actual motors
        // Applys to individual motors
        // Programs for ran on driverMotor now apply to robot motors
        driveMotorLB = hardwareMap.dcMotor.get("driveMotorLB");
        driveMotorLF = hardwareMap.dcMotor.get("driveMotorLF");
        driveMotorRF = hardwareMap.dcMotor.get("driveMotorRF");
        driveMotorRB = hardwareMap.dcMotor.get("driveMotorRB");
        armMotor = hardwareMap.dcMotor.get("armMotor");
        debrisLiftMotor = hardwareMap.dcMotor.get("debrisLiftMotor");
        debrisServo = hardwareMap.servo.get("debrisServo");
        churroServo = hardwareMap.servo.get("churroServo");

        DriveDriver = new DriveDriver(driveMotorLB, driveMotorLF, driveMotorRB, driveMotorRF);
        driveMotorRF.setDirection(DcMotor.Direction.REVERSE);
        driveMotorRB.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {

        // Sets values for joystick
        // Note: Applies to sides of robot not each motor

        // if ((gamepad1.left_stick_y != 0) && (gamepad1.right_stick_y != 0)) {
        left = -gamepad1.left_stick_y;
        right = -gamepad1.right_stick_y;
        // Sets power to each motor
        // Automatically connects motors to joystick
        DriveDriver.setMotors(left, right);

        // if ((!gamepad1.right_bumper || !gamepad1.left_bumper)) {

          /*  } else if (gamepad1.right_bumper) {
                left = -gamepad1.left_stick_y;
                right = -gamepad1.right_stick_y;
                DriveDriver.setMotors(left * smallPower, right * smallPower);
            } else if (gamepad1.left_bumper) {
                left = -gamepad1.left_stick_y;
                right = -gamepad1.right_stick_y;
                DriveDriver.setMotors(left * mediumPower, right * mediumPower);

            }*/

        if ((Math.abs(armMotor.getCurrentPosition()) >= 5500) && (-gamepad2.right_stick_y > 0)) {
            armMotor.setPower(0);
        } else {
            armPower = -gamepad2.right_stick_y;
            armMotor.setPower(armPower); //when the stick is forward, arm goes forward
        }


        if (gamepad2.dpad_up) {
            debrisLiftMotor.setPower(1);
        } else if (gamepad2.dpad_down) {

            debrisLiftMotor.setPower(-1);
        } else {
            debrisLiftMotor.setPower(0);
        }

        if ((gamepad2.a == true) && (debrisServoSwitched == false)) {
            switch (debrisOC) {
                //LiftServo.setPosition(LiftServoClosed);
                case 'O':
                    debrisServo.setPosition(debrisServoClosed);
                    debrisServoSwitched = true;
                    debrisOC = 'C';
                    break;
               // LiftServo.setPosition(LiftServoOpen);
                case 'C':
                    debrisServo.setPosition(debrisServoOpen);
                    debrisServoSwitched = true;
                    debrisOC = 'O';
                    break;
                //LiftServo.setPosition(LiftServoClosed);
                default:
                    debrisServo.setPosition(debrisServoClosed);
                    debrisServoSwitched = true;
                    debrisOC = 'C';
                    break;
            }
        }
        if ((gamepad2.a == false) && (debrisServoSwitched = true)) {
            debrisServoSwitched = false;
        }

            if ((gamepad1.right_trigger > triggerMargen) && (churroServoSwitched == false)) {
                switch (churroOC) {
                    //DoorServo.setPosition(DoorServoClosed);
                    case 'O':
                        churroServo.setPosition(churroServoClosed);
                        churroServoSwitched = true;
                        churroOC = 'C';
                        break;
                   // DoorServo.setPosition(DoorServoOpen);
                    case 'C':
                        churroServo.setPosition(churroServoOpen);
                        churroServoSwitched = true;
                        churroOC = 'O';
                        break;
                  //  DoorServo.setPosition(DoorServoClosed);
                    default:
                        churroServo.setPosition(churroServoClosed);
                        churroServoSwitched = true;
                        churroOC = 'C';
                        break;
                }

            }
            if ((gamepad1.right_trigger < triggerMargen) && (churroServoSwitched = true)) {
                churroServoSwitched = false;
            }
        }
    }