package org.usfirst.frc.team2035.robot.subsystems;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;


import org.usfirst.frc.team2035.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick; 

import edu.wpi.first.wpilibj.Victor;

/**
 *
 */
public class NewElevator extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private Joystick stick;
	private VictorSP speedControl;
	private DoubleSolenoid doubSol;
		

	public NewElevator()
	{
		super("Elevator");
		/*I am assuming two motors for the elevator. one for the front. One for the back.*/
	
		speedControl = new VictorSP(RobotMap.LIFT_MOTOR_PWM);
		
		
		//Declare PWMS
		doubSol = new DoubleSolenoid(0, 0, 0);
		
	}
	
	public void liftElevator() {
		speedControl.set(RobotMap.ELEVATOR_LIFT_UP);
		
	}
	
	public void lowerElevator() {
		speedControl.set(RobotMap.ELEVATOR_LIFT_DOWN);
		
	}
	
	
	public void gearSolenoidSetForward() {
		
		doubSol.set(DoubleSolenoid.Value.kForward);
	}

	public void gearSolenoidSetReverse() {
	doubSol.set(DoubleSolenoid.Value.kReverse);
	}
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	public void stopElevator() {
		// TODO Auto-generated method stub
		speedControl.set(RobotMap.ELEVATOR_LIFT_STOP);
		
	}

}