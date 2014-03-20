package edu.wpi.first.wpilibj.team2903.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.team2903.OI;

/**
 *
 * @author bradmiller
 */
public class Auto extends CommandBase {

    public Auto() {
        // Use requires() here to declare subsystem dependencies
        requires(drive);
        requires(Defend);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //drive.forward(500, 0.75);//time and speed it will go forward
        // if kinect is bad comment out from here to }
        
        Defend.vertical(-1);//brings up defendi stick

        //Goally Defend cod e
        if (OI.leftArm.getY() < 0.0 && OI.leftArm.getY() > -0.75) { //Left: 0 -- -0.75
            drive.tank(-0.5, -0.5);  
            //Defend.horizontal(1);
        }
        else if (OI.leftArm.getY() < 0.75 && OI.leftArm.getY() > 0) {//Left: 0.75 -- 0
            drive.tank(-1, -1);  
            //Defend.horizontal(1);
        }
      
        else if (OI.rightArm.getY() < 0.0 && OI.rightArm.getY() > -0.75){//Right: 0 -- -0.75
            drive.tank(0.5, 0.5);           
            //Defend.horizontal(-1);
        }
        else if (OI.rightArm.getY() < 0.75 && OI.rightArm.getY() >  0){//Right: 0.75 -- 0
            drive.tank(1, 1);           
            //Defend.horizontal(-1);
        }else{
            drive.tank(0, 0);           
            //Defend.horizontal(0);
        }
        
        //Defendi stick code
        if(OI.rightArm.getRawButton(3)){//right leg
            Defend.horizontal(1);
        }else if(OI.leftArm.getRawButton(4)){//left leg
            Defend.horizontal(-1);
        }else{
            Defend.horizontal(0);
        }
        
        
        //comment out to here if kinect is a nub
        //kkkkkkkkkkgeoff's code VVV
        //drive.tank(OI.rightArm.getY(), OI.leftArm.getY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
