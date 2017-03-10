/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2035.robot.subsystems.Shooter;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.OI;

/**
 * Command to turn the turret to the left
 * @author Team 2035
 */
public class TurretLeft extends Command {
	
	public static OI oi;
	public static Shooter shooter;
	
	/**
	 * Creates a new TurretLeft command
	 * Initializes shooter subsystem
	 * Requires Shooter
	 */
	public TurretLeft() {
		super("Turret Left");
		shooter = Robot.getShooter();
		requires(shooter);
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
	 * Moves the turret to the left
	 */
	@Override
	protected void execute() {
		shooter.turretMoveLeft();
	}

	/**
	 * Make this false so the turret will continue to turn
	 * @return false
	 */
	@Override
	protected boolean isFinished() {
		return false;
	}

	/**
	 * Called once after isFinished returns true
	 * Stops the turret
	 */
	@Override
	protected void end() {
		shooter.manualTurretStop();
	}

	/**
	 * Called when another command which requires one or more of the same subsystems is scheduled to run
	 * Stops the turret
	 */
	@Override
	protected void interrupted() {
		shooter.manualTurretStop();
	}
}

