package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.subsystems.OurMotor;
import edu.wpi.first.wpilibj.command.Command;

public class MotorForward extends Command{ 
	
	private OurMotor motor = new OurMotor();
	
	//public void motorForward()
	//{
	//	motor.movingForward();
	//}
	@Override
	protected void execute() {
		motor.movingForward();
	}
	protected boolean isFinished()
	{
		return false;
	}
}
