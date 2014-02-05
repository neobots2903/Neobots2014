package edu.wpi.first.wpilibj.team2903.subsystems;
//Z and locked button
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.team2903.RobotMap;
/**
 *
 * @author robot
 */
public class BallManager  extends Subsystem{
 
    public Victor launcherMotor = new Victor(RobotMap.launcher);
    //TODO: catcher motor
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

  public interface SpeedController{
  
  void set(double speed);
  
 
  
  }
    
    
    
    public void Shoot() throws InterruptedException{
        launcherMotor.setPosition(0);
        launcherMotor.setPosition(90);
        Thread.sleep(2000);
        launcherMotor.setPosition(0);
    }
}

