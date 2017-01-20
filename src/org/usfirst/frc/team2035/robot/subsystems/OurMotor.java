package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import org.usfirst.frc.team2035.robot.OI;


public class OurMotor{
private Victor first;


public OurMotor()
{
	//first = new Victor(OI.firstPWM);
}
 
public void movingForward()
{
	first.set(1.0);
}

public void movingBackward()
{
	first.set(-1.0);
}

public void stop()
{
	first.set(0.0);
}

}



