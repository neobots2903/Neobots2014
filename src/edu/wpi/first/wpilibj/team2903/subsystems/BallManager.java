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

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean capture(boolean capture){
        if(capture){
            captureMotor.setPosition(720);//TODO: Get correct position
        }else{
            captureMotor.setPosition(0);
        }
        return capture;
    }

    public void Shoot() throws InterruptedException {
        launcherMotor.setPosition(0);
        launcherMotor.setPosition(90);
        Thread.sleep(2000);
        launcherMotor.setPosition(0);
    }
}
