package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2035.robot.subsystems.*;
public class FeedMotorStop extends Command{

	private final FeederSystem FEEDING;
	public static OI oi;
	
	
	public FeedMotorStop()
	{
		super("Feed Motor Stop");
		
		FEEDING = Robot.getFeed();

		requires(FEEDING);
	}
	protected void initialize()
	{
		oi = new OI();
		
	}
	
	protected void stop()
	{
		FEEDING.feedStop();
	}
	protected boolean isFinished()
	{
		return true;
	}
	
	
}