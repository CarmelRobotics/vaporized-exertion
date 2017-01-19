package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2035.robot.subsystems.*;
public class FeedMotorOut extends Command{

	private final FeederSystem FEEDING;
	public static OI oi;
	
	
	public FeedMotorOut()
	{
		super("Feed Motor Out");
		
		FEEDING = Robot.getFeed();
		requires(FEEDING);
	}
	protected void initialize()
	{
		oi = new OI();
		
	}
	
	protected void outStart()
	{
		FEEDING.feedOut();
	}
	protected boolean isFinished()
	{
		return true;
	}
	
	
}
