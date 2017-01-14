package org.usfirst.frc.team2035.robot.subsystems;


import org.usfirst.frc.team2035.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;




public class OurMotor extends Subsystem {
	
	private Victor motor;
	
	public OurMotor() {
		
		
		
	}
	
	
	
	public void moveForward() {
		
		
		motor.set(RobotMap.OUR_MOTOR_FOWARD);
		
		
	}
	
	
	
	public void moveBackwards() {
		
		
		motor.set(RobotMap.OUR_MOTOR_BACKWARD);
		
		
		
	}
	
	
	public void stopMotor() {
		
		motor.set(RobotMap.OUR_MOTOR_STOP);
		
		
		
	}



	@Override
	protected void initDefaultCommand() {

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
