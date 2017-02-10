/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                   */
/* Open Source Software - may be modified and shared by FRC teams.            */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team2035.robot.commands;

import org.usfirst.frc.team2035.robot.subsystems.GearSystem;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;

/**
 *
 * @author Team 2035
 */
public class LowerGear extends Command {


    private final GearSystem gear;
    public static OI oi;

    public LowerGear() {
    	super("LowerGear");
    	gear = Robot.getGearSystem();
    	requires(gear);
    }
    
    protected void initialize() {
    	oi = new OI();
    }
    
    protected void execute() {
    	gear.lowerGear();
    }
    
    protected boolean isFinished() {
    	return true;
    }
    protected void end() {
    	gear.gearStop();
    }
    
    protected void interrupted() {
    	gear.gearStop();
    }

}