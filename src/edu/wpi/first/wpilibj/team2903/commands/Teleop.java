package edu.wpi.first.wpilibj.team2903.commands;

import edu.wpi.first.wpilibj.team2903.OI;

/**
 *
 * @author bradmiller
 */
public class Teleop extends CommandBase {

    public Teleop() {
        // Use requires() here to declare subsystem dependencies
        requires(drive);
        requires(Defend);
        requires(Ball);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drive.drive(OI.rightDriveStick.getX(), OI.leftDriveStick.getY(), OI.leftDriveStick.getX(), OI.rightDriveStick.getZ());

        Defend.horizontal(OI.defendiJoystick.getX());
        Defend.vertical(OI.defendiJoystick.getY());

        if (OI.ToggleLeftDefendiTrack.get()) {
            Defend.leftTrack(true);
        }
        if (OI.ToggleRightDefendiTrack.get()) {
            Defend.rightTrack(true);
        }
        if (OI.ToggleLeftLowBlocker.get()) {
            Defend.lowGoalLeft(true);
        }
        if (OI.ToggleRightLowBlocker.get()) {
            Defend.rightTrack(true);
        }

        if (OI.FireShooter.get()) {
            Ball.Shoot();
        }

        if (OI.OpenCatcher.get()) {
            Ball.hold(false);
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
