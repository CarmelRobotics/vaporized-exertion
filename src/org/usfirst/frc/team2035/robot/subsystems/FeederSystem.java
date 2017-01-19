package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;


import edu.wpi.first.wpilibj.command.Subsystem;

public class FeederSystem extends Subsystem {

	private Victor FeederTop;
	private Victor FeederBottom;
	
	public FeederSystem()
	{
		super("Feeder System");
		FeederTop = new Victor(0);
		FeederBottom = new Victor(0);
	}
	public void init()
	{
		
	}
	
	public void feedIn()
	{
		FeederTop.setSpeed(1);
		FeederBottom.setSpeed(-1);
	}
	public void feedOut()
	{
		FeederTop.setSpeed(-1);
		FeederBottom.setSpeed(1);
	}
	
	public void feedStop()
	{
		FeederTop.setSpeed(0);
		FeederBottom.setSpeed(0);
	}
	public double getFeedTop()
	{
		return FeederTop.getSpeed();
	}
	public double getFeedBottom()
	{
		return FeederBottom.getSpeed();
	}
	@Override
	public void initDefaultCommand()
	{
		
	}
}
