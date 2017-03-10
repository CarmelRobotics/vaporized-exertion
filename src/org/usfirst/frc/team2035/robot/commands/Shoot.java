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

public class Shoot extends Command { 

	public static OI oi;
	private final Shooter shooter;
	public Shoot(){
		super("Shoot");
		shooter = Robot.getShooter();
		requires(shooter);
	}
	
	@Override
	protected void execute() {
		if(Shooter.manual) {
			shooter.shoot();
		}
		
	}
	
	 
	@Override
	protected void end() {
		shooter.stopShoot();
	}

	

	@Override
	protected void initialize() {
		oi = new OI();
		
	}

	@Override
	protected void interrupted() {
		shooter.stopShoot();
		
	}
	protected boolean isFinished() {
		return false;
	}
	
}
