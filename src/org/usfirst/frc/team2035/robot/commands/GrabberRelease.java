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
public class GrabberRelease extends Command {


    private final GrabberSystem grabber;
    public static OI oi;

    public GrabberRelease() {
    	super("GrabberRelease");
    	grabber = Robot.getGrabberSystem();
    	requires(grabber);
    }
    
    protected void initialize() {
    	oi = new OI();
    }
    
    protected void execute() {
    	grabber.grabberRelease();
    }
    
    protected boolean isFinished() {
    	return true;
    }
    protected void end() {
    	grabber.grabberRelease();
    }
    
    protected void interrupted() {
    	grabber.grabberRelease();
    }

}