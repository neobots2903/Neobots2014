package edu.wpi.first.wpilibj.team2903.subsystems;
//Z and locked button

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.team2903.RobotMap;

/**
 *
 * @author robot
 */
public class BallManager extends Subsystem {

    public Victor launcherMotor = new Victor(RobotMap.launcher);
    public Victor captureMotor = new Victor(RobotMap.catcher);
    public Encoder launcherEncoder = new Encoder(1, 2, true, CounterBase.EncodingType.k2X);

    public void initDefaultCommand() {

    }

    public void capture(boolean open, boolean close) {
        if (open) {
            captureMotor.set(1);
            //set to .5 normally
        } else if(close){
            captureMotor.set(-1);
        } else{
            captureMotor.set(0);
        }
    }


    public void Shoot() {
//        Thread driveT = new Thread(new Runnable() {
//            public void run() {
        launcherEncoder.reset();
               launcherEncoder.start();
            launcherMotor.set(1);
            Timer.delay(0.250);
            launcherMotor.set(0);
            Timer.delay(0.5);
            int distance = -launcherEncoder.get();

                launcherEncoder.reset();
                launcherEncoder.start();
                launcherMotor.set(-0.1);
                while (true) {
                    int nope = 0;
                    if (launcherEncoder.get() >= distance || nope >= 20) {
                        launcherMotor.set(0);
                        Timer.delay(1);
                        
                        break;
                    }
                    if (launcherEncoder.get() <= -20) {
                        launcherMotor.set(0);
                        System.out.println("**** ENDODER SET IN INCORECT DIRECTION ****");
                        break;
                    }
                    Timer.delay(0.005);
                    if (launcherEncoder.get() < 20) {//saftey code if encoder doesn't work
                        nope++;
                    }
                    if (nope >= 20) {
                        System.out.println("**** ENCODER FAILER ****");
                    }
                }


//            }
//        });
    }

    public void ResetShooter() {
        launcherMotor.setPosition(0);
    }
}
