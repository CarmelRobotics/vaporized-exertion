package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2035.robot.RobotMap;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
public class BallSucker extends Subsystem{
	/**
	 * DISCLAIMER!!!!
	 * Comment all non-solenoid lines if motor and vice versa for armUp and armDown. The spin methods are good as is.
	 * Check in all the Arm classes.
	 * 
	 * ..unless it doesn't work. Then we're sorry. :(
	 * 
	 * From,
	 * Fang and Aleecia
	 */
	private Victor rod;
	private Victor arm;
	private DoubleSolenoid sol;
	
	public BallSucker() {
		super("Ball Sucker");
		rod = new Victor(RobotMap.BALLSUCKER_MOTOR_PWM);
		arm = new Victor(RobotMap.ARM_MOTOR_PWM);
		//sol = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.SOLENOID_ARM_UP, RobotMap.SOLENOID_ARM_DOWN);
	}
	
	public void spinIn() {
		rod.set(1.0);
	}
	
	public void spinOut() {
		rod.set(-1.0);
	}
	
	public void spinStop() {
		rod.set(0.0);
		arm.set(0.0);
	}
	
	public void armUp() {
		arm.set(1.0); // Use if motor controls arm up
		//sol.set(DoubleSolenoid.Value.kForward); // Use if solenoids controls arm up
	}
	
	public void armDown() {
		arm.set(-1.0); // Use if motor controls arm down
		//sol.set(DoubleSolenoid.Value.kReverse); // Use if solenoids controls arm down
	}
	
	public void solOff() {
		sol.set(DoubleSolenoid.Value.kOff);
		
	
	}
	
	
	
	public void initDefaultCommand() {
		
	}
	

}
