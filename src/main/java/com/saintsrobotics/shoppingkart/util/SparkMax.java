package com.saintsrobotics.shoppingkart.util;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// wraps a servo
public class SparkMax implements SpeedController {
    private Servo servo;

    public SparkMax(int channel) {
        this.servo = new Servo(channel);
        this.servo.setBounds(2.0, 0, 1.5, 0, 1.0);
    }

    /**
     * maps a -1 to 1 input range to a 0 to 1 output range note that the actual
     * motor controller (piece o' hardware SparkMax(R)) takes a 1 to 2 input range
     * the servo somehow wraps that
     */
    @Override
    public void set(double speed) {
        this.servo.set((speed / 2) + 0.5);
    }

    /**
     * returns a -1 to 1 output range
     */
    @Override
    public double get() {
        return (this.servo.get() - 0.5) * 2;
    }

    @Override
    public void setInverted(boolean isInverted) {
    }

    @Override
    public boolean getInverted() {
        return false;
    }

    @Override
    public void disable() {
        this.servo.setDisabled();
    }

    @Override
    public void stopMotor() {
        this.servo.stopMotor();
    }

    @Override
    public void pidWrite(double output) {
        this.set(output);
    }

}