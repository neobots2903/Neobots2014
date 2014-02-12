package edu.wpi.first.wpilibj.team2903.subsystems;
//Z and locked button

import edu.wpi.first.wpilibj.Timer;
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
    public double intiPos;

    public void initDefaultCommand() {
        intiPos = launcherMotor.getPosition();
    }

    public boolean hold(boolean captured) {
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
//        hold(false);
        launcherMotor.set(1);
        Timer.delay(0.250);
//        launcherMotor.setPosition(intiPos+90);
//        Timer.delay(2000);
//        launcherMotor.set(0.25);
//        launcherMotor.setPosition(0);
//        hold(false);
        launcherMotor.set(0);
        Timer.delay(5);
    }

    public void ResetShooter() {
        launcherMotor.setPosition(0);
    }
}
