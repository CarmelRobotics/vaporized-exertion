package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.BallSucker;
import edu.wpi.first.wpilibj.command.Command;

public class ArmUp extends Command{ 
	
	//private BallSucker ballSucker = new BallSucker();
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
	protected boolean isFinished()
	{
		return false;
	}
	
	@Override
	protected void end() {
		// TODO Auto-generated method stub
		bs.spinStop();
	}

	

	@Override
	protected void initialize() {
		oi = new OI();
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		bs.spinStop();
		
	}

	
}