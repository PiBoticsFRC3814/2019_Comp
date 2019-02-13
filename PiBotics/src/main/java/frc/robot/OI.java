/*
public class OI {

    public static int hatch;

    public boolean hatchGrabToggle = false;
    public boolean tiltHatchToggle = false; 
    public boolean frontWheelToggle = false;
    public boolean backWheelToggle = false;
    public static boolean driveDirectionToggle = false;

    public Joystick driverStick = new Joystick(RobotMap.oi_Driver);
    public Joystick buttonStick = new Joystick(RobotMap.oi_Operator);

    public Button extendHatch = new JoystickButton(buttonStick, 11),//
    tiltHatchUp = new JoystickButton(buttonStick, 12),// 
    hatchLeft = new JoystickButton(buttonStick, 3),
    hatchRight = new JoystickButton(buttonStick, 4),
    hatchCenter = new JoystickButton(buttonStick, 5),

    cameraCenter = new JoystickButton(buttonStick, 6),
    
    extendFrontClimb = new JoystickButton(driverStick, 1),//
    extendBackClimb = new JoystickButton(driverStick, 2),//
    extendAllClimb = new JoystickButton(driverStick, 3),
    driveForwards = new JoystickButton(driverStick, 4),
    driveBackwards = new JoystickButton(driverStick, 5),
    
    intakeBall = new JoystickButton(buttonStick, 7),
    outputBall = new JoystickButton(buttonStick, 8),
    tiltBallUp = new JoystickButton(buttonStick, 9), 
    tiltBallDown = new JoystickButton(buttonStick, 10),
    
    driveDirection = new JoystickButton(driverStick, 6);

  public OI(){

    if(extendHatch.get())//start of hatch grab toggle
    {
      if(hatchGrabToggle)
      {
        extendHatch.whenPressed(new GrabHatchCommand());
        hatchGrabToggle = false;
      }
      if (!hatchGrabToggle)
      {
        extendHatch.whenPressed(new ReleaseHatchCommand());
        hatchGrabToggle = true;
      }
    }//end of hatch grab toggle
    if (tiltHatchUp.get())//start of tilt hatch toggle
    {
      if(tiltHatchToggle)
      {
        new TiltHatchForwardCommand();
        tiltHatchToggle = false;
      }
      if (!tiltHatchToggle)
      {
        new TiltHatchBackCommand();
        tiltHatchToggle = true;
      }
    }//end of tilt hatch toggle


    hatchLeft.whenActive(new HatchLeft());
    hatchLeft.whenInactive(new HatchStop());
    hatchRight.whenActive(new HatchRight());
    hatchRight.whenInactive(new HatchStop());
    hatchCenter.whenPressed(new HatchCenter());

    cameraCenter.whenActive(new CameraCenter());
    cameraCenter.whenInactive(new CameraControl());

    
    if(extendFrontClimb.get())//start of entend front toggle
    {
      if(frontWheelToggle)
      {
        new FrontWheelsExtend();
        frontWheelToggle = false;
      }
      if(!frontWheelToggle)
      {
        new FrontWheelsRetract();
        frontWheelToggle = true;
      }
    }// end of front toggle
    if(extendBackClimb.get())//start of back toggle
    {
      if(backWheelToggle)
      {
        new BackWheelsExtend();
        backWheelToggle = false;
      }
      if(!backWheelToggle)
      {
        new BackWheelsRetract();
        backWheelToggle = true;
      }
    }// end of back toggle
    extendAllClimb.whenPressed(new FrontWheelsExtend());
    extendAllClimb.whenPressed(new BackWheelsExtend());
    driveForwards.whenActive(new ClimbDriveForward());
    driveForwards.whenInactive(new ClimbDriveStop());
    driveBackwards.whenActive(new ClimbDriveReverse());
    driveBackwards.whenInactive(new ClimbDriveStop()); 
    
    intakeBall.whenActive(new BallGrabCommand());
    intakeBall.whenInactive(new BallStopCommand());
    outputBall.whenActive(new BallReleaseCommand());
    outputBall.whenInactive(new BallStopCommand());
    tiltBallUp.whenActive(new BallTiltUpCommand());
    tiltBallUp.whenInactive(new BallTiltStopCommand());
    tiltBallDown.whenActive(new BallTiltDownCommand());
    tiltBallDown.whenInactive(new BallTiltStopCommand());
    
    if(driveDirection.get())
    {
      if (driveDirectionToggle)
      {
        driveDirectionToggle = false;
      }
      if(!driveDirectionToggle)
      {
        driveDirectionToggle = true;
      }
    }
  }
}*/


