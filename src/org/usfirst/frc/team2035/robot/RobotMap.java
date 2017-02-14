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
	
	// Motor PWMs
	public static final int LIFT_MOTOR_PWM = 6;
	
	//Joysticks
	public static final int JOYSTICK_A_USB_NUMBER = 0;
	public static final Joystick DRIVER_JOYSTICK_A = new Joystick(JOYSTICK_A_USB_NUMBER);
	//Joystick Buttons
	public static final JoystickButton LIFT = new JoystickButton(DRIVER_JOYSTICK_A,1);
	public static final JoystickButton LOWER = new JoystickButton(DRIVER_JOYSTICK_A,2);
	public static final JoystickButton STOP = new JoystickButton(DRIVER_JOYSTICK_A,3);
	//Speed
	public static final double ELEVATOR_LIFT_UP = -1;
	public static final double ELEVATOR_LIFT_DOWN = 1;
	public static final double ELEVATOR_LIFT_STOP = 0;
}
