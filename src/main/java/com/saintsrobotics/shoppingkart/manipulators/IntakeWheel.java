/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.saintsrobotics.shoppingkart.manipulators;

import java.util.function.BooleanSupplier;

import com.github.dozer.coroutine.helpers.RunContinuousTask;
import com.github.dozer.output.Motor;

public class IntakeWheel extends RunContinuousTask {
	private BooleanSupplier trigger;
	private Motor motor;
	private double speed;

	public IntakeWheel(BooleanSupplier trigger, Motor motor, double speed) {
		this.trigger = trigger;
		this.motor = motor;
		this.speed = speed;
	}

	@Override
	protected void runForever() {
		wait.until(this.trigger);
		this.motor.set(this.speed);
		wait.until(() -> !this.trigger.getAsBoolean());
		this.motor.stop();
	}

}