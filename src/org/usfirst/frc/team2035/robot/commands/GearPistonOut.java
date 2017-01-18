/*----------------------------------------------------------------------------*/
/* Copyright (c) 2016 FIRST Team 2035. All Rights Reserved.                   */
/* Open Source Software - may be modified and shared by FRC teams.            */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.subsystems.GearSystem;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.OI;

public class GearPistonOut extends Command {
	
	private final GearSystem gear;
	public static OI oi;
	
	public GearPistonOut() {
        super("Gear Piston Out");
        gear = Robot.getGearSystem();
        requires(gear);
    }

	@Override
	protected void execute() {
		gear.gearPistonOut();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		gear.gearPistonIn();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		gear.gearPistonIn();
	}

	}

