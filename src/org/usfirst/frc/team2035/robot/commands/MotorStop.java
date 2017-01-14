package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.subsystems.OurMotor;
import edu.wpi.first.wpilibj.command.Command;

public class MotorStop extends Command{
	 
	private OurMotor motor = new OurMotor();
	
	//public void motorStop()
	//{
	//	motor.stop();
	//}
	@Override
	protected void execute() {
		motor.stop();
	}
	protected boolean isFinished()
	{
		return false;
	}
}