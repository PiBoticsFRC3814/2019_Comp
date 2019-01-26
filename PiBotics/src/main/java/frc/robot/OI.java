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
    public Joystick buttonStick2 = new Joystick(3);

    public Button extendHatch = new JoystickButton(buttonStick, 1),
    retractHatch = new JoystickButton(buttonStick, 2),
    tiltHatchUp = new JoystickButton(buttonStick, 3),
    tiltHatchDown = new JoystickButton(buttonStick, 4),
    hatchLeft = new JoystickButton(buttonStick, 5),
    hatchRight = new JoystickButton(buttonStick, 6),
    
    extendFrontClimb = new JoystickButton(buttonStick, 7),
    retractFrontClimb = new JoystickButton(buttonStick, 8),
    extendBackClimb = new JoystickButton(buttonStick, 9),
    retractBackClimb = new JoystickButton(buttonStick, 10),
    extendAllClimb = new JoystickButton(buttonStick, 11),
    driveForwards = new JoystickButton(buttonStick, 12),
    driveBackwards = new JoystickButton(buttonStick, 13),
    
    intakeBall = new JoystickButton(buttonStick2, 1),
    outputBall = new JoystickButton(buttonStick2, 2),
    tiltBallUp = new JoystickButton(buttonStick, 16),
    tiltBallDown = new JoystickButton(buttonStick, 17),
    liftBallUp = new JoystickButton(buttonStick, 18),
    liftBallDown = new JoystickButton(buttonStick, 19);

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
    extendBackClimb.whenPressed(new BackWheelsRetract());
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

    if(buttonStick.getRawAxis(0) > 0.2 || buttonStick.getRawAxis(0) < -0.2 || buttonStick.getRawAxis(1) > 0.2 || buttonStick.getRawAxis(1) < -0.2)
    {
      new CameraControl();
    }
  }
}
