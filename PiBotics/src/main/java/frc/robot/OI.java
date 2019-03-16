
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
  
    public Joystick driverStick = new Joystick(RobotMap.oi_Driver);
    public Joystick buttonStick = new Joystick(RobotMap.oi_Operator);

    public Button toggleTilt = new JoystickButton(buttonStick, 5),
    toggleGrab = new JoystickButton(driverStick, 11),
    hatchLeft = new JoystickButton(driverStick, 5),
    hatchRight = new JoystickButton(driverStick, 6),
    hatchCenter = new JoystickButton(driverStick, 7),
    
    retractFrontClimb = new JoystickButton(buttonStick, 10),
    retractBackClimb = new JoystickButton(buttonStick, 9),
    //extendAllClimb = new JoystickButton(buttonStick, 3),
    extendFrontClimb = new JoystickButton(buttonStick, 3),
    extendBackClimb = new JoystickButton(buttonStick, 4),
    driveForwards = new JoystickButton(buttonStick, 8),
    driveBackwards = new JoystickButton(buttonStick, 7),

    driveToggle = new JoystickButton(driverStick, 9);
    

  public OI(){

    toggleTilt.whenPressed(new HatchTiltToggle());
    toggleGrab.whenPressed(new HatchToggle());
    hatchLeft.whenActive(new HatchLeft());
    hatchLeft.whenInactive(new HatchStop());
    hatchRight.whenActive(new HatchRight());
    hatchRight.whenInactive(new HatchStop());
    hatchCenter.whenPressed(new HatchCenter());

    retractFrontClimb.whenPressed(new FrontWheelsRetract());
    retractBackClimb.whenPressed(new BackWheelsRetract());
    retractFrontClimb.whenReleased(new FrontWheelsStop());
    retractBackClimb.whenReleased(new BackWheelsStop());
    //extendAllClimb.whenPressed(new ExtendAll());  //no gyro assist
    //extendAllClimb.whenReleased(new StopAll());    // no gyro held button
    extendFrontClimb.whenActive(new ClimbFront());
    extendFrontClimb.whenInactive(new StopAllNew());
    extendBackClimb.whenActive(new ClimbBack());
    extendBackClimb.whenInactive(new StopAllNew());
    driveForwards.whenActive(new ClimbDriveForward());
    driveForwards.whenInactive(new ClimbDriveStop());
    driveBackwards.whenActive(new ClimbDriveReverse());
    driveBackwards.whenInactive(new ClimbDriveStop()); 

  }
}

/*Emergency buttons

package frc.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import frc.robot.RobotMap;

public class OI {

  public static int hatch;

  public Joystick driverStick = new Joystick(RobotMap.oi_Driver);
  public Joystick buttonStick = new Joystick(RobotMap.oi_Operator);

  public Button toggleTilt = new JoystickButton(buttonStick, 4),
  toggleGrab = new JoystickButton(driverStick, 11),
  hatchLeft = new JoystickButton(driverStick, 5),
  hatchRight = new JoystickButton(driverStick, 6),
  hatchCenter = new JoystickButton(driverStick, 7),
  
  retractFrontClimb = new JoystickButton(buttonStick, 10),
  retractBackClimb = new JoystickButton(buttonStick, 12),
  extendAllClimb1 = new JoystickButton(buttonStick, 7),
  extendAllClimb2 = new JoystickButton(buttonStick, 8),
  driveForwards = new JoystickButton(buttonStick, 11),
  driveBackwards = new JoystickButton(buttonStick, 9),

  driveToggle = new JoystickButton(driverStick, 9);
  

public OI(){

  toggleTilt.whenPressed(new HatchTiltToggle());
  toggleGrab.whenPressed(new HatchToggle());
  hatchLeft.whenActive(new HatchLeft());
  hatchLeft.whenInactive(new HatchStop());
  hatchRight.whenActive(new HatchRight());
  hatchRight.whenInactive(new HatchStop());
  hatchCenter.whenPressed(new HatchCenter());

  retractFrontClimb.whenPressed(new FrontWheelsRetract());
  retractBackClimb.whenPressed(new BackWheelsRetract());
  retractFrontClimb.whenReleased(new FrontWheelsStop());
  retractBackClimb.whenReleased(new BackWheelsStop());

  if (extendAllClimb1.get() && extendAllClimb2.get())
  {
    new ExtendAll();
  }
  else
  {
    new StopAll();
  }

  driveForwards.whenActive(new ClimbDriveForward());
  driveForwards.whenInactive(new ClimbDriveStop());
  driveBackwards.whenActive(new ClimbDriveReverse());
  driveBackwards.whenInactive(new ClimbDriveStop()); 

}
}*/