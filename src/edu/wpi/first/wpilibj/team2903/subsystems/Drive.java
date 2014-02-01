
package edu.wpi.first.wpilibj.team2903.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.team2903.RobotMap;

/**
 *
 */
public class Drive extends Subsystem {
    public Jaguar leftFrontMotor1 = new Jaguar(RobotMap.leftFrontMotor1);
    public Jaguar leftFrontMotor2 = new Jaguar(RobotMap.leftFrontMotor2);
    public Jaguar rightFrontMotor1 = new Jaguar(RobotMap.rightFrontMotor1);
    public Jaguar rightFrontMotor2 = new Jaguar(RobotMap.rightFrontMotor2);
    public Jaguar leftBackMotor1 = new Jaguar(RobotMap.leftBackMotor1);
    public Jaguar leftBackMotor2 = new Jaguar(RobotMap.leftBackMotor2);
    public Jaguar rightBackMotor1 = new Jaguar(RobotMap.rightBackMotor1);
    public Jaguar rightBackMotor2 = new Jaguar(RobotMap.rightBackMotor2);

    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void leftFrontMotors(double speed){
        leftFrontMotor1.set(speed);//RIGHT FRONT MOTOR
        leftFrontMotor2.set(speed);
    }
    public void leftBackMotors(double speed){
        leftBackMotor1.set(speed);//LEFT BACK MOTOR
        leftBackMotor2.set(speed);
    }
    public void rightFrontMotors(double speed){
        rightFrontMotor1.set(speed);//RIGHT FRONT MOTOR
        rightFrontMotor2.set(speed);
    }
    public void rightBackMotors(double speed){
        rightBackMotor1.set(speed);//RIGHT BACK MOTOR
        rightBackMotor2.set(speed);
    }
    public void drive(double Ch1, double Ch3, double Ch4){
        leftFrontMotors(Ch3 + Ch1 + Ch4);//RIGHT FRONT MOTOR
        leftBackMotors(Ch3 + Ch1 - Ch4);//LEFT BACK MOTOR    
        rightFrontMotors(Ch3 - Ch1 - Ch4);//RIGHT FRONT MOTOR
        rightBackMotors(Ch3 - Ch1 + Ch4);//RIGHT BACK MOTOR
    }
}