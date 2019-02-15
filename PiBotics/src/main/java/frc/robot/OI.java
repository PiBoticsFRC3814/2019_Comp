
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
import edu.wpi.first.wpilibj.smartdashboard.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    public static int hatch;
  

    public Joystick driverStick = new Joystick(RobotMap.oi_Driver);
    public Joystick buttonStick = new Joystick(RobotMap.oi_Operator);

    //public Button extendHatch = new JoystickButton(buttonStick, 5),//this opens claw
    //retractHatch = new JoystickButton(buttonStick, 6),//this closes the claw
    //tiltHatchUp = new JoystickButton(buttonStick, 11),//this makes hatch go upright
    //tiltHatchDown = new JoystickButton(buttonStick, 12),//this makes hatch goes angled
    public Button toggleTilt = new JoystickButton(buttonStick, 5),
    toggleGrab = new JoystickButton(buttonStick, 6),
    hatchLeft = new JoystickButton(driverStick, 5),
    hatchRight = new JoystickButton(driverStick, 6),
    hatchCenter = new JoystickButton(driverStick, 1),

    cameraCenter = new JoystickButton(driverStick, 2),
    
    extendFrontClimb = new JoystickButton(driverStick, 7),
    retractFrontClimb = new JoystickButton(driverStick, 8),
    extendBackClimb = new JoystickButton(driverStick, 11),
    retractBackClimb = new JoystickButton(driverStick, 12),
    extendAllClimb = new JoystickButton(driverStick, 3),
    driveForwards = new JoystickButton(driverStick, 9),
    driveBackwards = new JoystickButton(driverStick, 10),
    driveToggle = new JoystickButton(driverStick, 4),
    
    intakeBall = new JoystickButton(buttonStick, 7),
    outputBall = new JoystickButton(buttonStick, 8),
    tiltBallUp = new JoystickButton(buttonStick, 4), 
    tiltBallDown = new JoystickButton(buttonStick, 3);

  public OI(){

    //extendHatch.whenPressed(new GrabHatchCommand());
    //retractHatch.whenPressed(new ReleaseHatchCommand());
    //tiltHatchUp.whenPressed(new TiltHatchForwardCommand());
    //tiltHatchDown.whenPressed(new TiltHatchBackCommand());
    toggleTilt.whenPressed(new HatchTiltToggle());
    toggleGrab.whenPressed(new HatchToggle());
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
    extendAllClimb.whenActive(new ExtendAll());
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

    /*if(buttonStick.getRawAxis(0) > 0.2 || buttonStick.getRawAxis(0) < -0.2 || buttonStick.getRawAxis(1) > 0.2 || buttonStick.getRawAxis(1) < -0.2)
    {
      new CameraControl();
    }*/
  }
}