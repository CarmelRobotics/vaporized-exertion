package org.usfirst.frc.team2035.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc.team2035.robot.RobotMap;
<<<<<<< HEAD


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team2035.robot.commands.ExampleCommand;
import org.usfirst.frc.team2035.robot.commands.HangerSpin;
=======
import org.usfirst.frc.team2035.robot.commands.*;
>>>>>>> refs/heads/Abby

<<<<<<< HEAD
import org.usfirst.frc.team2035.robot.subsystems.*;
import org.usfirst.frc.team2035.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	
	public static final int OUR_MOTOR_PWM = 0;
	
	public static Button hangerSpin;
	private static Button shiftGear;
	private static Button shiftHighTest;
	private static Button shiftLowTest;
	public static Button ballIn;
	public static Button ballOut;
	private static Button armUp; 
	private static Button armDown;
	//private static Button armStop;
	
	//init the oi's
	
	
	public static void initialize() {
	
	
		hangerSpin = RobotMap.HANGERBUTTON_FORWARD;
		shiftGear = RobotMap.SHIFT_GEAR;
		ballIn = RobotMap.BALL_IN;
		ballOut = RobotMap.BALL_OUT;
		//spinStop  = RobotMap.SPIN_STOP;
		armUp = RobotMap.ARM_UP;
		armDown = RobotMap.ARM_DOWN;
		//armStop = RobotMap.ARM_STOP;
	
		hangerSpin.whileHeld(new HangerSpin());
		shiftGear.whileHeld(new ShiftLowGear());
		ballIn.whileHeld(new BallIntake());
		ballOut.whileHeld(new BallOutake());
		//spinStop.whenPressed(new SpinStop());
		
		armUp.whileHeld(new ArmUp());
		armDown.whileHeld(new ArmDown());
		//armStop.whenPressed(new ArmStop());
		
//	private static Button forwards;
//	private static Button backwards;
//	private static Button stop;
//	private static Button getDistance;
//	private static Button turretForward;
//	private static Button turretBackwards;
//	private static Button turretStop;
//	private static Button targetTurret;
//	private static Button getCount;
//	
//	public static void initialize() {
//		forwards = RobotMap.FORWARDS;
//		backwards = RobotMap.BACKWARDS;
//		stop = RobotMap.STOP;
//		getDistance = RobotMap.GET_DISTANCE;
//		turretForward = RobotMap.TALON_FORWARD;
//		turretBackwards = RobotMap.TALON_BACKWARDS;
//		turretStop = RobotMap.TALON_STOP;
//		targetTurret = RobotMap.TARGET_TURRET;
//		getCount = RobotMap.GET_COUNT;
//		
//		forwards.whileHeld(new MotorForward());
//		backwards.whileHeld(new MotorBackward());
//		stop.whileHeld(new MotorStop());
//		getDistance.whileHeld(new GetUltraValues());
//		turretForward.whileHeld(new MoveTurret());
//		turretBackwards.whileHeld(new MoveTurretNegative());
//		turretStop.whileHeld(new MoveTurretStop());
//		targetTurret.whenPressed(new TargetTurret());
//		getCount.whileHeld(new GetNetworkTableValue());
//		
//	
//		
		
	}
}
