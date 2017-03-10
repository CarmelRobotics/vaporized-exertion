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
 * Subsystem for the robot's elevator mechanism (ball intake to the hopper)
 * @author Team 2035
 */
public class Elevator extends Subsystem {
	
	private Joystick stick;
	private VictorSP speedControl;
		
	/**
	 * Creates a new Elevator subsystem<br>
	 * Initializes one wpilib VictorSP
	 */
	public Elevator()
	{
		super("Elevator");
		speedControl = new VictorSP(RobotMap.LIFT_MOTOR_PWM);
	}
	
	/**
	 * Moves the elevator in the up direction (towards the hopper)
	 */
	public void liftElevator() {
		speedControl.set(RobotMap.ELEVATOR_LIFT_UP);	
	}
	
	/**
	 * Moves the elevator in the reverse direction (away from the hopper)
	 */
	public void lowerElevator() {
		speedControl.set(RobotMap.ELEVATOR_LIFT_DOWN);
	}
	
	/**
	 * Stops the elevator motor
	 */
	public void stopElevator() {
		// TODO Auto-generated method stub
		speedControl.set(RobotMap.ELEVATOR_LIFT_STOP);
	}	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub	
	}
	
	

}