/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                   */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * Connects to a Raspberry Pi using NetworkTables to request a certain pattern
 */
public class LEDConnection extends Subsystem {
	// Put methods for controlling this subsystem
	private NetworkTable table;
	
	
	public LEDConnection() {
		table = NetworkTable.getTable("pi2RIO");
		table.putNumber("LED", 0);
	}
	
	public void rainbow() {
		table.putNumber("LED", 0);
	}
	
	public void red() {
		table.putNumber("LED", 1);
	}
	
	public void blue() {
		table.putNumber("LED", 2);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
