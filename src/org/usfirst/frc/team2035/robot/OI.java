package org.usfirst.frc.team2035.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc.team2035.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team2035.robot.commands.ExampleCommand;
import org.usfirst.frc.team2035.robot.commands.HangerSpin;

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
	 
	
	public static Button hangerSpin;
	private static Button shiftGear;
	public static Button ballIn;
	public static Button ballOut;
	private static Button toggleArm;
	private static Button toggleVision;
	private static Button shoot;
	private static Button reverseShoot;
	private static Button turretLeft;
	private static Button turretRight;

	public static void initialize() {
	
		hangerSpin = RobotMap.HANGERBUTTON_FORWARD;
		shiftGear = RobotMap.SHIFT_GEAR;
		ballIn = RobotMap.BALL_IN;
		ballOut = RobotMap.BALL_OUT;
		toggleArm = RobotMap.TOGGLE_ARM;
		toggleVision = RobotMap.TOGGLE_VISION;
		shoot = RobotMap.SHOOT;
		reverseShoot = RobotMap.REVERSE_SHOOT;
		turretLeft = RobotMap.TURRET_LEFT;
		turretRight = RobotMap.TURRET_RIGHT;
	
		hangerSpin.whileHeld(new HangerSpin());
		shiftGear.whileHeld(new ShiftLowGear());
		ballIn.whileHeld(new BallIntake());
		ballOut.whileHeld(new BallOutake());
		toggleArm.whenPressed(new ToggleArm());
		toggleVision.whenPressed(new ToggleVision());
		shoot.whileHeld(new Shoot());
		reverseShoot.whileHeld(new ReverseShoot());
		turretLeft.whileHeld(new TurretLeft());
		turretRight.whileHeld(new TurretRight());
		
	}
}
