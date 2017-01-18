package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team2035.robot.subsystems.SubsystemBase;
import org.usfirst.frc.team2035.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick; 

import edu.wpi.first.wpilibj.Victor;

/**
 *
 */
public class NewElevator extends SubsystemBase {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private Joystick stick;
	private Victor speedControl;
	private Victor speedControl2;

	public NewElevator()
	{
		super("Elevator");
		/*I am assuming two motors for the elevator. one for the front. One for the back.*/
		stick = RobotMap.DRIVER_JOYSTICK_B;
		speedControl = new Victor(RobotMap.LIFT_MOTOR_LEFT_PWM);
		speedControl2 = new Victor(RobotMap.LIFT_MOTOR_RIGHT_PWM);
		
		
	}
	
	public void init()
	{
		
	}
	
	public void liftElevator() {
		speedControl.set(RobotMap.ELEVATOR_LIFT_UP);
		speedControl2.set(RobotMap.ELEVATOR_LIFT_UP);
	
	}
	
	public void lowerElevator() {
		speedControl.set(RobotMap.ELEVATOR_LIFT_DOWN);
		speedControl2.set(RobotMap.ELEVATOR_LIFT_DOWN);
	
	}

	

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	public void stopElevator() {
		// TODO Auto-generated method stub
		speedControl.set(RobotMap.ELEVATOR_LIFT_STOP);
		speedControl2.set(RobotMap.ELEVATOR_LIFT_STOP);
	}

}