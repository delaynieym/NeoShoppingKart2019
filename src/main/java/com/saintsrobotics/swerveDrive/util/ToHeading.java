/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.saintsrobotics.swerveDrive.util;

import java.util.function.BooleanSupplier;

import com.github.dozer.coroutine.helpers.RunContinuousTask;
import com.saintsrobotics.swerveDrive.Robot;
import com.saintsrobotics.swerveDrive.tasks.teleop.SwerveControl;

import edu.wpi.first.wpilibj.DriverStation;

public class ToHeading extends RunContinuousTask {
    private BooleanSupplier dpadButton;
    private double targetHead;

    public ToHeading(BooleanSupplier dpadButton, double targetHead) {
        this.dpadButton = dpadButton;
        this.targetHead = targetHead;
    }

    @Override
    public void runForever() {
        while (true) {
            wait.until(this.dpadButton);
            Robot.instance.swerveControl.setRobotTargetHead(this.targetHead);
        }
    }
}