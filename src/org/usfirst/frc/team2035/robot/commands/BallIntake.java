/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.BallSucker;
import org.usfirst.frc.team2035.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Command to intake balls from off the ground
 * @author Team 2035
 */
public class BallIntake extends Command { 

	public static OI oi;
	private final BallSucker bs;
	private final Elevator el;
	
	/**
	 * Creates a new BallIntake command
	 * Initializes BallSucker and Elevator subsystems
	 * Requires BallSucker
	 */
	public BallIntake(){
		super("Spin In");
		bs = Robot.getBallSucker();
		el = Robot.getElevator();
		requires(bs);
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
	 * Spins ball intake and the elevator motors forwards
	 */
	@Override
	protected void execute() {
		bs.spinIn();
		el.liftElevator();
	}
	
	/**
	 * Make this false because the intake continues running
	 * @return false
	 */
	protected boolean isFinished() {
		return false;
	}
	
	/**
	 * Called once after isFinished returns true
	 * Stops the intake and elevator motors
	 */
	@Override
	protected void end() {
		bs.spinStop();
		el.stopElevator();
	}

	/**
	 * Called when another command which requires one or more of the same subsystems is scheduled to run
	 * Stops the intake and elevator motors
	 */
	@Override
	protected void interrupted() {
		bs.spinStop();
		el.stopElevator();
	}
	
}
