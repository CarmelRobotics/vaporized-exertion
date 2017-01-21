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
		FeederBottom = new Victor(1);
		//I created two new speed controller objects to attach to two motors.
		//One of these speed controllers might be superfluous depending on the number of motors on the feeder.
	}
	public void init()
	{
		
	}
	
	public void feedIn()
	{
		FeederTop.setSpeed(1);
		FeederBottom.setSpeed(-1);
		//This should set one of the motors forward and the other backward.
		//This should make the balls suck into the feeder.
	}
	public void feedOut()
	{
		FeederTop.setSpeed(-1);
		FeederBottom.setSpeed(1);
		//This should make the entire feeder spit out.
	}
	
	public void feedStop()
	{
		FeederTop.setSpeed(0);
		FeederBottom.setSpeed(0);
		//This should set both of the speed controllers to no speed.
	}
	/*public double getFeedTop()
	{
		return FeederTop.getSpeed();
	}
	public double getFeedBottom()
	{
		return FeederBottom.getSpeed();
	}*/
	@Override
	public void initDefaultCommand()
	{
		
	}
}
