/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2035.robot.subsystems.GearSystem;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;

/**
 *
 * @author Team 2035
 */
public class GearSolenoidOut extends Command {


    private final GearSystem gearSystem;
    public static OI oi; 

    public GearSolenoidOut() {
    	super("GearSystem");
    	gearSystem = Robot.getGearSystem();
    	requires(gearSystem);
    
    }
    
    /**
	 * Called just before this Command runs the first time
	 */
 	@Override
 	protected void initialize() {
 		oi = new OI();
 	}
    
    protected void execute() {
    
    	gearSystem.gearSolenoidSetForward();
    
    }
      
    protected boolean isFinished() {
    	return false;
    }
    
 // Called once after isFinished returns true
 	@Override
 	protected void end() {
 		gearSystem.GearSolenoidStop();
 	} 
     
 // Called when another command which requires one or more of the same
 	// subsystems is scheduled to run
 	@Override
 	protected void interrupted() {
 	}
 }