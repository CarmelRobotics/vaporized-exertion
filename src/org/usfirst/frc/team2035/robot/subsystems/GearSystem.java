import org.usfirst.frc.team2035.robot.subsystems.Override;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;

// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
public class GearSystem extends Subsystem {


	private DoubleSolenoid doubSol;
		

	public GearSystem()
	{
		super("GearSystem");
		/*I am assuming two motors for the elevator. one for the front. One for the back.*/
	

		   
		
		//Declare PWMS
		doubSol = new DoubleSolenoid(0, 0, 0);
		
	}

	
	public void gearSolenoidSetForward() {
		
		doubSol.set(DoubleSolenoid.Value.kForward);
		System.out.println("Gear solenoid out");
	}

	public void gearSolenoidSetReverse() {
		doubSol.set(DoubleSolenoid.Value.kReverse);
		System.out.println("Gear solenoid in");
	}
	
	public void GearSolenoidStop(){
		
		doubSol.set(DoubleSolenoid.Value.kOff);
		System.out.println("Gear solenoid stopping");
	}
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}