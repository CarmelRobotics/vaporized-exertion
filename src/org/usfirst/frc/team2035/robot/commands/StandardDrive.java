/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.RobotDrive;
import org.usfirst.frc.team2035.robot.Robot;
import org.usfirst.frc.team2035.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2035.robot.OI;

/**
 * Command to drive the robot
 * @author Team 2035
 */
public class StandardDrive extends Command {

	private final Joystick JOYSTICK;
    private final RobotDrive DRIVE;
    private final DriveTrain THE_DRIVE_TRAIN;
    public static OI oi;
    
    /**
     * Creates a new StandardDrive command
     * @param d
     * @param j
     */
    public StandardDrive(RobotDrive d, Joystick j) {
        super("StandardDrive");
        THE_DRIVE_TRAIN = Robot.getDriveTrain();
        requires(THE_DRIVE_TRAIN);
        JOYSTICK = j;
        DRIVE = d;
    }
    
    /**
	 * Called just before this Command runs the first time
	 */
    protected void initialize() {
        //DriveTrain.getCommandLog().setCommand(this.getName());
    	oi = new OI();
    }

    /**
	 * Called repeatedly when this Command is scheduled to run
	 */
    protected void execute() {
        THE_DRIVE_TRAIN.arcadeDrive();
    }

    /**
	 * Make this false so it continues to drive
	 * @return false
	 */
    protected boolean isFinished() {
        return false;
    }

    /**
	 * Called once after isFinished returns true
	 */
    protected void end() {
        //DRIVE.stopMotor();
    }

    /**
	 * Called when another command which requires one or more of the same subsystems is scheduled to run
	 */
    protected void interrupted() {
    	
    }

}