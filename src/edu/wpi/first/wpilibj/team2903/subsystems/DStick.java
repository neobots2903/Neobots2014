
package edu.wpi.first.wpilibj.team2903.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.team2903.RobotMap;

/**
 *
 */
public class DStick extends Subsystem {
    public Jaguar dstickVertical = new Jaguar(RobotMap.dstickVertical);
    public Jaguar dstickHorizontal = new Jaguar(RobotMap.dstickHorizontal);
    public Jaguar dstickLeftTrack = new Jaguar(RobotMap.dstickLeftTrack);
    public Jaguar dstickRightTrack = new Jaguar(RobotMap.dstickRightTrack);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void dstick() {
        
    }
}