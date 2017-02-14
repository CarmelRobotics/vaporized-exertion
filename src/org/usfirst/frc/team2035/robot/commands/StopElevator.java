package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.Robot;

import org.usfirst.frc.team2035.robot.OI;

import org.usfirst.frc.team2035.robot.subsystems.NewElevator;

import edu.wpi.first.wpilibj.command.Command;

public class StopElevator extends Command {
	
	private final NewElevator stop;
	public static OI oi;

	public StopElevator()
	{
		super("Stop Elevator");
		
		stop = Robot.getNewElevator();
		requires(stop);
		
	}
	
	protected void initialize()
	{
		
		oi = new OI();
		
		
	}
	
	protected void execute(){
		stop.stopElevator();
	}
	
	protected void end() 
	{
		
		stop.stopElevator();
	}
	
	protected void interupted()
	{
		stop.stopElevator();
		
	}

	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
