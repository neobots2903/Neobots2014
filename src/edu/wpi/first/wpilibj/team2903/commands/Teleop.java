package edu.wpi.first.wpilibj.team2903.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.team2903.OI;

/**
 *
 * @author bradmiller
 */
public class Teleop extends CommandBase {

    boolean stop;
    double multi;
    boolean cmode;
    boolean forward;

    public Teleop() {
        // Use requires() here to declare subsystem dependencies
        requires(drive);
        requires(Defend);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        stop = false;
        multi = 1;
        cmode = true;
        forward = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        if (forward) {
            drive.drive(-OI.gameController.getRawAxis(4), -OI.gameController.getRawAxis(2), OI.gameController.getRawAxis(1) * 1.2, multi);
        } else {
            drive.drive(OI.gameController.getRawAxis(4), OI.gameController.getRawAxis(2), -OI.gameController.getRawAxis(1) * 1.2, multi);
        }
     //   Defend.horizontal(OI.defendiJoystick.getX());
      //  Defend.vertical(OI.defendiJoystick.getY());

//        drive.leftStrafe(OI.gameController.getRawButton(5), multi);
//        drive.rightStrafe(OI.gameController.getRawButton(6), multi);

        if (OI.gameController.getRawButton(1)) {
            multi = 0.25;
        } else if (OI.gameController.getRawButton(3)) {
            multi = 0.5;
        } else if (OI.gameController.getRawButton(2)) {
            multi = 0.75;
        } else if (OI.gameController.getRawButton(4)) {
            multi = 1;
        
        //invert
        } else if (OI.gameController.getRawButton(0)) {//TODO: Find button for this
            forward = !forward;
        }

        if (OI.defendiJoystick.getRawButton(1)) {
//            Thread shoot = new Thread(new Runnable() {
//                public void run() {
            drive.drive(0, 0, 0, 0);
                    Ball.Shoot();
                    Timer.delay(.01);
//                }
//            });
//            shoot.start();
//            Timer.delay(1);
        }
        if (OI.defendiJoystick.getRawButton(4)) {
//            Thread shoot = new Thread(new Runnable() {
//                public void run() {
            drive.drive(0, 0, 0, 0);
                    Ball.SoftShoot();
                    Timer.delay(.01);
//                }
//            });
//            shoot.start();
//            Timer.delay(1);
        }

        //2nd controller for defence
        //Defend.horizontal(OI.defendiJoystick.getX());
        if (OI.defendiJoystick.getRawButton(6))
        {
        Defend.vertical(-1);
        }
        else if (OI.defendiJoystick.getRawButton(7))
        {
        Defend.vertical(1);
        }
        else
        {
        Defend.vertical(0);
        }
        
        if (OI.defendiJoystick.getRawButton(8))
        {
        Defend.horizontal(-1);
        }
        else if (OI.defendiJoystick.getRawButton(9))
        {
        Defend.horizontal(1);
        }
        else
        {
        Defend.horizontal(0);
        }
        Ball.capture(OI.defendiJoystick.getRawButton(3), OI.defendiJoystick.getRawButton(2));
        


//        if (OI.gameController.getRawButton(9) && stop) {
//            stop = false;
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException ex) {
//                System.out.println(ex);
//            }
//        } else if (OI.gameController.getRawButton(9) && !stop) {
//            stop = true;
//            drive.drive(0, 0, 0, 0);
//            multi = 0;
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException ex) {
//                System.out.println(ex);
//            }
//
//        }
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
