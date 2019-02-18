
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

    public Button toggleTilt = new JoystickButton(buttonStick, 5),
    toggleGrab = new JoystickButton(driverStick, 11),
    hatchLeft = new JoystickButton(driverStick, 5),
    hatchRight = new JoystickButton(driverStick, 6),
    hatchCenter = new JoystickButton(driverStick, 7),
    
    retractFrontClimb = new JoystickButton(buttonStick, 8),
    retractBackClimb = new JoystickButton(buttonStick, 12),
    extendAllClimb = new JoystickButton(buttonStick, 3),
    driveForwards = new JoystickButton(buttonStick, 9),
    driveBackwards = new JoystickButton(buttonStick, 10),

    driveToggle = new JoystickButton(driverStick, 9);
    

  public OI(){

    toggleTilt.whenPressed(new HatchTiltToggle());
    toggleGrab.whenPressed(new HatchToggle());
    hatchLeft.whenActive(new HatchLeft());
    hatchLeft.whenInactive(new HatchStop());
    hatchRight.whenActive(new HatchRight());
    hatchRight.whenInactive(new HatchStop());
    hatchCenter.whenPressed(new HatchCenter());

    retractFrontClimb.whileActive(new FrontWheelsRetract());
    retractBackClimb.whileActive(new BackWheelsRetract());
    retractFrontClimb.whenPressed(new FrontWheelsRetract());
    retractBackClimb.whenPressed(new BackWheelsRetract());
    extendAllClimb.whenActive(new ExtendAll());
    driveForwards.whenActive(new ClimbDriveForward());
    driveForwards.whenInactive(new ClimbDriveStop());
    driveBackwards.whenActive(new ClimbDriveReverse());
    driveBackwards.whenInactive(new ClimbDriveStop()); 

    /*if(buttonStick.getRawAxis(0) > 0.2 || buttonStick.getRawAxis(0) < -0.2 || buttonStick.getRawAxis(1) > 0.2 || buttonStick.getRawAxis(1) < -0.2)
    {
      new CameraControl();
    }*/
  }
}