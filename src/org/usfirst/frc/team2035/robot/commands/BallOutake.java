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

public class BallOutake extends Command{ 

	public static OI oi;
	private final BallSucker bs;
	private final Elevator el;
	public BallOutake(){
		super("Spin In");
		
		
		bs = Robot.getBallSucker();
		el = Robot.getElevator();
		requires(bs);
	}
	
	@Override
	protected void execute() {
		bs.spinOut();
		el.lowerElevator();
	}
	
	 
	@Override
	protected void end() {
		bs.spinStop();
		el.stopElevator();
	}

	
	/**
	 * Called just before this Command runs the first time
	 */
	@Override
	protected void initialize() {
		oi = new OI();
		
	}

	@Override
	protected void interrupted() {
		bs.spinStop();
		el.stopElevator();
		
	}
	protected boolean isFinished() {
		return false;
	}
	
}
