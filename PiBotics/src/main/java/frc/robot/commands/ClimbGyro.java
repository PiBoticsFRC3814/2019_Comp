/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;


public class ClimbGyro extends Command {
  public ClimbGyro() {
    requires(Robot.m_GyroClimb);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_GyroClimb.gyroStop.reset();
    Robot.m_GyroClimb.gyroStop.start();
    Robot.m_GyroClimb.frontGo();
    Robot.m_GyroClimb.rearGo();
    RobotMap.slowTime = 0.0;
    Robot.m_GyroClimb.cmdLoopCount = 0.0;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_GyroClimb.cmdLoopCount ++;
    Robot.m_GyroClimb.angle = Robot.m_GyroClimb.GetAngle();
    

    if(Robot.m_GyroClimb.angle < -1.0){
      Robot.m_GyroClimb.gyroFrontAllowed = true;
    }
    else
    {
      Robot.m_GyroClimb.gyroFrontAllowed = false;
    }
    
    if(Robot.m_GyroClimb.angle > 1.0){
      Robot.m_GyroClimb.gyroBackAllowed = true;
    }
    else
    {
      Robot.m_GyroClimb.gyroBackAllowed = false;
    }

    /*if(/*Robot.m_GyroClimb.angle > 5.0 || Robot.m_GyroClimb.angle < -5.0/ Robot.m_GyroClimb.gyroStop.get() >= 2) 
    {
      Robot.m_GyroClimb.stopAll = true;
      if (RobotMap.actuateTime)
      {
      SmartDashboard.putNumber("StopAll Time", Robot.m_GyroClimb.gyroStop.get());
      RobotMap.actuateTime = false; 
      }
    }*/
    //if(Robot.m_GyroClimb.angle < 2.0 && Robot.m_GyroClimb.angle > -2.0)
    //{
    //  Robot.m_GyroClimb.stopAll = false;
    //}
    
    if(Robot.m_GyroClimb.stopAll)
    {
      Robot.m_GyroClimb.AllStop();
      if (RobotMap.actualTime)
      {
      SmartDashboard.putNumber("actual Time", Robot.m_GyroClimb.gyroStop.get());
      RobotMap.actualTime = false; 
      }
    }

if(Robot.m_GyroClimb.cmdLoopCount >= RobotMap.slowTime && Robot.m_GyroClimb.cmdLoopCount <= (RobotMap.slowTime+20000))
{
  RobotMap.timertest = true;
    if (!Robot.m_GyroClimb.stopAll && Robot.m_GyroClimb.gyroFrontAllowed && Robot.m_GyroClimb.angle < -3.0)
    {
      Robot.m_GyroClimb.frontStop();
    }
    else if (!Robot.m_GyroClimb.stopAll)
    {
      Robot.m_GyroClimb.frontGo();
    }

    if (!Robot.m_GyroClimb.stopAll && !Robot.m_GyroClimb.stopAll && Robot.m_GyroClimb.gyroBackAllowed && Robot.m_GyroClimb.angle > 3.0)
    {
      Robot.m_GyroClimb.rearStop();
    }
    else if (!Robot.m_GyroClimb.stopAll)
    {
      Robot.m_GyroClimb.rearGo();
    }
  }
  else if (RobotMap.timertest)
  {
  RobotMap.slowTime+=600;
  RobotMap.timertest = false;
  }
  else
  {
    Robot.m_GyroClimb.AllStop();
  }
SmartDashboard.putNumber("pausecount", RobotMap.slowTime);
}

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    
    if (Robot.m_GyroClimb.gyroStop.get() > 40.0)
    {
      Robot.m_GyroClimb.frontGo();
      Robot.m_GyroClimb.rearGo();
      return true;
    }
    else 
    {
      return false;
    }
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
