package edu.wpi.first.wpilibj.team2903.subsystems;
//Z and locked button

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
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
    public Encoder launcherEncoder = new Encoder(1, 2, true, CounterBase.EncodingType.k4X);
    public DigitalInput catureLimit = new DigitalInput(10);

    public void initDefaultCommand() {
        launcherEncoder.setDistancePerPulse(0.25);
    }

    public void hold(double direction) {
        if(catureLimit.get() && direction < 0){
            captureMotor.set(0);
        }else{
            captureMotor.set(direction);
        }
    }

    public void Shoot() {
        launcherEncoder.reset();
        launcherEncoder.start();
        launcherMotor.set(1);
        while(true){
            int nope = 0;
            if(launcherEncoder.getDistance() >= 90 || nope >= 20){
                launcherMotor.set(0);
                break;
            }
            if(launcherEncoder.getDistance() <= -20){
                launcherMotor.set(0);
                System.out.println("**** ENDODER SET IN INCORECT DIRECTION ****");
                break;
            }
            Timer.delay(0.005);
            if(launcherEncoder.getDistance() < 20){//saftey code if encoder doesn't work
                nope++;
            }
            if(nope >= 20){
                System.out.println("**** ENCODER FAILER ****");
            }
        }
        
//        launcherMotor.set(1);
//        Timer.delay(0.250);
//        launcherMotor.set(0);
//        Timer.delay(5);
    }

    public void ResetShooter() {
        launcherMotor.setPosition(0);
    }
}
