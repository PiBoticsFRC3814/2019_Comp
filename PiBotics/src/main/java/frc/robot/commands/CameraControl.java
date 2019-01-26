/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class CameraControl extends Command {
  public CameraControl() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_camControl);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double x = Robot.m_oi.buttonStick.getX();
    double y = -Robot.m_oi.buttonStick.getY();
    if (x == 1.0)
    {
      Robot.m_camControl.CamYDown();
    }
    else if(x == -1.0)
    {
      Robot.m_camControl.CamYUp();
    }
    if (y == 1.0)
    {
      Robot.m_camControl.CamXLeft();
    }
    else if (y == -1.0)
    {
      Robot.m_camControl.CamXRight();
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
