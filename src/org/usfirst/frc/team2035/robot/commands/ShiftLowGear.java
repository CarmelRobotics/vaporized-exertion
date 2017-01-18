/*----------------------------------------------------------------------------*/
/* Copyright (c) 2016 FIRST Team 2035. All Rights Reserved.                   */
/* Open Source Software - may be modified and shared by FRC teams.            */
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
public class ShiftLowGear extends Command {


    private final DriveTrain train;
    public static OI oi; 

    public ShiftLowGear() {
    	super("StandardDrive");
    	train = Robot.getDriveTrain();
    	requires(train);
    	System.out.println("construct");
    }
    
    protected void initialize() {
    	System.out.println("Init");
    	oi = new OI();
    	train.shiftLowGear();

    }
    
    protected void execute() {
    	System.out.println("exe");
    	train.shiftLowGear();
    }
    
    protected boolean isFinished() {
    	return false;
    }
    protected void end() {
    	System.out.println("end");
    	train.shiftHighGear();
    	
    }
    
    protected void interrupted() {
    	System.out.println("interrupted");
    	train.shiftHighGear();
    }

}