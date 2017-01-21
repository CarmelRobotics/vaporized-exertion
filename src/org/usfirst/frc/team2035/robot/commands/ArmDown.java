package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.BallSucker;
import edu.wpi.first.wpilibj.command.Command;

public class ArmDown extends Command{ 

	private final BallSucker bs;
	public static OI oi;
	public ArmDown(){
		super("Arm Go Down");
		
		
		bs = Robot.getBallSucker();
		requires(bs);
	}
	
	
	@Override
	protected void execute() {
		bs.armDown();
		
	}
	protected boolean isFinished()
	{
		return false;
	}
	
	@Override
	protected void end() {
		bs.spinStop();
		bs.armStop();
	}

	

	@Override
	protected void initialize() {
		oi = new OI();
		
	}

	@Override
	protected void interrupted() {
		bs.spinStop();
		bs.armStop();
		 
	}

	
}