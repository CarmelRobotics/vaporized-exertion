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
	
	//Channel Values
	public static final int PWM1 = 0;
	public static final int ULTRASONIC_ANALOG = 1;
	
	//Joystick Buttons
	public static final int JOYSTICK_NUM = 0;
	public static final Joystick JOYSTICK = new Joystick(JOYSTICK_NUM);
	public static final JoystickButton STOP = new JoystickButton(JOYSTICK, 4);
	public static final JoystickButton FORWARDS = new JoystickButton(JOYSTICK, 2);
	public static final JoystickButton BACKWARDS = new JoystickButton(JOYSTICK, 3);
	public static final JoystickButton GET_DISTANCE = new JoystickButton(JOYSTICK, 1);
	
	
	
}
