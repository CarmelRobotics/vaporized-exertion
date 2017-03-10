/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST Team 2035. All Rights Reserved.                   */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2035.robot.subsystems;

import edu.wpi.first.wpilibj.SensorBase; 

import edu.wpi.first.wpilibj.AnalogInput;


public class MaxbotixUltrasonic extends SensorBase {

    private final double IN_TO_CM = 2.54;
    private final double MV_PER_5MM = 4.88;
    private boolean useUnits;    //Are we using units or just returning voltage?
    private double minVoltage;	  //Minimum voltage the ultrasonic sensor can return
    private double voltageRange; //The range of the voltages returned by the sensor (maximum - minimum)
    private double minDistance;  //Minimum distance the ultrasonic sensor can return in inches
    private double distanceRange;//The range of the distances returned by this class in inches (maximum - minimum)
    AnalogInput channel;
    
    //constructor
    public MaxbotixUltrasonic(int _channel) {
        channel = new AnalogInput(_channel);
        //default values
		useUnits = true;
		minVoltage = 0.0;
		voltageRange = 5.0 - minVoltage;
		minDistance = 3.0;
		distanceRange = 60.0 - minDistance;
    }
    //constructor
    public MaxbotixUltrasonic(int _channel, boolean _use_units, double _min_voltage,
            double _max_voltage, double _min_distance, double _max_distance) {
        channel = new AnalogInput(_channel);
        //only use unit-specific variables if we're using units
        if (_use_units) {
            useUnits = true;
            minVoltage = _min_voltage;
            voltageRange = _max_voltage - _min_voltage;
            minDistance = _min_distance;
            distanceRange = _max_distance - _min_distance;
        }
    }
    /** Just get the voltage.
     *
     * @return The analog voltage output.
     */
    public double getVoltage() {
        return channel.getVoltage();
    }
    
    /** GetRangeInInches
     * @return the range in inches
     * @return -1.0 if units are not being used
     * @return -2.0 if the voltage is below the minimum voltage
     */
    public double getRangeInInches() {
    	double range;
        //if we're not using units, return -1, a range that will most likely never be returned
        if (!useUnits) {
            return -1.0;
        }
        range = channel.getVoltage();
        if (range < minVoltage) {
            return -2.0;
        }
        double milliVolts = (channel.getVoltage())*1000;
        double inches = (5*milliVolts)/(MV_PER_5MM*10*IN_TO_CM);
        
        return inches;
    	
//        double range;
//        //if we're not using units, return -1, a range that will most likely never be returned
//        if (!useUnits) {
//            return -1.0;
//        }
//        range = channel.getVoltage();
//        if (range < minVoltage) {
//            return -2.0;
//        }
//        //first, normalize the voltage
//        range = (range - minVoltage) / voltageRange;
//        //next, denormalize to the unit range
//        range = (range * distanceRange) + minDistance;
//        return range + 29;
    }
    /* GetRangeInCM
     * Returns the range in centimeters
     * Returns -1.0 if units are not being used
     * Returns -2.0 if the voltage is below the minimum voltage
     */

    public double getRangeInCM() {
        double range;
        //if we're not using units, return -1, a range that will most likely never be returned
        if (!useUnits) {
            return -1.0;
        }
        range = channel.getVoltage();
        if (range < minVoltage) {
            return -2.0;
        }
        double milliVolts = (channel.getVoltage())*1000;
        double cm = (5*milliVolts)/(MV_PER_5MM*10);
        
        return cm;
        
        
        
        //first, normalize the voltage
        //range = (range - minVoltage) / voltageRange;
        //next, denormalize to the unit range
        //range = (range * distanceRange) + minDistance;
        //finally, convert to centimeters
        //range *= IN_TO_CM;
        //return range;
    }
}