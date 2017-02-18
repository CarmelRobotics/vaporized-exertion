package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

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
	
	//FLYWHEEL
	/**
	 * Activates the Flywheel
	 */
	public void spinFlywheel() {
		flyWheel.set(1.0);
	}
	
	//EYELID
	/**
	 * Calculates the angle (degrees) of the eyelid given a certain distance (cm)
	 * @return Target angle for the eyelid (degrees)
	 */
	public double findEyelidAngle() {
		//import equation
		return 0.0;
	}
	/**
	 * Calculates number of rotations for eyelid Angle
	 */
	public double findEyelidRotations() {
		return 0.0;
	}
	
	//TURRET
	/**
	 * Switches to PercentVBus Control Mode
	 */
	public void switchToManual() {
		turret.changeControlMode(TalonControlMode.PercentVbus);
	}
	/**
	 * Switches to Position Control Mode
	 */
	public void switchToPID() {
		turret.changeControlMode(TalonControlMode.Position);
	}
	
	public void manualTurretMoveRight() {
		if(turret.getControlMode() == TalonControlMode.PercentVbus) {
			turret.set(.5);
		}
	}
	
	public void manualTurretMoveLeft() {
		if(turret.getControlMode() == TalonControlMode.PercentVbus) {
			turret.set(-.5);
		}
	}
	
	public void manualTurretStop() {
		if(turret.getControlMode() == TalonControlMode.PercentVbus) {
			turret.set(0.0);
		}
	}
	
	public void targetTurret() {
		turret.set(calculateSetPoint());
		
		System.out.println(calculateSetPoint());
		
	}
	
	public String receiveAngle() {
		String angle = table.getString("angle", "me hoy minoy");
		System.out.println(angle);
		return angle;
	}
	
	public void receiveCount() {
		String count = table.getString("number", "howdy");
		System.out.println(count);
	}
	 
	public double calculateSetPoint() {
		//turn degrees into fraction of rotation
		double angle = Double.parseDouble(receiveAngle()); //custom, eventually set to receiveAngle()
		//double angle2 = Double.parseDouble(receiveAngle());
		double point = angle/360;
		if(point > .5) {
			point = .5;
			return point;
		}
		else if(point < -.5) {
			point = -.5;
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

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
