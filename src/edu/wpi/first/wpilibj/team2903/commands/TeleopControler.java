
package edu.wpi.first.wpilibj.team2903.commands;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.team2903.OI;

/**
 *
 * @author bradmiller
 */
public class TeleopControler extends CommandBase {

    public TeleopControler() {
        // Use requires() here to declare subsystem dependencies
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drive.drive(OI.gameController.getRawAxis(1), OI.gameController.getRawAxis(2), OI.gameController.getRawAxis(1));
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
