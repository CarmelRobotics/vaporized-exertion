package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2035.robot.subsystems.BallSucker;

import org.usfirst.frc.team2035.robot.Robot;

/**
 *
 */
public class ToggleArm extends Command {
	
	private BallSucker bs;
	public static OI oi;
	
	public ToggleArm() {
		bs = Robot.getBallSucker();
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		oi = new OI();
	}

	// Called repeatedly when this Command is scheduled to run
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

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}