package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2035.robot.RobotMap;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
public class BallSucker extends Subsystem{
	/**
	 * DISCLAIMER!!!!
	 * The arm movement commands are now using solenoids, change back to motors by commenting/uncommenting respective lines. The spin methods are good as is.
	 * Check in all the Arm classes.
	 * 
	 * ..unless it doesn't work. Then we're sorry. :(
	 * 
	 * From,
	 * Fang and Aleecia
	 */
	private Victor rod; // motor for turning ballsucker rod 
	private Victor arm; // motor for moving ballsucker up and down 
	private DoubleSolenoid sol; // solenoid use for ballsucker up and down
	
	public BallSucker() { 
		super("Ball Sucker");
		rod = new Victor(RobotMap.BALLSUCKER_MOTOR_PWM);
		//arm = new Victor(RobotMap.ARM_MOTOR_PWM);
		sol = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.SOLENOID_ARM_UP, RobotMap.SOLENOID_ARM_DOWN);
	}
	/**
	 * Method to move ballsucker rod in 
	 * @return void
	 */
	public void spinIn() {
		rod.set(1.0);
		System.out.println("spinning in");
	}
	/**
	 * Method to move ballsucker rod out 
	 * @return void
	 */
	public void spinOut() {
		rod.set(-1.0);
		System.out.println("spinning out");
	}
	/**
	 * Method to stop ballsucker rod 
	 * @return void
	 */
	public void spinStop() {
		rod.set(0.0);
		System.out.println("spinning stopping");
	}
	/**
	 * Method to move ballsucker arm up
	 * @return void
	 */
	public void armUp() {
		//arm.set(1.0); // Use if motor controls arm up
		sol.set(DoubleSolenoid.Value.kForward); // Use if solenoids controls arm up
		System.out.println("arm going up");
	}
	/**
	 * Method to move ballsucker arm down 
	 * @return void
	 */
	public void armDown() {
		//arm.set(-1.0); // Use if motor controls arm down
		sol.set(DoubleSolenoid.Value.kReverse); // Use if solenoids controls arm down
		System.out.println("arm going down");
	}
	/**
	 * Method to stop ballsucker arm
	 * @return void
	 */
	public void armStop() {
		//arm.set(0.0); // Use if motor controls arm stopping
		sol.set(DoubleSolenoid.Value.kOff);
		System.out.println("arm stopping");
	}
	
	
	
	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	public void initDefaultCommand() {
		
	}
	

}
