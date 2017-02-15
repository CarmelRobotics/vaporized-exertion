package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.usfirst.frc.team2035.robot.RobotMap;

/**
 *
 */
public class Shooter extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private CANTalon turret;
	private NetworkTable table;
	private double p;
	private double i;
	private double d;
	
	
	
	public Shooter() {
		super("Shooter");
		table = NetworkTable.getTable("pi2RIO");
		turret = new CANTalon(RobotMap.TURRET_ID);
		turret.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		turret.changeControlMode(TalonControlMode.Position);
		p = 0.4;
		i = 0.0;
		d = 0.0;
		turret.setP(p);
		//turret.setI(i);
		//turret.setD(d);
		
	}
	
	public void targetTurret() {
		turret.set(calculateSetPoint());
		//turret.setSetpoint(calculateSetPoint());
		
		System.out.println(calculateSetPoint());
		
	}
	
	public double receiveAngle() {
		double default_num = 0.0;
		double angle = table.getNumber("angle", default_num);
		return angle;
	}
	
	public void receiveCount() {
		String count = table.getString("number", "howdy");
		System.out.println(count);
	}
	
	public void moveMotor() {
		turret.set(0.5);
	}
	
	public void stopMotor() {
		turret.set(0);
	}
	
	public void moveMotorNegative() {
		turret.set(-0.5);
	}
	 
	public double calculateSetPoint() {
		//turn degrees into fraction of rotation
		double angle = 45; //custom, eventually set to receiveAngle()
		double point = angle/360;;
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
