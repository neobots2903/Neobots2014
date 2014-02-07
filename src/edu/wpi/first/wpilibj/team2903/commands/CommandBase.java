package edu.wpi.first.wpilibj.team2903.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.team2903.OI;
import edu.wpi.first.wpilibj.team2903.subsystems.BallManager;
import edu.wpi.first.wpilibj.team2903.subsystems.Defend;
import edu.wpi.first.wpilibj.team2903.subsystems.Drive;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    
    //SUBSYSTEMS
    public static Drive drive = new Drive();
    public static Defend Defend = new Defend();
    public static BallManager Ball = new BallManager();

    public static void init() {    
        //We need this
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        //SmartDashboard.putData(exampleSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
