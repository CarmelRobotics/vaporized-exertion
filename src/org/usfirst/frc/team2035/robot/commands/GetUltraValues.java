/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.MaxbotixUltrasonic;
import org.usfirst.frc.team2035.robot.OI;

/**
 * Command to receive a value from the ultrasonic sensor
 */
public class GetUltraValues extends Command {
	
	private final MaxbotixUltrasonic ultraSonic;
	public static OI oi;
	
	/**
	 * Creates a new GetUltraValues command
	 */
	public GetUltraValues() {
		// Use requires() here to declare subsystem dependencies
		super("Get Ultra Values");
		ultraSonic = Robot.ultraSonic;
		//requires(ultraSonic); ultraSonic is not a Subsystem
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
		double voltage = ultraSonic.getVoltage();
		double distance = ultraSonic.getRangeInCM();
		System.out.println("VOLTAGE: " + voltage);
		System.out.println("DISTANCE: " + distance);
		System.out.println("-----------------------------------------------------------");
	}
	
	public double output() {
		double distance = ultraSonic.getRangeInCM();
		return distance;
	}

	/**
	 * Make this false because you want to continue receiving values
	 * @return false
	 */
	@Override
	protected boolean isFinished() {
		return false;
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