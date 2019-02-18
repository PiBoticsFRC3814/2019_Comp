/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import javax.lang.model.util.ElementScanner6;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;


public class ClimbGyro extends Command {
  public ClimbGyro() {
    requires(Robot.m_ElevatorTalon);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_ElevatorTalon.gyroStop.reset();
    Robot.m_ElevatorTalon.gyroStop.start();
    Robot.m_ElevatorTalon.faultCount = 0;
    Robot.m_ElevatorTalon.frontSpeed = 0.5;
    Robot.m_ElevatorTalon.frontSpeed = 0.5;
    Robot.m_ElevatorTalon.AllUp();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    if (Robot.m_ElevatorTalon.GetAngle() > 0.0)
    {
      Robot.m_ElevatorTalon.frontSpeed = (0.5-(Robot.m_ElevatorTalon.GetAngle()/360));
      Robot.m_ElevatorTalon.backSpeed = 0.5;
      Robot.m_ElevatorTalon.AllUp();
    }
    else if (Robot.m_ElevatorTalon.GetAngle() < 0.0)
    {
      Robot.m_ElevatorTalon.backSpeed = (0.5-(Robot.m_ElevatorTalon.GetAngle()/(-360)));
      Robot.m_ElevatorTalon.frontSpeed = 0.5;
      Robot.m_ElevatorTalon.AllUp();
    }
    else
    {
      Robot.m_ElevatorTalon.frontSpeed = 0.5;
      Robot.m_ElevatorTalon.frontSpeed = 0.5;
      Robot.m_ElevatorTalon.AllUp();
    }

    if (Robot.m_ElevatorTalon.elevatorFront.getOutputCurrent() > 50.0 || Robot.m_ElevatorTalon.elevatorBack.getOutputCurrent() > 50.0)
    {
      Robot.m_ElevatorTalon.faultCount++;
    }

}

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (Robot.m_ElevatorTalon.gyroStop.get() > 10.0 || Robot.m_ElevatorTalon.faultCount > 50)
    {
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