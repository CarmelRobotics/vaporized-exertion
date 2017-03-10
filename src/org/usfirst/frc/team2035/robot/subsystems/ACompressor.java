/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                   */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.subsystems;

import org.usfirst.frc.team2035.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;

/**
 * Subsystem for the onboard compressor
 * @author Team 2035
 */
public class ACompressor extends Subsystem{
	
	private static Compressor compress;

	/**
	 * Creates a new Compressor Subsystem<br>
	 * Initializes wpilib Compressor<br>
	 */
	public ACompressor() {
		super("Compressor");
		compress = new Compressor(RobotMap.PCM_ID);
		// TODO auto-generated method stub
	}
	
	/**
	 * Starts the compressor
	 */
	public void start() {
		compress.start();
	}
	
	/**
	 * Checks the pressure switch value and turns off the compressor when it reaches that value
	 */
	public void checkPressure()
	{
		if(!compress.getPressureSwitchValue())
        {
        	if(compress.enabled())
        	{
        		compress.stop();
        	}
        }
	}


	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
}
