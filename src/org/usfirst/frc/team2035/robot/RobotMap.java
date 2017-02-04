package org.usfirst.frc.team2035.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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
	
	
	
	//Joystick Buttons
	public static final int JOYSTICK_A_USB_NUMBER = 0;
	
	public static final Joystick DRIVER_JOYSTICK_A = new Joystick(JOYSTICK_A_USB_NUMBER);
	
	public static final JoystickButton HANGERBUTTON_FORWARD = new JoystickButton(DRIVER_JOYSTICK_A,1);

	//Motors
	
	public static final double HANGERMOTOR_FORWARD = -1.0;
	public static final double HANGERMOTOR_STOP = 0.0;
	
	public static final int HANGERMOTER_PWN = 0;
	
	
	
}
