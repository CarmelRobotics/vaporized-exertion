/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                   */
/* Open Source Software - may be modified and shared by FRC teams.            */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.subsystems.GrabberSystem;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;

/**
 *
 * @author Team 2035
 */
public class LowerGrabber extends Command {


    private final GrabberSystem grabber;
    public static OI oi;

    public LowerGrabber() {
    	super("LowerGrabber");
    	grabber = Robot.getGrabberSystem();
    	requires(grabber);
    }
    
    protected void initialize() {
    	oi = new OI();
    }
    
    protected void execute() {
    	grabber.lowerGrabber();
    }
    
    protected boolean isFinished() {
    	return false;
    }
    protected void end() {
    	grabber.grabberStop();
    }
    
    protected void interrupted() {
    	grabber.grabberStop();
    }

}