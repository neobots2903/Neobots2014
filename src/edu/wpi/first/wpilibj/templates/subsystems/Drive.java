
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 */
public class Drive extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Jaguar leftFrontMotor = new Jaguar(RobotMap.leftFrontMotor);
    public Jaguar rightFrontMotor = new Jaguar(RobotMap.rightFrontMotor);
    public Jaguar leftBackMotor = new Jaguar(RobotMap.leftBackMotor);
    public Jaguar rightBackMotor = new Jaguar(RobotMap.rightBackMotor);

    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void drive(double Ch1, double Ch3, double Ch4){
        rightFrontMotor.set(Ch3 + Ch1 + Ch4);
        leftBackMotor.set(Ch3 + Ch1 - Ch4);
        rightFrontMotor.set(Ch3 - Ch1 - Ch4);
        rightBackMotor.set(Ch3 - Ch1 + Ch4);
    }
}

