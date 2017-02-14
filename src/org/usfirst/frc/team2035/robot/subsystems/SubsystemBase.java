/*----------------------------------------------------------------------------*/
/* Copyright (c) 2016 FIRST Team 2035. All Rights Reserved.                   */
/* Open Source Software - may be modified and shared by FRC teams.            */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class SubsystemBase extends Subsystem {
	
	//I am still here
	
	private String name;
	
	public SubsystemBase()
	{
		super();
		name = "";
	}
	
	public SubsystemBase(String n)
	{
		super();
		name = n;
	}
	
	public abstract void init();

	
	public abstract void end();


}