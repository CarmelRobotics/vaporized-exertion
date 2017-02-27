 
package org.usfirst.frc.team2035.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2035.robot.subsystems.GearSystem;

import org.usfirst.frc.team2035.robot.OI;
import org.usfirst.frc.team2035.robot.Robot;

/**
 *
 * @author Team 2035
 */
public class GearSolenoidIn extends Command {


    private final GearSystem gearSystem;
    public static OI oi; 

    public GearSolenoidIn() {
    	super("GearSystem");
    	gearSystem = Robot.getGearSystem();
    	requires(gearSystem);
    
    }
 // Called just before this Command runs the first time
 	@Override
 	protected void initialize() {
 		oi = new OI();
 	}
    
    protected void execute() {
    
    	gearSystem.gearSolenoidSetReverse();
    
    }
      
    protected boolean isFinished() {
    	return false;
    }
    
 // Called once after isFinished returns true
 	@Override
 	protected void end() {
 		gearSystem.GearSolenoidStop();
 	} 
     
 // Called when another command which requires one or more of the same
 	// subsystems is scheduled to run
 	@Override
 	protected void interrupted() {
 	}
 }