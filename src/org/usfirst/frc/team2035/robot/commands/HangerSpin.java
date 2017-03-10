/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Hanger;

import edu.wpi.first.wpilibj.command.Command;

public class HangerSpin extends Command {

	
	
private final Hanger hanger;
	
	public static OI oi;
	
	
	
	public HangerSpin() {
		super("HangerSpin");
		hanger = Robot.getHanger();
		requires(hanger);
		
		
	}
	
	
	@Override
	protected void initialize() {
		oi = new OI();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		hanger.spin();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		
		hanger.stop();
	
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		
		hanger.stop();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
