package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.usfirst.frc.team2035.robot.subsystems.MaxbotixUltrasonic;
import java.lang.Math;
import org.usfirst.frc.team2035.robot.Robot;

import org.usfirst.frc.team2035.robot.RobotMap;

/**
 * Shooter Subsystem including intake, turret, eyelid, and flywheel
 */
public class Shooter extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private CANTalon turret;
	private CANTalon eyelid;
	private Victor flyWheel;
	private Victor intake;
	private NetworkTable table;
	private double p;
	private double i;
	private double d;
	
	public static boolean targeted;
	public static boolean manual = true;
	
	public Shooter() {
		super("Shooter");
		targeted = false;
		flyWheel = new Victor(RobotMap.FLYWHEEL);
		intake = new Victor(RobotMap.SHOOTER_INTAKE);
		table = NetworkTable.getTable("pi2RIO");
		eyelid = new CANTalon(RobotMap.EYELID_ID);
		eyelid.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		eyelid.changeControlMode(TalonControlMode.Position);
		turret = new CANTalon(RobotMap.TURRET_ID);
		turret.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		turret.changeControlMode(TalonControlMode.Position);
		p = 2;
		i = 0.0;
		d = 0.0;
		turret.setPID(p, i, d);
		eyelid.setPID(p, i, d);
		
	}
	
	
	
	//INTAKE
	/**
	 * Shooter Intake In
	 */
	public void intakeIn() {
		intake.set(1.0);
	}
	/**
	 * Shooter Intake Out
	 */
	public void intakeOut() {
		intake.set(-1.0);
	}
	/**
	 * Shooter Intake Stop
	 */
	public void intakeStop() {
		intake.set(0);
	}
	
	//FLYWHEEL
	/**
	 * Activates the Flywheel
	 */
	public void spinFlywheelForwards() {
		flyWheel.set(1.0);
	}
	/**
	 * Spins flywheel backwards
	 */
	public void spinFlywheelBackwards() {
		flyWheel.set(-1.0);
	}
	/**
	 * Stops flywheel
	 */
	public void stopFlywheel() {
		flyWheel.set(0.0);
	}
	
	//EYELID
	/**
	 * Calculates the angle (degrees) of the eyelid given a certain distance (cm)
	 * @return Target angle for the eyelid (degrees)
	 */
	public double findEyelidAngle() {
		double g = .0988;
		double x = 0.0;
		double v = 0.0;
		double y = Robot.getUltrasonic().getRangeInCM();
		double beta = 0.0;
		//double angle = Math.arccos((g*x)/v)-beta;
		return 0.0;
	}
	
	/**
	 * Calculates number of rotations for eyelid Angle
	 */
	public double findEyelidRotations() {
		return 0.0;
	}
	/**
	 * Default method to move eyelid to a position based on ultrasonic distance given angle
	 */
	public void moveEyelid() {
		
	}
	/**
	 * Moves eyelid to a position based on user input angle
	 * @param angle (degrees)
	 */
	public void moveEyelid(double angle) {
		
	}
	
	//TURRET
	/**
	 * Switches to PercentVBus Control Mode
	 */
	public void switchToManual() {
		turret.changeControlMode(TalonControlMode.PercentVbus);
		manual = true;
	}
	/**
	 * Switches to Position Control Mode
	 */
	public void switchToPID() {
		turret.changeControlMode(TalonControlMode.Position);
		manual = false;
	}
	/**
	 * In manual mode: moves the turret to the right at half speed (stopping at 90 degrees)
	 * In PID mode: turns the turret to the right 90 degrees from 0
	 */
	public void turretMoveRight() {
		if(turret.getControlMode() == TalonControlMode.PercentVbus) {
			turret.set(.5);
			//Makes sure the motor stops at 90 degrees without a limit switch
			if((turret.getEncPosition()/4096) >= .24) {
				turret.set(0);
			}
		}
		else {
			turret.set(.24);
		}
	}
	/**
	 * In manual mode: moves the turret to the left at half speed (stopping at -90 degrees)
	 * In PID mode: turns the turret to the left -90 degrees from 0
	 */
	public void turretMoveLeft() {
		if(turret.getControlMode() == TalonControlMode.PercentVbus) {
			turret.set(-.5);
			//Makes sure the motor stops at -90 degrees without a limit switch
			if((turret.getEncPosition()/4096) <= -.24) {
				turret.set(0);
			}
		}
		else {
			turret.set(-.24);
		}
	}
	/**
	 * In manual mode: stops the turret motor
	 */
	public void manualTurretStop() {
		if(turret.getControlMode() == TalonControlMode.PercentVbus) {
			turret.set(0.0);
		}
	}
	/**
	 * In PID mode: If no angle is received from the Raspberry Pi, the turret turns to the right and then the left until and angle is found
	 * Then based on the angle, the setpoint is calculated and the motor turns to that position
	 */
	public void targetTurret() {
		while(Double.parseDouble(receiveAngle()) == 999) {
			double currentPos = (turret.getEncPosition()/4096);
			if(turret.getEncPosition() < (4096*.2)) {
				turret.set(currentPos+.05);
			}
			else {
				turret.set(currentPos-.05);
			}
		}
		turret.set(calculateSetPoint());
		System.out.println(calculateSetPoint());
	}
	/**
	 * Receives an angle from the Rasberry Pi on the "angle" thread of the NetworkTable
	 */
	public String receiveAngle() {
		String angle = table.getString("angle", "999");
		System.out.println(angle);
		return angle;
	}
	
	public void receiveCount() {
		String count = table.getString("number", "howdy");
		System.out.println(count);
	}
	/**
	* Calculates the correct encoder position (in rotations) by dividing the angle in degrees by 360 and adding the current position.
	* If the position exceeds 90 degrees in either direction, the setpoint will be set slightly before to avoid overtaxing the motor.
	* For ensured accuracy, the encoder is recalibrated at that position.
	*/
	public double calculateSetPoint() {
		//turn degrees into fraction of rotation
		double angle = Double.parseDouble(receiveAngle()); //custom, eventually set to receiveAngle()
		//double angle2gedi = Double.parseDouble(receiveAngle());
		double point = angle/360;
		double current = ((turret.getEncPosition())/4096); //current encoder position in rotations (not ticks)
		point = point + current; //adds the current position (in rotations) to "zero" the shooter
		
		//Does not allow the shooter to turn more than 90 degrees in either direction.
		//Check to keep motor from overturning and harming mechanics without a limit switch
		if(point > .24) {
			point = .24;
			turret.setEncPosition((int)(.24*4096));
			return point;
		}
		else if(point < -.24) {
			point = -.24;
			turret.setEncPosition((int)(-.24*4096));
			return point;
		}
		return point;
		
	}
	
	public int getEncPosition() {
		int encPos = turret.getEncPosition();
		if (encPos == 4096) {
			turret.setEncPosition(0);
		}
		return encPos;
	}
	public void setEncPosition(int encPos) {
		turret.setEncPosition(encPos);
	}
	
	//SHOOT
	public void shoot() {
		intakeIn();
		spinFlywheelForwards();
	}
	public void stopShoot() {
		intakeStop();
		stopFlywheel();
	}
	public void reverseShoot() {
		intakeOut();
		spinFlywheelBackwards();
	}
	

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
