package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.BallSucker;
import edu.wpi.first.wpilibj.command.Command;

public class SpinIn extends Command{ 

	public static OI oi;
	private final BallSucker bs;
	public SpinIn(){
		super("Spin In");
		
		
		bs = Robot.getBallSucker();
		requires(bs);
	}
	
	@Override
	protected void execute() {
		bs.spinIn();
	}
	
	
	@Override
	protected void end() {
		bs.spinStop();
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
