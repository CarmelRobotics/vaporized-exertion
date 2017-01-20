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
	
	
	
	
	public void spin() {
		
		
		hanger.set(RobotMap.HANGERMOTOR_FORWARD);
		
		
		
	}
	
	
	
	public void stop () {
		
		hanger.set(RobotMap.HANGERMOTOR_STOP);
		
		
	}
	
	
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
}
