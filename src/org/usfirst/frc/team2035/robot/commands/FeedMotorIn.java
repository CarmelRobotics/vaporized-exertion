package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2035.robot.subsystems.*;
public class FeedMotorIn extends Command{

	private final FeederSystem FEEDING;
	public static OI oi;
	
	
	public FeedMotorIn()
	{
		super("Feed Motor in");
		
		FEEDING = Robot.getFeed();
		FEEDING.feedStop();
		requires(FEEDING);
	}
	protected void initialize()
	{
		oi = new OI();
		
	}
	
	protected void inStart()
	{
		FEEDING.feedIn();
	}
	protected boolean isFinished()
	{
		return true;
	}
	
	
}

