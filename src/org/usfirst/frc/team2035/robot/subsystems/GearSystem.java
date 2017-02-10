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

public class GearSystem extends Subsystem 
{
	private Solenoid pistonOut;
	private Victor teeterGearSystem; //TBD
	
	public GearSystem () 
	{
		super("Gear System");
		
		teeterGearSystem = new Victor(RobotMap.GEAR_SYSTEM_MOTOR_PWM);  // initialize the motor as a victor on channel 0
	    pistonOut = new Solenoid(RobotMap.GEAR_PCM);
	    
	}
	//NOTE: Eventually going to have to set specifics on how long to keep motor on. For now, just turning on and off. 
	public void lowerGear() {
	    teeterGearSystem.set(RobotMap.BALL_ROLLER_FORWARD);
	}

	public void gearStop() {
	    teeterGearSystem.set(0);
	}
	
	public void raiseGear() {
	    teeterGearSystem.set(RobotMap.BALL_ROLLER_REVERSE);
	}
	
	public void gentlyHold() {
	    pistonOut.set(true);
	}
	
	public void gentlyRelease() {
	    pistonOut.set(false);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
}
