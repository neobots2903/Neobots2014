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
    
    class shoot_profile
    {
        public double InitSpeed;
        public int EncoderReset;
        public int FailCountPos;
        public int FailCountNeg;
        public double SetDelay1;
        public double SetDelay2;
        public double SetSpeed2;
        public double SetDelay3;
        public double SetDelay4;

        private shoot_profile(double InitSpeed, int EncoderReset, int FailCountPos, int FailCountNeg, double SetDelay1, double SetDelay2, double SetSpeed2, double SetDelay3, double SetDelay4)
                {
                    this.InitSpeed = InitSpeed;
                    this.EncoderReset = EncoderReset;
                    this.FailCountPos = FailCountPos;
                    this.FailCountNeg = FailCountNeg;
                    this.SetDelay1 = SetDelay1;
                    this.SetDelay2 = SetDelay2;
                    this.SetSpeed2 = SetSpeed2;
                    this.SetDelay3 = SetDelay3;
                    this.SetDelay4 = SetDelay4;
                }
    }

    public Victor launcherMotor = new Victor(RobotMap.launcher);
    public Victor captureMotor = new Victor(RobotMap.catcher);
    public Encoder launcherEncoder = new Encoder(1, 2, true, CounterBase.EncodingType.k2X);

    public shoot_profile Normal;
    public shoot_profile Slow;
    
    public void initDefaultCommand() {

        Normal = new shoot_profile(1.0, 0, 20, -20, 0.250, 0.1, -0.25, 0.4,  0.005);
        Slow   = new shoot_profile(0.3, 0, 20, -20, 0.5,   0.1, -0.25, 0.25, 0.005);
    }

    public void capture(boolean open, boolean close) {
        
 
        if (open && captureMotor.get() != .75) {
            captureMotor.set(.75);
            
            //set to .5 normally
        } else if(close){
            captureMotor.set(-.75);
        } else{
            captureMotor.set(0);
        }
    }

   


    public void Shoot(shoot_profile profile) {
//        Thread driveT = new Thread(new Runnable() {
//            public void run() {
        launcherEncoder.reset();
               launcherEncoder.start();
            launcherMotor.set(profile.InitSpeed);
            Timer.delay(profile.SetDelay1);  // set delay 1
            launcherMotor.set(profile.EncoderReset);
            Timer.delay(profile.SetDelay2);  // set delay 2
            int distance = -launcherEncoder.get();

                launcherEncoder.reset();
                launcherEncoder.start();
                launcherMotor.set(profile.SetSpeed2); // set speed 2
                while (true) {
                    int nope = 0;
                    if (launcherEncoder.get() >= distance || nope >= profile.FailCountPos) {
                        launcherMotor.set(profile.EncoderReset);
                        Timer.delay(profile.SetDelay3);  // set delay 3
                        break;
                    }
                    if (launcherEncoder.get() <= profile.FailCountNeg) {
                        launcherMotor.set(profile.EncoderReset);
                        System.out.println("**** ENDODER SET IN INCORECT DIRECTION ****");
                        break;
                    }
                    Timer.delay(profile.SetDelay4);  // set delay 4
                    if (launcherEncoder.get() < profile.FailCountPos) {//saftey code if encoder doesn't work
                        nope++;
                    }
                    if (nope >= profile.FailCountPos) {
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
