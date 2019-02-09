/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
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

    public boolean hatchGrabToggle;
    public boolean tiltHatchToggle; 
    public boolean frontWheelToggle;
    public boolean backWheelToggle;
    public static boolean driveDirectionToggle;

    public Joystick driverStick = new Joystick(RobotMap.oi_Driver);
    public Joystick buttonStick = new Joystick(RobotMap.oi_Operator);

    public Button extendHatch = new JoystickButton(buttonStick, 1),//
    tiltHatchUp = new JoystickButton(buttonStick, 2),// 
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
        new GrabHatchCommand();
        hatchGrabToggle = false;
      }
      else
      {
        new ReleaseHatchCommand();
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
      else
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
      else
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
      else
      {
        new BackWheelsRetract();
        backWheelToggle = true;
      }
    }// end of back toggle
    extendAllClimb.whenPressed(new FrontWheelsExtend());
    extendAllClimb.whenPressed(new FrontWheelsExtend());
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
      else
      {
        driveDirectionToggle = true;
      }
    }
  }
}
