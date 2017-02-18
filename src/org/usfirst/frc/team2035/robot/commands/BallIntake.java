package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.BallSucker;
import org.usfirst.frc.team2035.robot.subsystems.NewElevator;
import edu.wpi.first.wpilibj.command.Command;

public class BallIntake extends Command{ 

	public static OI oi;
	private final BallSucker bs;
	private final NewElevator el;
	public BallIntake(){
		super("Spin In");
		
		
		bs = Robot.getBallSucker();
		el = Robot.getNewElevator();
		requires(bs);
	}
	
	@Override
	protected void execute() {
		bs.spinIn();
		el.liftElevator();
	}
	
	 
	@Override
	protected void end() {
		bs.spinStop();
		el.stopElevator();
	}

	

	@Override
	protected void initialize() {
		oi = new OI();
		
	}

	@Override
	protected void interrupted() {
		bs.spinStop();
		el.stopElevator();
		
	}
	protected boolean isFinished() {
		return false;
	}
	
}
