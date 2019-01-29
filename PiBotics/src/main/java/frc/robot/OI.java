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

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  

    public Joystick driverStick = new Joystick(0);
    public Joystick buttonStick = new Joystick(2);

    public Button extendHatch = new JoystickButton(buttonStick, 5),
    retractHatch = new JoystickButton(buttonStick, 6),
    tiltHatchUp = new JoystickButton(buttonStick, 11),
    tiltHatchDown = new JoystickButton(buttonStick, 12),
    hatchLeft = new JoystickButton(buttonStick, 13),
    hatchRight = new JoystickButton(buttonStick, 14),
    
    extendFrontClimb = new JoystickButton(driverStick, 7),
    retractFrontClimb = new JoystickButton(driverStick, 8),
    extendBackClimb = new JoystickButton(driverStick, 11),
    retractBackClimb = new JoystickButton(driverStick, 12),
    extendAllClimb = new JoystickButton(driverStick, 1),
    driveForwards = new JoystickButton(driverStick, 9),
    driveBackwards = new JoystickButton(driverStick, 10),
    
    intakeBall = new JoystickButton(buttonStick, 7),
    outputBall = new JoystickButton(buttonStick, 8),
    tiltBallUp = new JoystickButton(buttonStick, 4), 
    tiltBallDown = new JoystickButton(buttonStick, 3), 
    liftBallUp = new JoystickButton(buttonStick, 10), 
    liftBallDown = new JoystickButton(buttonStick, 9); 

  public OI(){

    extendHatch.whenPressed(new GrabHatchCommand());
    retractHatch.whenPressed(new ReleaseHatchCommand());
    tiltHatchUp.whenPressed(new TiltHatchForwardCommand());
    tiltHatchDown.whenPressed(new TiltHatchBackCommand());
    hatchLeft.whenActive(new HatchLeft());
    hatchLeft.whenInactive(new HatchStop());
    hatchRight.whenActive(new HatchRight());
    hatchRight.whenInactive(new HatchStop());


  
    extendFrontClimb.whenPressed(new FrontWheelsExtend());
    retractFrontClimb.whenPressed(new FrontWheelsRetract());
    extendBackClimb.whenPressed(new BackWheelsExtend());
    retractBackClimb.whenPressed(new BackWheelsRetract());
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
    liftBallUp.whenActive(new BallLiftUpCommand());
    liftBallUp.whenInactive(new BallLiftStopCommand());
    liftBallDown.whenActive(new BallLiftDownCommand());
    liftBallDown.whenInactive(new BallLiftStopCommand());

    if(buttonStick.getRawAxis(0) > 0.2 || buttonStick.getRawAxis(0) < -0.2 || buttonStick.getRawAxis(1) > 0.2 || buttonStick.getRawAxis(1) < -0.2)
    {
      new CameraControl();
    }
  }
}
