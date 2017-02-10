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
	public static final int MOTOR = 0;
	public static final int STICK = 1;
	public static final int BUTTON_1 = 1;
	public static final int BUTTON_2 = 2;
	public static final Joystick DRIVER_JOYSTICK = new Joystick(STICK);
	public static final JoystickButton MOVE_MOTOR_BACKWARD = new JoystickButton(DRIVER_JOYSTICK, BUTTON_1); 
	public static final JoystickButton MOVE_MOTOR_FORWARD = new JoystickButton(DRIVER_JOYSTICK, BUTTON_2);
	/*
	 * Motor PWMs
	 */
    public static final int F_LEFT_MOTOR_PWM = 2; // Front Left drive motor is wired to PWM out [2]/0
    public static final int B_LEFT_MOTOR_PWM = 3; // Rear Left drive motor is wired to PWM out [3]/1
    public static final int F_RIGHT_MOTOR_PWM = 0; // Front Right drive motor is wired to PWM out [0]/2
    public static final int B_RIGHT_MOTOR_PWM = 1; // Rear Right drive motor is wired to PWM out [1]/3 
    public static final int GEAR_SYSTEM_MOTOR_PWM = 8; //8 is TBD
    /*
     * Joysticks
     */
    public static final int JOYSTICK_A_USB_NUMBER = 0;
    public static final Joystick DRIVER_JOYSTICK_A = new Joystick(JOYSTICK_A_USB_NUMBER);
    public static final int JOYSTICK_B_USB_NUMBER = 1;
    public static final Joystick DRIVER_JOYSTICK_B = new Joystick(JOYSTICK_B_USB_NUMBER);
  //Joystick buttons
    public static final JoystickButton SHIFT_GEAR = new JoystickButton(DRIVER_JOYSTICK_A, 1);
    //public static final JoystickButton GEAR_OUT = new JoystickButton(DRIVER_JOYSTICK_B, 6);
    //public static final JoystickButton PISTON_PUSH = new JoystickButton(DRIVER_JOYSTICK_A, 4);
    public static final JoystickButton SHIFT_LOW_TEST = new JoystickButton(DRIVER_JOYSTICK_A, 8);
	public static final JoystickButton SHIFT_HIGH_TEST = new JoystickButton(DRIVER_JOYSTICK_A, 9);
	public static final JoystickButton GEAR_LOW = new JoystickButton(DRIVER_JOYSTICK_A, 3);
	public static final JoystickButton GEAR_RAISE = new JoystickButton(DRIVER_JOYSTICK_A, 4);
	public static final JoystickButton GEAR_HOLD = new JoystickButton(DRIVER_JOYSTICK_A, 5);
    
	/*
	 * Solenoids
	 */
	public static final int PCM_ID_DRIVER = 0;
	public static final int PCM_ID_GEAR = 1;
	public static final int GEAR_PCM = 6; //TBD
	
	public static final int DRIVE_TRAIN_SHIFT_RIGHT = 0; //Drive Train High Gear Solenoid set to Relay cartridge 1
	public static final int DRIVE_TRAIN_SHIFT_LEFT = 1; //Drive Train Low Gear Solenoid set to Relay cartridge 1

	public static final double BALL_ROLLER_FORWARD = -1.0;
	public static final double BALL_ROLLER_REVERSE = 1.0;
}


