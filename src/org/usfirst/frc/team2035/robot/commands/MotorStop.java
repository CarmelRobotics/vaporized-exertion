package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.OurMotor;
import org.usfirst.frc.team2035.robot.OI;

/**
 *
 */
public class MotorStop extends Command {
	
	private final OurMotor motor;
	public static OI oi;
	
	public MotorStop() {
		// Use requires() here to declare subsystem dependencies
		super("Motor Stop");
		motor = Robot.getMotor();
		requires(motor);
		
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		oi = new OI();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		motor.stop();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		motor.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}