package org.usfirst.frc.team2035.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
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

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();

	public static MaxbotixUltrasonic ultraSonic;
	public static Shooter shooter;
	public static LEDConnection leds;
	public static DriverStation driverStation;
	public static OI oi;

	public static DriveTrain driver;
	public static Hanger hanger;
	public static NewElevator nlift;
	public static BallSucker bs;
	public static ACompressor compressor;
	public static GearSystem gearSystem;
	
	public static DriverStation.Alliance alliance;
	public static CameraServer server;
	public static GetUltraValues ultraValues = new GetUltraValues();
	public static File file = new File("src/org/usfirst/frc/team2035/robot/ultrasonic_data.txt");

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		ultraSonic = new MaxbotixUltrasonic(RobotMap.ULTRASONIC_ANALOG);
		shooter = new Shooter();
		leds = new LEDConnection();
		driverStation = DriverStation.getInstance();
		chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		compressor = new ACompressor();
		driver = new DriveTrain();
		hanger = new Hanger();
		nlift = new NewElevator();
		bs = new BallSucker();
		gearSystem = new GearSystem();
		driver.shiftHighGear();
		server = CameraServer.getInstance();
		//server.setQuality(50);
		server.startAutomaticCapture();
		OI.initialize();
		alliance = driverStation.getAlliance();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		shooter.manualTurretStop();
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

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		compressor.start();

	}

	/**
	 * This function is called periodically during operator control
	 */
	 @Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		driver.arcadeDrive();
		
        //System.out.println("Encoder Position: " + shooter.getEncPosition());
    
        if (alliance == DriverStation.Alliance.Red) {
        	System.out.println("RED");
            leds.red();
        } else if (alliance == DriverStation.Alliance.Blue) {
            leds.blue();
            System.out.println("BLUE");
        } else {
            leds.rainbow();
            System.out.println("NO");
        }

	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	public static MaxbotixUltrasonic getUltrasonic() {
		return ultraSonic;
	}
    public static DriveTrain getDriveTrain() {
    	return driver;
    }
    public static Hanger getHanger() {	
		return hanger;
	}
    public static NewElevator getNewElevator()
	{
		return nlift;
		
	}
    public static BallSucker getBallSucker(){
		return bs;
	}
	
	public static Shooter getShooter() {
		return shooter;
	}
	public static LEDConnection getLEDConnection() {
		return leds;
	}
	public static GearSystem getGearSystem() {
		return gearSystem;
	}
}
