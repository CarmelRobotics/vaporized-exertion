package org.usfirst.frc.team2035.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	//CHANNELS
	public static final int FLYWHEEL = 5; //????
	public static final int SHOOTER_INTAKE = 8;
	public static final int TURRET_ID = 0;
	public static final int EYELID_ID = 1;
	public static final int ULTRASONIC_ANALOG = 1;
	
	//Joystick Buttons
	public static final int JOYSTICK_NUM = 0;
	public static final Joystick JOYSTICK = new Joystick(JOYSTICK_NUM);
	public static final JoystickButton STOP = new JoystickButton(JOYSTICK, 4);
	public static final JoystickButton FORWARDS = new JoystickButton(JOYSTICK, 2);
	public static final JoystickButton BACKWARDS = new JoystickButton(JOYSTICK, 3);
	public static final JoystickButton GET_DISTANCE = new JoystickButton(JOYSTICK, 1);
	
	public static final JoystickButton TALON_FORWARD = new JoystickButton(JOYSTICK, 6);
	public static final JoystickButton TALON_BACKWARDS = new JoystickButton(JOYSTICK, 7);
	public static final JoystickButton TALON_STOP = new JoystickButton(JOYSTICK, 8);
	public static final JoystickButton TARGET_TURRET = new JoystickButton(JOYSTICK, 9);
	public static final JoystickButton GET_COUNT = new JoystickButton(JOYSTICK, 10);
	
	
	
	public static final int TURRET_RATIO = 15; //15 motor turns for 180 degrees
	public static final int ENCODER_STEPS = 4096; //Steps per rotation of shaft
	public static final int STEPS_90_DEG = (int)(7.5*4096);
	
	
	
	
}
