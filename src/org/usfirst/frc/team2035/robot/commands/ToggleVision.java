/*----------------------------------------------------------------------------*/
/*  (c) 2017 FIRST Team 2035. All Rights Reserved.                  		  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2035.robot.subsystems.Shooter;
import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;

/**
 *
 */
public class ToggleVision extends Command {
	
	private Shooter shoot;
	public static OI oi;
	
	public ToggleVision() {
		shoot = Robot.getShooter();
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		oi = new OI();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (Shooter.manual) {
			shoot.switchToPID();
		}
		else if (!Shooter.manual) {
			shoot.switchToManual();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true;
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

