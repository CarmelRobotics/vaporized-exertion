/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                   */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.subsystems;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;


import org.usfirst.frc.team2035.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick; 

import edu.wpi.first.wpilibj.Victor;

/**
 *
 */
public class NewElevator extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private Joystick stick;
	private VictorSP speedControl;
		

	public NewElevator()
	{
		super("Elevator");
		/*I am assuming two motors for the elevator. one for the front. One for the back.*/
	
		speedControl = new VictorSP(RobotMap.LIFT_MOTOR_PWM);
	}
	
	public void liftElevator() {
		speedControl.set(RobotMap.ELEVATOR_LIFT_UP);
		
	}
	
	public void lowerElevator() {
		speedControl.set(RobotMap.ELEVATOR_LIFT_DOWN);
		
	}
	

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	public void stopElevator() {
		// TODO Auto-generated method stub
		speedControl.set(RobotMap.ELEVATOR_LIFT_STOP);
		
	}

}