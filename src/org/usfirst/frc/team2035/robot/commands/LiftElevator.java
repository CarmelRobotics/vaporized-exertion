package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.Robot;

import org.usfirst.frc.team2035.robot.OI;

import org.usfirst.frc.team2035.robot.subsystems.NewElevator;

import edu.wpi.first.wpilibj.command.Command;

public class LiftElevator extends Command {
	
	private final NewElevator lift;
	public static OI oi;

	public LiftElevator()
	{
		super("Lift Elevator");
		
		lift = Robot.getNewElevator();
		requires(lift);
		
	}
	
	protected void initialize()
	{
		
		oi = new OI();
		
		
	}
	
	protected void execute(){
		lift.liftElevator();
	}
	
	protected void end() 
	{
		
		lift.stopElevator();
	}
	
	protected void interupted()
	{
		lift.stopElevator();
		
	}

	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
