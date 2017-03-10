/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2035.robot.subsystems.BallSucker;
import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;

/**
 * Command to toggle whether the arm is up or down
 */
public class ToggleArm extends Command {
	
	private BallSucker bs;
	public static OI oi;
	
	/**
	 * Creates a new ToggleArm command
	 */
	public ToggleArm() {
		bs = Robot.getBallSucker();
	}

	/**
	 * Called just before this Command runs the first time
	 */
	@Override
	protected void initialize() {
		oi = new OI();
	}

	/**
	 * Called repeatedly when this Command is scheduled to run
	 */
	@Override
	protected void execute() {
		if (BallSucker.up) {
			bs.armDown();
			BallSucker.up = false;
		}
		else if (!BallSucker.up) {
			bs.armUp();
			BallSucker.up = true;
		}
	}

	/**
	 * Make this true because a toggle switches once
	 * @return true
	 */
	@Override
	protected boolean isFinished() {
		return true;
	}

	/**
	 * Called once after isFinished returns true
	 */
	@Override
	protected void end() {
		
	}

	/**
	 * Called when another command which requires one or more of the same subsystems is scheduled to run
	 */
	@Override
	protected void interrupted() {
		
	}
}

