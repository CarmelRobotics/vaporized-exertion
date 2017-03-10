/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;
import org.usfirst.frc.team2035.robot.subsystems.*;
import org.usfirst.frc.team2035.robot.commands.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//Subsystems
	public static DriveTrain driver;
	public static Hanger hanger;
	public static Elevator nlift;
	public static BallSucker bs;
	public static ACompressor compressor;
	public static GearSystem gearSystem;
	public static MaxbotixUltrasonic ultraSonic;
	public static Shooter shooter;
	public static LEDConnection leds;
	
	public static DriverStation driverStation;
	public static OI oi;
	public static DriverStation.Alliance alliance;
	public static CameraServer server;
	public static GetUltraValues ultraValues = new GetUltraValues();

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		
		//Initialize Subsystems
		ultraSonic = new MaxbotixUltrasonic(RobotMap.ULTRASONIC_ANALOG);
		shooter = new Shooter();
		leds = new LEDConnection();
		compressor = new ACompressor();
		driver = new DriveTrain();
		hanger = new Hanger();
		nlift = new Elevator();
		bs = new BallSucker();
		gearSystem = new GearSystem();
		
		driverStation = DriverStation.getInstance();
		chooser.addDefault("Default Auto", new Auto1Red());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		
		server = CameraServer.getInstance();
		server.startAutomaticCapture();
		
		OI.initialize();
		alliance = driverStation.getAlliance();
		driver.shiftHighGear();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		shooter.goToZero();
	}

	/**
	 * This function is called repeatedly when the robot is in Disabled mode.
	 */
	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		//autonomousCommand = chooser.getSelected();
		
		 String autoSelected = SmartDashboard.getString("Auto Selector", "Default"); 
		 switch(autoSelected) { 
		 	case "Auto1Red": 
		 		autonomousCommand = new Auto1Red(); 
		 		break;
		 	case "Auto2Red": 
		 		autonomousCommand = new Auto1Red(); 
		 		break;
		 	case "Auto3Red": 
		 		autonomousCommand = new Auto1Red(); 
		 		break;
		 	case "Auto4Red": 
		 		autonomousCommand = new Auto1Red(); 
		 		break;
		 	case "Auto1Blue": 
		 		autonomousCommand = new Auto1Red(); 
		 		break;
		 	case "Auto2Blue": 
		 		autonomousCommand = new Auto1Red(); 
		 		break;
		 	case "Auto3Blue": 
		 		autonomousCommand = new Auto1Red(); 
		 		break;
		 	case "Auto4Blue": 
		 		autonomousCommand = new Auto1Red(); 
		 		break;

	 		default:
	 			autonomousCommand = new Auto1Red(); 
	 			break; 
		 }
		 
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called once when the robot enters Teleop mode
	 */
	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		compressor.start();
		shooter.switchToManual();
	}

	/**
	 * This function is called periodically during operator control
	 */
	 @Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		driver.arcadeDrive();
        //System.out.println("Encoder Position: " + shooter.getEncPosition());
		//System.out.println(shooter.getEncPosition());
		System.out.println("Right Limit: " + RobotMap.ROTATIONS_RIGHT);
		System.out.println("Left Limit: " + RobotMap.ROTATIONS_LEFT);
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	//Getter methods for each subsystem
	/**
	 * Gets the Ultrasonic subsystem
	 * @return ultrasonic subsystem
	 */
	public static MaxbotixUltrasonic getUltrasonic() {
		return ultraSonic;
	}
	/**
	 * Gets the DriveTrain subsystem
	 * @return DriveTrain subsystem
	 */
    public static DriveTrain getDriveTrain() {
    	return driver;
    }
    /**
	 * Gets the Hanger subsystem
	 * @return Hanger subsystem
	 */
    public static Hanger getHanger() {	
		return hanger;
	}
    /**
	 * Gets the Elevator subsystem
	 * @return Elevator subsystem
	 */
    public static Elevator getElevator()
	{
		return nlift;
	}
    /**
	 * Gets the BallSucker subsystem
	 * @return BallSucker subsystem
	 */
    public static BallSucker getBallSucker(){
		return bs;
	}
    /**
	 * Gets the Shooter subsystem
	 * @return Shooter subsystem
	 */
	public static Shooter getShooter() {
		return shooter;
	}
	/**
	 * Gets the LEDConnection subsystem
	 * @return LEDConnection subsystem
	 */
	public static LEDConnection getLEDConnection() {
		return leds;
	}
	/**
	 * Gets the GearSystem subsystem
	 * @return GearSystem subsystem
	 */
	public static GearSystem getGearSystem() {
		return gearSystem;
	}
}
