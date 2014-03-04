
package edu.wpi.first.wpilibj.team2903;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.KinectStick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    public static Joystick leftDriveStick = new Joystick(1);
    public static Joystick rightDriveStick = new Joystick(2);
    public static Joystick defendiJoystick = new Joystick(3);
    public static Joystick gameController = new Joystick(4);
    public static Joystick gameController2 = new Joystick(5);
    public static KinectStick leftArm = new KinectStick(1);
    public static KinectStick rightArm = new KinectStick(2);
    // Button button = new JoystickButton(stick, buttonNumber);
    public static Button MaxShooter = new JoystickButton(rightDriveStick,2);
    public static Button FireShooter = new JoystickButton(rightDriveStick,1);
    public static Button OpenCatcher = new JoystickButton(rightDriveStick,3);
    public static Button ToggleLeftDefendiTrack = new JoystickButton(defendiJoystick,4);
    public static Button ToggleRightDefendiTrack = new JoystickButton(defendiJoystick,5);
    public static Button ToggleLeftLowBlocker = new JoystickButton(defendiJoystick,6);
    public static Button ToggleRightLowBlocker = new JoystickButton(defendiJoystick,11);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

