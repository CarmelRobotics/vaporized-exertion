package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.OurMotor;

import edu.wpi.first.wpilibj.command.Command;

public class MotorStop extends Command{

	private final OurMotor motor;
	
	public static OI oi;
	
	
	
	public MotorStop() {
	//	Super("")
		motor = Robot.getOurMotor();
		//requires(motor);
		
		
	}
	
	
	@Override
	protected void initialize() {
		oi = new OI();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		motor.stopMotor();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		
	}
	
	
	
	
	
}