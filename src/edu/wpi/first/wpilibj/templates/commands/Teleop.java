
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;

/**
 *
 * @author bradmiller
 */
public class Teleop extends CommandBase {

    public Teleop() {
        // Use requires() here to declare subsystem dependencies
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drive.drive(OI.rightStick.getX(), OI.leftStick.getY(), OI.leftStick.getX());
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
