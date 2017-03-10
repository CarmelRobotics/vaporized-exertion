/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                   */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;

//import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import org.usfirst.frc.team2035.robot.RobotMap;
import org.usfirst.frc.team2035.robot.commands.*;
//import org.usfirst.frc.team2035.robot.subsystems.*;

public class DriveTrain extends Subsystem {
	
	private static Joystick stick;
	private SpeedController motorFrontLeft;
	private SpeedController motorBackLeft;
	private SpeedController motorFrontRight;
	private SpeedController motorBackRight;
	//private Solenoid gearShiftRight;
	//private Solenoid gearShiftLeft;
	private DoubleSolenoid gearShifter;

	private RobotDrive drive;


public DriveTrain() {
	super("Drive Train");
	
	motorFrontLeft = new Victor(RobotMap.F_LEFT_MOTOR_PWM);  // initialize the motor as a victor on channel 0
    motorBackLeft = new Victor(RobotMap.B_LEFT_MOTOR_PWM);
    motorFrontRight = new Victor(RobotMap.F_RIGHT_MOTOR_PWM);
    motorBackRight = new Victor(RobotMap.B_RIGHT_MOTOR_PWM);
    stick = new Joystick(RobotMap.JOYSTICK_A_USB_NUMBER);	// initialize the joystick on USB 0
    drive = new RobotDrive(motorFrontLeft,motorBackLeft,motorFrontRight,motorBackRight);
    //gearShiftRight = new Solenoid(RobotMap.RIGHT_GEAR);
    //gearShiftLeft = new Solenoid(RobotMap.LEFT_GEAR);
    gearShifter = new DoubleSolenoid(RobotMap.PCM_ID_DRIVER, RobotMap.HIGH_GEAR, RobotMap.LOW_GEAR);
}
//
public void init()
{
	
}

protected void initDefaultCommand()
{
	super.setDefaultCommand(new StandardDrive(drive, stick));
	
}

public void arcadeDrive() {
    drive.arcadeDrive(stick.getY(), (stick.getX()));
}


public void drive(double speed) {
    drive.drive(speed, 0.0);
}


public void shiftLowGear()
{
	//gearShiftRight.set(true);
	//gearShiftLeft.set(true);
	System.out.println("Gotta Go LOW");
	gearShifter.set(DoubleSolenoid.Value.kReverse);
}

public void shiftHighGear()
{
	
	//gearShiftRight.set(false);
	//gearShiftLeft.set(false);
	System.out.println("Gotta Go HIGH");
	gearShifter.set(DoubleSolenoid.Value.kForward);
}


public void end()
{
	
}
}