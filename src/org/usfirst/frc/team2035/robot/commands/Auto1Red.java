/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.*;
import org.usfirst.frc.team2035.robot.OI;
import edu.wpi.first.wpilibj.Timer;

/**
 * Autonomous to drive forward and place a gear on the hook while on the RED ALLIANCE
 * @author Team 2035
 */
public class Auto1Red extends Command {
	
	private DriveTrain driver;
	private Shooter shooter;
	private BallSucker bs;
	public static OI oi;
	private Timer autoTimer;
	
	/**
	 * Creates a new Auto1Red command
	 * Initializes driver and shooter subsystems
	 * Requires DriveTrain subsystem
	 */
	public Auto1Red() {
		super("Autonomous 1 Red");
		driver = Robot.getDriveTrain();
		shooter = Robot.getShooter();
		bs = Robot.getBallSucker();
		requires(driver);
	}

	/**
	 * Called just before this Command runs the first time
	 * Begins the autonomous timer
	 */
	@Override
	protected void initialize() {
		oi = new OI();
		autoTimer = new Timer();
	}

	/**
	 * Called repeatedly when this Command is scheduled to run
	 * Drives forwards for 1.9 seconds at .4 speed
	 */
	@Override
	protected void execute() {
		autoTimer.start();
		bs.armDown();
		//shooter.moveEyelid(45);
		//shooter.switchToPID();
		//shooter.turretMoveRight();
		//double currentTime = autoTimer.get();
		//while(autoTimer.get() <= (currentTime + 3)) {
		//	shooter.shoot();
		//}
		//shooter.stopShoot();
		double currentTime = autoTimer.get();
		while(autoTimer.get() <= (currentTime + 1.9)) {
			driver.drive(-.4, 0.0);
		}
		//TODO: Add gear mechanism
	}

	/**
	 * Make this true because autonomous only runs once
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

