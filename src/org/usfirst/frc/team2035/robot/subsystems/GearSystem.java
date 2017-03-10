/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                   */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.team2035.robot.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;

// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
public class GearSystem extends Subsystem {


	private DoubleSolenoid doubSol;
		

	public GearSystem()
	{
		super("GearSystem");
		/*I am assuming two motors for the elevator. one for the front. One for the back.*/
	
 
		    
		
		//Declare PWMS
		doubSol = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.GEAR_IN, RobotMap.GEAR_OUT);
		
	}

	
	public void gearSolenoidSetForward() {
		
		doubSol.set(DoubleSolenoid.Value.kForward);
		System.out.println("Gear solenoid out");
	}

	public void gearSolenoidSetReverse() {
		doubSol.set(DoubleSolenoid.Value.kReverse);
		System.out.println("Gear solenoid in");
	}
	
	public void GearSolenoidStop(){
		
		doubSol.set(DoubleSolenoid.Value.kOff);
		System.out.println("Gear solenoid stopping");
	}
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}