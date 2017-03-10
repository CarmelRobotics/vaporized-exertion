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
 * Command to pull the gear piston in
 * @author Team 2035
 */
public class GearSolenoidIn extends Command {
	
    private final GearSystem gearSystem;
    public static OI oi; 

    /**
     * Creates a new GearSolenoidIn Command
     * Initializes the GearSystem subsystem
     * Requires GearSystem
     */
    public GearSolenoidIn() {
    	super("Gear System");
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
 	
 	/**
	 * Called repeatedly when this Command is scheduled to run
	 * Sets the gear solenoid to reverse
	 */
    protected void execute() {
    	gearSystem.gearSolenoidSetReverse();
    }
    
    /**
	 * Make this false
	 * @return false
	 */
    protected boolean isFinished() {
    	return false;
    }
    
    /**
	 * Called once after isFinished returns true
	 * Returns the solenoid to center
	 */
 	@Override
 	protected void end() {
 		gearSystem.GearSolenoidStop();
 	} 
    
 	/**
	 * Called when another command which requires one or more of the same subsystems is scheduled to run
	 * Returns the solenoid to center
	 */
 	@Override
 	protected void interrupted() {
 		gearSystem.GearSolenoidStop();
 	}
 }