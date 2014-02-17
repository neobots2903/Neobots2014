package edu.wpi.first.wpilibj.team2903.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.team2903.RobotMap;

/**
 *
 */
public class Defend extends Subsystem {

    public Servo dStickVert = new Servo(RobotMap.dStickVert);
    public Servo dStickHoriz = new Servo(RobotMap.dStickHoriz);
    public Servo lowGoal = new Servo(RobotMap.lowGoal);
    boolean leftTrackDeployed = false;
    boolean rightTrackDeployed = false;
    boolean leftLowGoalBlockerDeployed = false;
    boolean rightLowGoalBlockerDeployed = false;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void vertical(double position) {
        dStickVert.set(position);
    }

    public void horizontal(double position) {
        dStickHoriz.set(position);
    }

    public boolean lowGoalLeft(boolean deployed) {
        if (deployed == true) {
            lowGoal.setPosition(180);
        } else {
            lowGoal.setPosition(0);
        }
        return deployed;
    }

    public boolean lowGoalRight(boolean deployed) {
        if (deployed == true) {
            lowGoal.setPosition(180);
        } else {
            lowGoal.setPosition(0);
        }
        return deployed;
    }
}
