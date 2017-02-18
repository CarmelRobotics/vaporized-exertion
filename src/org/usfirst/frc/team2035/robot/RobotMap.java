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

	
	/*
	 * Motor PWMs
	 */
    public static final int F_LEFT_MOTOR_PWM = 2; // Front Left drive motor is wired to PWM out [2]/0
    public static final int B_LEFT_MOTOR_PWM = 3; // Rear Left drive motor is wired to PWM out [3]/1
    public static final int F_RIGHT_MOTOR_PWM = 0; // Front Right drive motor is wired to PWM out [0]/2
    public static final int B_RIGHT_MOTOR_PWM = 1; // Rear Right drive motor is wired to PWM out [1]/3 
    public static final int HANGERMOTER_PWN = 4;
    public static final int FLYWHEEL = 5;
    public static final int LIFT_MOTOR_PWM = 6;
    public static final int BALLSUCKER_MOTOR_PWM = 7;
	public static final int SHOOTER_INTAKE = 8;
	
	/*
	 * Talon IDs
	 */
	public static final int TURRET_ID = 0;
	public static final int EYELID_ID = 1;
    
    /*
     * Joysticks
     */
    public static final int JOYSTICK_A_USB_NUMBER = 0;
    public static final Joystick DRIVER_JOYSTICK_A = new Joystick(JOYSTICK_A_USB_NUMBER);
    public static final int JOYSTICK_B_USB_NUMBER = 1;
    public static final Joystick DRIVER_JOYSTICK_B = new Joystick(JOYSTICK_B_USB_NUMBER);
    /* Joystick buttons */
    public static final JoystickButton SHIFT_GEAR = new JoystickButton(DRIVER_JOYSTICK_A, 1);
    //public static final JoystickButton GEAR_OUT = new JoystickButton(DRIVER_JOYSTICK_B, 6);
    //public static final JoystickButton PISTON_PUSH = new JoystickButton(DRIVER_JOYSTICK_A, 4);
    //public static final JoystickButton SHIFT_LOW_TEST = new JoystickButton(DRIVER_JOYSTICK_A, 8);
	//public static final JoystickButton SHIFT_HIGH_TEST = new JoystickButton(DRIVER_JOYSTICK_A, 9);
	public static final JoystickButton HANGERBUTTON_FORWARD = new JoystickButton(DRIVER_JOYSTICK_A,10);
	public static final JoystickButton BALL_OUT = new JoystickButton(DRIVER_JOYSTICK_A,2);
	public static final JoystickButton BALL_IN = new JoystickButton(DRIVER_JOYSTICK_A,3);
	//public static final JoystickButton STOP = new JoystickButton(DRIVER_JOYSTICK_A,6);
    public static final JoystickButton ARM_UP = new JoystickButton(DRIVER_JOYSTICK_A, 6);
    public static final JoystickButton ARM_DOWN = new JoystickButton(DRIVER_JOYSTICK_A, 7);
    
	/* MOTOR SPEEDS */
	public static final double ELEVATOR_LIFT_UP = 1;
	public static final double ELEVATOR_LIFT_DOWN = -1;
	public static final double ELEVATOR_LIFT_STOP = 0;
	public static final double HANGERMOTOR_FORWARD = -1.0;
	public static final double HANGERMOTOR_STOP = 0.0;
    
	/* 
	 * Solenoids
	 */
	public static final int PCM_ID_DRIVER = 0;
	public static final int PCM_ID_GEAR = 1;
	public static final int PCM_ID = 0; 
	public static final int SOLENOID_ARM_UP = 6;
    public static final int SOLENOID_ARM_DOWN = 7;
	
	public static final int DRIVE_TRAIN_SHIFT_RIGHT = 0; //Drive Train High Gear Solenoid set to Relay cartridge 1
	public static final int DRIVE_TRAIN_SHIFT_LEFT = 1; //Drive Train Low Gear Solenoid set to Relay cartridge 1
	
	/*
	 * MISC
	 */
	public static final int ULTRASONIC_ANALOG = 1;
	public static final int TURRET_RATIO = 15; //15 motor turns for 180 degrees
	public static final int ENCODER_STEPS = 4096; //Steps per rotation of shaft
	public static final int STEPS_90_DEG = (int)(7.5*4096);
}


	//public static final JoystickButton STOP = new JoystickButton(JOYSTICK, 4);
	//public static final JoystickButton FORWARDS = new JoystickButton(JOYSTICK, 2);
	//public static final JoystickButton BACKWARDS = new JoystickButton(JOYSTICK, 3);
	//public static final JoystickButton GET_DISTANCE = new JoystickButton(JOYSTICK, 1);
	
	//public static final JoystickButton TALON_FORWARD = new JoystickButton(JOYSTICK, 6);
	//public static final JoystickButton TALON_BACKWARDS = new JoystickButton(JOYSTICK, 7);
	//public static final JoystickButton TALON_STOP = new JoystickButton(JOYSTICK, 8);
	//public static final JoystickButton TARGET_TURRET = new JoystickButton(JOYSTICK, 9);
	//public static final JoystickButton GET_COUNT = new JoystickButton(JOYSTICK, 10);
