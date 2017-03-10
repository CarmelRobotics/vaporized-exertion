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
 *
 * @author Team 2035
 */
public class ShiftHighGear extends Command {


    private final DriveTrain train;
    public static OI oi;

    public ShiftHighGear() {
    	super("StandardDrive");
    	train = Robot.getDriveTrain();
    	requires(train);
    	//System.out.println("HighButtonPressed");
    }
    /**
	 * Called just before this Command runs the first time
	 */
    protected void initialize() {
       	//System.out.println("HighButtonPressed");
        train.shiftHighGear();
    	oi = new OI();
    }
    
    protected void execute() {
       	//System.out.println("HighButtonPressed");
    	train.shiftHighGear();
    }
    
    protected boolean isFinished() {
    	return true;
    }
    protected void end() {
    	
    }
    
    protected void interrupted() {
    	
    }

}