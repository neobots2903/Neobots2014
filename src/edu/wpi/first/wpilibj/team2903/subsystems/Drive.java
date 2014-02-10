package edu.wpi.first.wpilibj.team2903.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.team2903.RobotMap;

/**
 *
 */
public class Drive extends Subsystem {

    public Jaguar leftFrontMotor1 = new Jaguar(RobotMap.leftFrontMotor1);
    //public Jaguar leftFrontMotor2 = new Jaguar(RobotMap.leftFrontMotor2);
    public Jaguar rightFrontMotor1 = new Jaguar(RobotMap.rightFrontMotor1);
    //public Jaguar rightFrontMotor2 = new Jaguar(RobotMap.rightFrontMotor2);
    public Jaguar leftBackMotor1 = new Jaguar(RobotMap.leftBackMotor1);
    //public Jaguar leftBackMotor2 = new Jaguar(RobotMap.leftBackMotor2);
    public Jaguar rightBackMotor1 = new Jaguar(RobotMap.rightBackMotor1);
    //public Jaguar rightBackMotor2 = new Jaguar(RobotMap.rightBackMotor2);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void leftFrontMotors(double speed,double multi) {
        leftFrontMotor1.set(speed * multi);//RIGHT FRONT MOTOR
        //leftFrontMotor2.set(speed);
    }

    public void leftBackMotors(double speed,double multi) {
        leftBackMotor1.set(speed * multi);//LEFT BACK MOTOR
        //leftBackMotor2.set(speed);
    }

    public void rightFrontMotors(double speed,double multi) {
        rightFrontMotor1.set(-speed * multi);//RIGHT FRONT MOTOR
        //rightFrontMotor2.set(speed);
    }

    public void rightBackMotors(double speed,double multi) {
        rightBackMotor1.set(-speed * multi);//RIGHT BACK MOTOR
        //rightBackMotor2.set(speed);
    }
    
    /*
     The drive team requested that the left stick controlled the speed of
     the left motors and the Right stick controls the speed of the 
     right motors.  
    
     This code below looks to use the left stick Y value to control
     the speed of all the motors and the right stick Y value is not
     taken into account.  
     */
    public void drive(double RightStick_X, double Stick_Y, double LeftStick_X, double multi) {
        leftFrontMotors(Stick_Y + RightStick_X + LeftStick_X, multi);//RIGHT FRONT MOTOR
        leftBackMotors(Stick_Y + RightStick_X - LeftStick_X, multi);//LEFT BACK MOTOR    
        rightFrontMotors(Stick_Y - RightStick_X - LeftStick_X, multi);//RIGHT FRONT MOTOR
        rightBackMotors(Stick_Y - RightStick_X + LeftStick_X, multi);//RIGHT BACK MOTOR
    }

    public void forward(int time, double speed) {
        leftFrontMotors(speed, 1);//RIGHT FRONT MOTOR
        leftBackMotors(speed, 1);//LEFT BACK MOTOR    
        rightFrontMotors(speed, 1);//RIGHT FRONT MOTOR
        rightBackMotors(speed, 1);//RIGHT BACK MOTOR
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    public void rightStrafe(boolean strafe, double multi){
        if(strafe){
        drive(0, 0, -1, multi);
        }
    }
    public void leftStrafe(boolean strafe, double multi){
        if(strafe){
        drive(0, 0, 1, multi);
        }
    }
}
