package org.usfirst.frc.team2035.robot.subsystems;

import org.usfirst.frc.team2035.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Compressor;

public class ACompressor extends Subsystem{
	private static Compressor compress;

	public ACompressor() {
		super("Compressor");
		compress = new Compressor(RobotMap.PCM_ID);
		
		// TODO auto-generated method stub
	}
	
	public void start() {
		compress.start();
	}
	
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
