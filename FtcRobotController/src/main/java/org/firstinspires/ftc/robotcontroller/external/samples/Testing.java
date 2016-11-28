
package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
//import com.qualcomm.robotcore.eventloop.opmode.Enabled;

@TeleOp(name = "Testing", group = "Concept")
public abstract class Testing extends LinearOpMode {
    
    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();
    DcMotor Test;

    Servo STest;
    Servo STest2;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        /* eg: Initialize the hardware variables. Note that the strings used here as parameters
         * to 'get' must correspond to the names assigned during the robot configuration
         * step (using the FTC Robot Controller app on the phone).
         */
        // leftMotor  = hardwareMap.dcMotor.get("left_drive");
        // rightMotor = hardwareMap.dcMotor.get("right_drive");
        Test = hardwareMap.dcMotor.get("Test");
        STest = hardwareMap.servo.get("STEST");
        STest2 = hardwareMap.servo.get("STEST2");

        // eg: Set the drive motor directions:
        // "Reverse" the motor that runs backwards when connected directly to the battery
        // leftMotor.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        // rightMotor.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();

            // eg: Run wheels in tank mode (note: The joystick goes negative when pushed forwards)
            // leftMotor.setPower(-gamepad1.left_stick_y);
            // rightMotor.setPower(-gamepad1.right_stick_y);
            float Testy = -gamepad1.left_stick_y;

            Test.setPower(Testy);

            if (gamepad1.dpad_up) {
                STest.setPosition(0.5);
            }

            if(gamepad1.dpad_down) {
                STest2.setPosition(0.5);
            }
        }
    }

//    @Override
//    public void init() {
//
//        Test = hardwareMap.dcMotor.get("Test");
//        STest = hardwareMap.servo.get("STEST");
//        STest2 = hardwareMap.servo.get("STEST2");
//
//    }
//
//    @Override
//    public void loop() {
//
//        float Testy = -gamepad1.left_stick_y;
//
//        Test.setPower(Testy);
//
//        if (gamepad1.dpad_up) {
//            STest.setPosition(0.5); }
//
//        if(gamepad1.dpad_down) {
//            STest2.setPosition(0.5);
//        }
//    }
}