/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Servo;
import frc.robot.commands.CameraControl;
import frc.robot.RobotMap;


public class CamServo extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Servo camX = new Servo(RobotMap.camera_X);
  Servo camY = new  Servo(RobotMap.camera_Y);
  
  double degrees = 90.0;
  


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new CameraControl());
    camX.setAngle(degrees);
    camY.setAngle(degrees);
  }
  public void CamXLeft()
  {
    degrees = camX.getAngle();
    degrees += -1;
    camX.setAngle(degrees);
  }
  public void CamXRight()
  {
    degrees = camX.getAngle();
    degrees += 1;
    camX.setAngle(degrees);
  }public void CamYDown()
  {
    degrees = camY.getAngle();
    degrees += -1;
    camY.setAngle(degrees);
  }
  public void CamYUp()
  {
    degrees = camY.getAngle();
    degrees += 1;
    camY.setAngle(degrees);
  }
  public void CamCenter()
  {
    camX.setAngle(90.0);
    camY.setAngle(90.0);
  }
}