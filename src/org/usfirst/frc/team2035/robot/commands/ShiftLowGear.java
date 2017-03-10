/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;

/**
 * Command to shift into low gear
 * @author Team 2035
 */
public class ShiftLowGear extends Command {

    private final DriveTrain train;
    public static OI oi; 

    /**
     * Creates a new ShiftLowGear command
     */
    public ShiftLowGear() {
    	super("StandardDrive");
    	train = Robot.getDriveTrain();
    	requires(train);
    	System.out.println("construct");
    }
    
    /**
	 * Called just before this Command runs the first time
	 */
    protected void initialize() {
    	System.out.println("Init");
    	oi = new OI();
    	train.shiftLowGear();
    }
    
    /**
	 * Called repeatedly when this Command is scheduled to run
	 */
    protected void execute() {
    	System.out.println("exe");
    	train.shiftLowGear();
    }
    
    /**
	 * Make this false (?) because it should continue to shift to high gear until button is released
	 * @return false
	 */
    protected boolean isFinished() {
    	return false;
    }
    
    /**
	 * Called once after isFinished returns true
	 */
    protected void end() {
    	System.out.println("end");
    	train.shiftHighGear();
    	
    }
    
    /**
	 * Called when another command which requires one or more of the same subsystems is scheduled to run
	 */
    protected void interrupted() {
    	System.out.println("interrupted");
    	train.shiftHighGear();
    }

}