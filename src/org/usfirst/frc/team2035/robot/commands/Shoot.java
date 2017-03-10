/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Command to shoot balls
 */
public class Shoot extends Command { 

	public static OI oi;
	private final Shooter shooter;
	
	/**
	 * Creates a new Shoot command
	 */
	public Shoot(){
		super("Shoot");
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
	 */
	@Override
	protected void execute() {
		if(Shooter.manual) {
			shooter.shoot();
		}
	}
	
	/**
	 * Make this false because the shooter should continue to go
	 * @return false
	 */
	protected boolean isFinished() {
		return false;
	}
	
	/**
	 * Called once after isFinished returns true
	 */ 
	@Override
	protected void end() {
		shooter.stopShoot();
	}
	
	/**
	 * Called when another command which requires one or more of the same subsystems is scheduled to run
	 */
	@Override
	protected void interrupted() {
		shooter.stopShoot();
	}
	
}
