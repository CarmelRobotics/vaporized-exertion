package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2035.robot.subsystems.*;
public class FeedMotorOut extends Command{

	private final FeederSystem FEEDING;
	//Initializes a FeederSystem subsystem.
	public static OI oi;
	
	
	public FeedMotorOut()
	{
		super("Feed Motor Out");
		
		FEEDING = Robot.getFeed();
		//getFeed returns the value of the feeder.
		requires(FEEDING);
	}
	protected void initialize()
	{
		oi = new OI();
		
	}
	
	protected void outStart()
	{
		FEEDING.feedOut();
		//Initializes the off condition to the motor.
	}
	protected boolean isFinished()
	{
		return true;
	}
	
	protected void end()
	{
		FEEDING.feedStop();
		//After the button is done being pressed, the motor will stop rotating. 
	}
	protected void interrupted()
	{
		FEEDING.feedStop();
	}
}
