
package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.*;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class Auto1Red extends Command {
	
	private DriveTrain driver;
	private Shooter shooter;
	public static OI oi;
	private Timer autonomousTimer;
	
	public Auto1Red() {
		super("Autonomous 1 Red");
		driver = Robot.getDriveTrain();
		shooter = Robot.getShooter;
		
		requries(driver);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		oi = new OI();
		autonomousTimer = new Timer();
		
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		autonomousTimer.start();
		shooter.moveEyelid(45);
		shooter.switchToPID();
		shooter.turretMoveRight();
		
		
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

