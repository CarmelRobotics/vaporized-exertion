package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2035.robot.RobotMap;
import edu.wpi.first.wpilibj.Victor;

public class BallSucker extends Subsystem{
	private Victor rod;
	private Victor arm;
	
	public BallSucker()
	{
		super("Ball Sucker");
		rod = new Victor(RobotMap.BALLSUCKER_MOTOR_PWM);
		arm = new Victor(RobotMap.ARM_MOTOR_PWM);
	}
	
	public void spinIn()
	{
		rod.set(1.0);
	}
	
	public void spinOut()
	{
		rod.set(-1.0);
	}
	
	public void spinStop()
	{
		rod.set(0.0);
		arm.set(0.0);
	}
	
	public void armUp()
	{
		arm.set(1.0);
	}
	
	public void armDown()
	{
		arm.set(-1.0);
	}
	
	
	
	public void initDefaultCommand() {
		
	}
	

}
