/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                   */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.subsystems;

import org.usfirst.frc.team2035.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Hanger extends Subsystem {

	
	private  Victor hanger;
	
	
	public Hanger() {
		
		
		
		hanger = new Victor(RobotMap.HANGERMOTER_PWN);
		
	
		
	}
	
	
	
	//Spin the motor backwards
	public void spin() {
		
		
		hanger.set(RobotMap.HANGERMOTOR_FORWARD);
		
		
		
	}
	
	
	//Stop Motor
	public void stop () {
		
		hanger.set(RobotMap.HANGERMOTOR_STOP);
		
		
	}
	
	
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
}
