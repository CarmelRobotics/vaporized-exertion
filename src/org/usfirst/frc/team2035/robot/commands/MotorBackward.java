package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.subsystems.OurMotor;
import edu.wpi.first.wpilibj.command.Command;

public class MotorBackward extends Command{
	
	private OurMotor motor = new OurMotor();
	
	//public void motorBackward()
	//{
	//	motor.movingBackward();
	//}
	@Override
	protected void execute() {
		motor.movingBackward();
	}
	protected boolean isFinished()
	{
		return false;
	}
}

