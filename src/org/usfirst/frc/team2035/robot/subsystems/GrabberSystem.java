package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;

import org.usfirst.frc.team2035.robot.RobotMap;
import org.usfirst.frc.team2035.robot.commands.*;
import org.usfirst.frc.team2035.robot.subsystems.*;

public class GrabberSystem extends Subsystem 
{
	private Solenoid gearGrabber;
	private Victor verticalMotor; //TBD
	
	public GrabberSystem () 
	{
		super("Grabber System");
		
		verticalMotor = new Victor(RobotMap.GRABBER_SYSTEM_MOTOR_PWM);  // initialize the motor as a victor on channel 0
	    gearGrabber = new Solenoid(RobotMap.GRABBER_PCM);
	    
	}
	//NOTE: Eventually going to have to set specifics on how long to keep motor on. For now, just turning on and off. 
	public void lowerGrabber() {
	    verticalMotor.set(RobotMap.GRABBER_DOWN);
	}

	public void grabberStop() {
	    verticalMotor.set(0);
	}
	
	public void raiseGrabber() {
	    verticalMotor.set(RobotMap.GRABBER_UP);
	}
	
	public void grabberHold() {
	    gearGrabber.set(true);
	}
	
	public void grabberRelease() {
	    gearGrabber.set(false);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
}
