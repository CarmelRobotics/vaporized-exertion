package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2035.robot.subsystems.*;
public class FeedMotorIn extends Command{

	private final FeederSystem FEEDING;
	//Initializes the FeederSystem subsystem.
	public static OI oi;
	
	
	public FeedMotorIn()
	{
		super("Feed Motor in");
		
		FEEDING = Robot.getFeed();
		//Returns the value of the FeederSystem subsystem.
		requires(FEEDING);
	}
	protected void initialize()
	{
		oi = new OI();
		
	}
	
	protected void inStart()
	{
		FEEDING.feedIn();
		//Initializes the on condition to the motors
	}
	protected boolean isFinished()
	{
		return true;
	}
	protected void end()
	{
		FEEDING.feedStop();
		//Stops the motors after the button is pressed
	}
	protected void interrupted()
	{
		FEEDING.feedStop();
	}
}

