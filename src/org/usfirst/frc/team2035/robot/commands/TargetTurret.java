package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Shooter;
import org.usfirst.frc.team2035.robot.OI;

/**
 *
 */
public class TargetTurret extends Command {
	
	private final Shooter shooter;
	public static OI oi;
	
	public TargetTurret() {
		// Use requires() here to declare subsystem dependencies
		super("Turret");
		shooter = Robot.getShooter();
		requires(shooter);
		
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		oi = new OI();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		//shooter.targetTurret();
		System.out.println("Receiving Angle");
		shooter.receiveAngle();
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		shooter.manualTurretStop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}