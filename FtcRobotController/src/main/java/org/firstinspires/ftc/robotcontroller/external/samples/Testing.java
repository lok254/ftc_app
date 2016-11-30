
package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Testing", group = "Concept")
public class Testing extends LinearOpMode {

    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();

    DcMotor Test1;
    DcMotor Test2;
    Servo STest1;
    Servo STest2;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Testing Initialized");
        telemetry.update();

        /* eg: Initialize the hardware variables. Note that the strings used here as parameters
         * to 'get' must correspond to the names assigned during the robot configuration
         * step (using the FTC Robot Controller app on the phone).
         */
        Test1 = hardwareMap.dcMotor.get("Test1");
        Test2 = hardwareMap.dcMotor.get("Test2");
        STest1 = hardwareMap.servo.get("STest1");
        STest2 = hardwareMap.servo.get("STest2");

        // eg: Set the drive motor directions:
        // "Reverse" the motor that runs backwards when connected directly to the battery
//        Test1.setDirection(DcMotor.Direction.FORWARD); // Set to FORWARD if using AndyMark motors

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Testing Run Time: " + runtime.toString());
            telemetry.update();

            // eg: Run wheels in tank mode (note: The joystick goes negative when pushed forwards)
            Test1.setPower(-gamepad1.left_stick_y);
            Test2.setPower(-gamepad1.right_stick_y);

            if (gamepad1.dpad_up) {
                STest1.setPosition(0.5);
            } else if (gamepad1.dpad_down) {
                STest1.setPosition(-0.5);
            }

            if (gamepad1.dpad_right) {
                STest2.setPosition(0.5);
            } else if (gamepad1.dpad_left) {
                STest2.setPosition(-0.5);
            }
        }
    }
}
