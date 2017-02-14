package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.Robot;

import org.usfirst.frc.team2035.robot.OI;

import org.usfirst.frc.team2035.robot.subsystems.NewElevator;

import edu.wpi.first.wpilibj.command.Command;

public class LowerElevator extends Command {
	
	private final NewElevator lower;
	public static OI oi;

	public LowerElevator()
	{
		super();
		
		lower = Robot.getNewElevator();
		requires(lower);
		
	}
	
	protected void initialize()
	{
		
		oi = new OI();
		
		
	}
	
	protected void execute(){
		lower.lowerElevator();
	}
	
	protected void end() 
	{
		
		lower.stopElevator();
	}
	
	protected void interupted()
	{
		lower.stopElevator();
		
	}

	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
