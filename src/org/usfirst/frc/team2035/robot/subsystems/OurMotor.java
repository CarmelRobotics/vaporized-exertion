package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.VictorSP;
import org.usfirst.frc.team2035.robot.RobotMap;

/**
 *
 */
public class OurMotor extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private VictorSP speedController;
	
	public OurMotor() {
		super("Arm");
		
		speedController = new VictorSP(RobotMap.PWM1);
	}
	
	public void backwards() {
		speedController.set(-.5);
		System.out.println("BACKWARDS!!!");
	}
	
	public void forwards() {
		speedController.set(.5);
		System.out.println("FORWARDS!!!");
	}
	
	public void stop() {
		speedController.set(0);
		System.out.println("STOP!!!");
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