/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import frc.robot.RobotMap;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    public static int hatch;
    public static boolean driveDirectionToggle = true;
  

    public Joystick driverStick = new Joystick(RobotMap.oi_Driver);
    public Joystick buttonStick = new Joystick(RobotMap.oi_Operator);

    public Button extendHatch = new JoystickButton(buttonStick, 5),//this opens claw
    retractHatch = new JoystickButton(buttonStick, 6),//this closes the claw
    tiltHatchUp = new JoystickButton(buttonStick, 11),//this makes hatch go upright
    tiltHatchDown = new JoystickButton(buttonStick, 12),//this makes hatch goes angled
    hatchLeft = new JoystickButton(driverStick, 5),
    hatchRight = new JoystickButton(driverStick, 6),
    hatchCenter = new JoystickButton(driverStick, 1),

    cameraCenter = new JoystickButton(driverStick, 2),
    
    extendFrontClimb = new JoystickButton(driverStick, 7),
    retractFrontClimb = new JoystickButton(driverStick, 8),
    extendBackClimb = new JoystickButton(driverStick, 11),
    retractBackClimb = new JoystickButton(driverStick, 12),
    //extendAllClimb = new JoystickButton(driverStick, 3),
    driveForwards = new JoystickButton(driverStick, 9),
    driveBackwards = new JoystickButton(driverStick, 10),
    
    intakeBall = new JoystickButton(buttonStick, 7),
    outputBall = new JoystickButton(buttonStick, 8),
    tiltBallUp = new JoystickButton(buttonStick, 4), 
    tiltBallDown = new JoystickButton(buttonStick, 3);

  public OI(){

    if (driverStick.getRawButton(4))
    {
      if(driveDirectionToggle == false)
      {
        driveDirectionToggle = true;
        Robot.timeguy.delay(0.5);
      }
      else
      {
        driveDirectionToggle = false;
        Robot.timeguy.delay(0.5);
      }
    }

    extendHatch.whenPressed(new GrabHatchCommand());
    retractHatch.whenPressed(new ReleaseHatchCommand());
    tiltHatchUp.whenPressed(new TiltHatchForwardCommand());
    tiltHatchDown.whenPressed(new TiltHatchBackCommand());
    hatchLeft.whenActive(new HatchLeft());
    hatchLeft.whenInactive(new HatchStop());
    hatchRight.whenActive(new HatchRight());
    hatchRight.whenInactive(new HatchStop());
    hatchCenter.whenPressed(new HatchCenter());

    cameraCenter.whenActive(new CameraCenter());
    cameraCenter.whenInactive(new CameraControl());

    extendFrontClimb.whenPressed(new FrontWheelsExtend());
    retractFrontClimb.whenPressed(new FrontWheelsRetract());
    extendBackClimb.whenPressed(new BackWheelsExtend());
    retractBackClimb.whenPressed(new BackWheelsRetract());
    //extendAllClimb.whenActive(new FrontWheelsExtend());//needs command
    //extendAllClimb.whenActive(new BackWheelsExtend());
    driveForwards.whenActive(new ClimbDriveForward());
    driveForwards.whenInactive(new ClimbDriveStop());
    driveBackwards.whenActive(new ClimbDriveReverse());
    driveBackwards.whenInactive(new ClimbDriveStop()); 

    if (driverStick.getRawButton(3))
    {
      new FrontWheelsExtend();
      new BackWheelsExtend();
    }
    
    intakeBall.whenActive(new BallGrabCommand());
    intakeBall.whenInactive(new BallStopCommand());
    outputBall.whenActive(new BallReleaseCommand());
    outputBall.whenInactive(new BallStopCommand());
    tiltBallUp.whenActive(new BallTiltUpCommand());
    tiltBallUp.whenInactive(new BallTiltStopCommand());
    tiltBallDown.whenActive(new BallTiltDownCommand());
    tiltBallDown.whenInactive(new BallTiltStopCommand());
<<<<<<< HEAD
    liftBallUp.whenActive(new BallLiftUpCommand());
    liftBallUp.whenInactive(new BallLiftStopCommand());
    liftBallDown.whenActive(new BallLiftDownCommand());
    liftBallDown.whenInactive(new BallLiftStopCommand());
=======

    /*if(buttonStick.getRawAxis(0) > 0.2 || buttonStick.getRawAxis(0) < -0.2 || buttonStick.getRawAxis(1) > 0.2 || buttonStick.getRawAxis(1) < -0.2)
    {
      new CameraControl();
    }*/
>>>>>>> 86b22f5bc3f02cc2083b87f22c6939ba4a9210bd
  }
}