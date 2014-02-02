package edu.wpi.first.wpilibj.team2903;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    
    //module 1
    public static final int Module1 = 1;
    public static final int leftFrontMotor1 = 2;
    //public static final int leftFrontMotor2 = 2;
    public static final int rightFrontMotor1 = 3;
    //public static final int rightFrontMotor2 = 4;
    public static final int leftBackMotor1 = 1;
    //public static final int leftBackMotor2 = 6;
    public static final int rightBackMotor1 = 4;
    //public static final int rightBackMotor2 = 8;
    
    //module 2
    public static final int Module2 = 2;
    public static final int dStickVert = 1;
    public static final int dStickHoriz = 2;
    public static final int dStickLeftExt = 3;
    public static final int dStickRightExt = 4;
    public static final int launcher = 5;
    public static final int catcher = 6;
    public static final int lowGoalLeft = 7;
    public static final int lowGoalRight = 8;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
}
