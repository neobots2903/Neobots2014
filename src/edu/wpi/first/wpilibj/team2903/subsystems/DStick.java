
package edu.wpi.first.wpilibj.team2903.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.team2903.RobotMap;

/**
 *
 */
public class DStick extends Subsystem {
    public Servo dStickVert = new Servo(RobotMap.dStickVert);
    public Servo dStickHoriz = new Servo(RobotMap.dStickHoriz);
    public Servo dStickLeftExt = new Servo(RobotMap.dStickLeftExt);
    public Servo dStickRightExt = new Servo(RobotMap.dStickRightExt);
    //TODO: low goal blockers
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean vertical(boolean deployed) {
        if (deployed == true) {
            dStickVert.setPosition(90);
        } else {
            dStickVert.setPosition(0);
        }
        return deployed;
    }
    
    public boolean horizontal(double position) {
        dStickHoriz.set(position);
        return true;
    }
    
    public boolean leftTrack(boolean deployed) {
        if (deployed == true) {
            dStickLeftExt.setPosition(90);
        } else {
            dStickLeftExt.setPosition(0);
        }
        return deployed;
    }
    
    public boolean rightTrack(boolean deployed) {
        if (deployed == true) {
            dStickRightExt.setPosition(90);
        } else {
            dStickRightExt.setPosition(0);
        }
        return deployed;
    }
}