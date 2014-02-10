package edu.wpi.first.wpilibj.team2903.commands;

import edu.wpi.first.wpilibj.team2903.OI;

/**
 *
 * @author bradmiller
 */
public class TeleopController extends CommandBase {

    boolean stop;
    double multi;
    boolean cmode;

    public TeleopController() {
        // Use requires() here to declare subsystem dependencies
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        stop = false;
        multi = 0.25;
        cmode = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (!stop) {

            drive.drive(-OI.gameController.getRawAxis(3), OI.gameController.getRawAxis(2), -OI.gameController.getRawAxis(1) *1.2, multi);

            drive.leftStrafe(OI.gameController.getRawButton(5), multi);
            drive.rightStrafe(OI.gameController.getRawButton(6), multi);

            if (OI.gameController.getRawButton(2)) {
                multi = 0.25;
                //System.out.println(multi);
            } else if (OI.gameController.getRawButton(4)) {
                multi = 0.5;
                //System.out.println(multi);
            } else if (OI.gameController.getRawButton(3)) {
                multi = 0.75;
                //System.out.println(multi);
            } else if (OI.gameController.getRawButton(1)) {
                multi = 1;
                //System.out.println(multi);
            }
        }
        if (OI.gameController.getRawButton(9) && stop) {
            stop = false;
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        } else if (OI.gameController.getRawButton(9) && !stop) {
            stop = true;
            drive.drive(0, 0, 0, 0);
            multi = 0;
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }

        }

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
