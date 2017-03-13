/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

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
    public static final Joystick JOYSTICK1 = new Joystick(JOYSTICK_A_USB_NUMBER);
    
    /* Joystick buttons */
    public static final JoystickButton SHIFT_GEAR = new JoystickButton(JOYSTICK1, 1);
	public static final JoystickButton BALL_OUT = new JoystickButton(JOYSTICK1,2);
	public static final JoystickButton BALL_IN = new JoystickButton(JOYSTICK1,3);
	public static final JoystickButton TURRET_LEFT = new JoystickButton(JOYSTICK1, 4);
	public static final JoystickButton TURRET_RIGHT = new JoystickButton(JOYSTICK1, 5);
	public static final JoystickButton SHOOT = new JoystickButton(JOYSTICK1,6);
	public static final JoystickButton REVERSE_SHOOT = new JoystickButton(JOYSTICK1, 7);
    public static final JoystickButton TOGGLE_ARM = new JoystickButton(JOYSTICK1, 8);
    public static final JoystickButton TOGGLE_VISION = new JoystickButton(JOYSTICK1, 9);
    public static final JoystickButton HANGERBUTTON_FORWARD = new JoystickButton(JOYSTICK1,10);
    public static final JoystickButton TARGET_TURRET = new JoystickButton(JOYSTICK1, 11);
    
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
	public static final int HIGH_GEAR = 2;
	public static final int LOW_GEAR = 3;
	public static final int GEAR_IN = 4;
	public static final int GEAR_OUT = 5;
	public static final int PCM_ID = 0; 
	public static final int SOLENOID_ARM_UP = 0;
    public static final int SOLENOID_ARM_DOWN = 1;
	
	
	/*
	 * MISC
	 */
	public static final int ULTRASONIC_ANALOG = 1;
	public static final int TURRET_RATIO = 15; //15 motor turns for 180 degrees
	public static final int ENCODER_STEPS = 4096; //Steps per rotation of shaft
	public static final int STEPS_90_DEG = (int)(7.5*4096);
	
	/*
	 * AUTONOMOUS
	 */
	public static final int TURNING_RADIUS = 15; //inches
	public static final int WHEEL_BASE = 24; //inches
	public static final double HIGH_VELOCITY = 15; //feet per second
	
	/*
	 * CONVERSION FACTORS
	 */
	public static final double ONE_EIGHTY = 104; //104 gear grooves in 180 degrees
	public static final double DEGREES_PER_GROOVE = 180/104; //degrees per each gear tick
	public static final double DEGREES_RIGHT = 54*DEGREES_PER_GROOVE;
	public static final double DEGREES_LEFT = 61*DEGREES_PER_GROOVE;
	public static final double DEGREES_PER_ROTATION = DEGREES_PER_GROOVE*15; //degrees per rotation of the motor
	public static final double ROTATIONS_RIGHT = 35/15;
	public static final double ROTATIONS_LEFT = -(35/15);
	
	public static final double LOWEST_DEGREE = 0;
	public static final double HIGHEST_DEGREE = 0;
	public static final double DEGREES_PER_EYELID_GROOVE = 1;
	//public static final double ROTATIONS_RIGHT = (DEGREES_RIGHT/DEGREES_PER_ROTATION)-.5;
	//public static final double ROTATIONS_LEFT = -(DEGREES_LEFT/DEGREES_PER_ROTATION)+.5;
		
}

