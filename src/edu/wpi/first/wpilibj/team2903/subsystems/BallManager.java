package edu.wpi.first.wpilibj.team2903.subsystems;
//Z and locked button

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.team2903.RobotMap;

/**
 *
 * @author robot
 */
public class BallManager extends Subsystem {

    public Victor launcherMotor = new Victor(RobotMap.launcher);
    public Victor captureMotor = new Victor(RobotMap.catcher);
    private boolean captured = false;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public boolean capture() {
        if (captured) {
            captureMotor.setPosition(720);//TODO: Get correct position
            captured = false;
        } else {
            captureMotor.setPosition(0);
            captured = true;
        }
        return captured;
    }

    public void Shoot() {
        captureMotor.setPosition(720); //TODO: Get the correct position
        launcherMotor.setPosition(0);
        launcherMotor.setPosition(90);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        launcherMotor.setPosition(0);
        captureMotor.setPosition(0);
    }

    public void ResetShooter() {
        launcherMotor.setPosition(0);
    }
}
