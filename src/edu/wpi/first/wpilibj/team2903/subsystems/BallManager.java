package edu.wpi.first.wpilibj.team2903.subsystems;
//Z and locked button
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.team2903.RobotMap;
/**
 *
 * @author robot
 */
public class BallManager  extends Subsystem{
 
    public Jaguar launcherMotor = new Jaguar(RobotMap.launcher);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void Shoot(double zAxis){
        //Set the speed equal to the Z axis Variable on the RightStick
    }
    
    public void maxShoot(){ 
        //Set the Shooting Motor to max in reverse
    }


}
    

