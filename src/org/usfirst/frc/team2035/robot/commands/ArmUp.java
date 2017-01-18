package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.BallSucker;
import edu.wpi.first.wpilibj.command.Command;

public class ArmUp extends Command{ 
	
	
	public static OI oi;
	private final BallSucker bs;
	public ArmUp(){
		super("Arm Go Up");
		
		
		bs = Robot.getBallSucker();
		requires(bs);
	}
	@Override
	protected void execute() {
		bs.armUp();
	}
	
	@Override
	protected void end() {
		
		bs.spinStop();
		bs.solOff();
	}

	

	@Override
	protected void initialize() {
		oi = new OI();
		
		
	}

	@Override
	protected void interrupted() {
		
		bs.spinStop();
		
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	
}