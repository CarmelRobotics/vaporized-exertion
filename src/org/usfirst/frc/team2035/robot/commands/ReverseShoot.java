package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.command.Command;

public class ReverseShoot extends Command{ 

	public static OI oi;
	private final Shooter shooter;
	public ReverseShoot(){
		super("Reverse Shoot");
		shooter = Robot.getShooter();
		requires(shooter);
	}
	
	@Override
	protected void execute() {
		shooter.reverseShoot();
	}
	
	 
	@Override
	protected void end() {
		shooter.stopShoot();
	}

	

	@Override
	protected void initialize() {
		oi = new OI();
		
	}

	@Override
	protected void interrupted() {
		shooter.stopShoot();
		
	}
	protected boolean isFinished() {
		return false;
	}
	
}
