/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                   */
/* Open Source Software - may be modified and shared by FRC teams.   		  */
/* created by Isidoro												  */
/*         																	  */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2035.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
/**
 *
 */
public class GearSystem extends Subsystem {
	private Solenoid sol;
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	
	public GearSystem()
	{
		super("Gear System");
		sol = new Solenoid(RobotMap.PCM_ID_GEAR);
		//sol = new Solenoid( RobotMap.SHOOTER1_PCM);
	}
	
	public void gearPistonOut(){
		
		sol.set(true);
	}
	public void gearPistonIn(){
		
		sol.set(false);
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
