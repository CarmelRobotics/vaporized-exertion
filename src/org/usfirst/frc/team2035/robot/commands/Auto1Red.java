
package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.*;
import org.usfirst.frc.team2035.robot.OI;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class Auto1Red extends Command {
	
	private DriveTrain driver;
	private Shooter shooter;
	public static OI oi;
	private Timer autoTimer;
	
	public Auto1Red() {
		super("Autonomous 1 Red");
		driver = Robot.getDriveTrain();
		shooter = Robot.getShooter();
		
		requires(driver);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		oi = new OI();
		autoTimer = new Timer();
		
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		autoTimer.start();
		//shooter.moveEyelid(45);
		//shooter.switchToPID();
		//shooter.turretMoveRight();
		//double currentTime = autoTimer.get();
		//while(autoTimer.get() <= (currentTime + 3)) {
		//	shooter.shoot();
		//}
		//shooter.stopShoot();
		double currentTime = autoTimer.get();
		while(autoTimer.get() <= (currentTime + 4)) {
			driver.drive(-.25);
		}
		//TODO: Add gear mechanism
		
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true;
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

