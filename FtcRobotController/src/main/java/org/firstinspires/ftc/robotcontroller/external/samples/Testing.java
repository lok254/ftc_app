
package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.eventloop.opmode.Enabled;

@TeleOp(name = "Testing", group = "Concept")
public abstract class Testing extends OpMode {


    DcMotor Test;

    Servo STest;
    Servo STest2;

    @Override
    public void init() {

        Test = hardwareMap.dcMotor.get("Test");
        STest = hardwareMap.servo.get("STEST");
        STest2 = hardwareMap.servo.get("STEST2");

    }

    @Override
    public void loop() {

        float Testy = -gamepad1.left_stick_y;

        Test.setPower(Testy);

        if (gamepad1.dpad_up) {
            STest.setPosition(0.5); }

        if(gamepad1.dpad_down) {
            STest2.setPosition(0.5);
        }




    }
}