/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                   */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.team2035.robot.RobotMap;

/**
 * Subsystem for the robot's driving mechanism
 * @author Team 2035
 */
public class DriveTrain extends Subsystem {
	
	private static Joystick stick;
	private SpeedController motorFrontLeft;
	private SpeedController motorBackLeft;
	private SpeedController motorFrontRight;
	private SpeedController motorBackRight;
	private DoubleSolenoid gearShifter;
	private RobotDrive drive;

	/**
	 * Creates an new DriveTrain subsystem<br>
	 * Initializes 4 wpilib Victors for motors, a Joystick, DoubleSolenoid, and RobotDrive object
	 */
	public DriveTrain() {
		super("Drive Train");
		motorFrontLeft = new Victor(RobotMap.F_LEFT_MOTOR_PWM);  // initialize the motor as a victor on channel 0
		motorBackLeft = new Victor(RobotMap.B_LEFT_MOTOR_PWM);
		motorFrontRight = new Victor(RobotMap.F_RIGHT_MOTOR_PWM);
		motorBackRight = new Victor(RobotMap.B_RIGHT_MOTOR_PWM);
		stick = new Joystick(RobotMap.JOYSTICK_A_USB_NUMBER);	// initialize the joystick on USB 0
		drive = new RobotDrive(motorFrontLeft,motorBackLeft,motorFrontRight,motorBackRight);
		gearShifter = new DoubleSolenoid(RobotMap.PCM_ID_DRIVER, RobotMap.HIGH_GEAR, RobotMap.LOW_GEAR);
	}


	protected void initDefaultCommand()
	{
		//super.setDefaultCommand(new StandardDrive(drive, stick));
	}

	/**
	 * Drives the robot with a joystick
	 */
	public void arcadeDrive() {
		drive.arcadeDrive(stick.getY(), (stick.getX()));
	}

	/**
	 * Drives the robot at a certain speed and curve
	 * @param speed
	 * @param curve
	 */
	public void drive(double speed, double curve) {
		drive.drive(speed, curve);
	}

	/**
	 * Shifts the drive train into low gear
	 */
	public void shiftLowGear() {
		System.out.println("Gotta Go LOW");
		gearShifter.set(DoubleSolenoid.Value.kReverse);
	}	
	
	/**
	 * Shifts the drive train into high gear
	 */
	public void shiftHighGear() {
		System.out.println("Gotta Go HIGH");
		gearShifter.set(DoubleSolenoid.Value.kForward);
	}
	
}