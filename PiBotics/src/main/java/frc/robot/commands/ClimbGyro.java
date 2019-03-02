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
    //Robot.m_ElevatorTalon.gyroStop.start();
    Robot.m_ElevatorTalon.faultCount = 0;
    Robot.m_ElevatorTalon.frontSpeed = RobotMap.climbSpeed;
    Robot.m_ElevatorTalon.backSpeed = RobotMap.climbSpeed;
    Robot.m_ElevatorTalon.AllUp();
  }//unsure when this initialize is recalled?  might re initialize if buttons are restriked?

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    if ((Robot.m_ElevatorTalon.GetAngle()-RobotMap.gyroOffset) < 0.0)
    {//this will adjust the front speed motor if the front of the robot is too high
      Robot.m_ElevatorTalon.frontSpeed = (RobotMap.climbSpeed-(RobotMap.climbAdjustSpeed)); 
      Robot.m_ElevatorTalon.backSpeed = RobotMap.climbSpeed;
      Robot.m_ElevatorTalon.AllUp();
    }
    else if ((Robot.m_ElevatorTalon.GetAngle()-RobotMap.gyroOffset) > 0.0)
    {//this will adjust the back speed motor if the back of the robot is too high
      Robot.m_ElevatorTalon.backSpeed = (RobotMap.climbSpeed-(RobotMap.climbAdjustSpeed));
      Robot.m_ElevatorTalon.frontSpeed = RobotMap.climbSpeed;
      Robot.m_ElevatorTalon.AllUp();
    }
    else
    {//robot is level so not adjustments are made
      Robot.m_ElevatorTalon.frontSpeed = RobotMap.climbSpeed;
      Robot.m_ElevatorTalon.backSpeed = RobotMap.climbSpeed;
      Robot.m_ElevatorTalon.AllUp();
    }

    if (Robot.m_ElevatorTalon.elevatorFront.getOutputCurrent() > 50.0 || Robot.m_ElevatorTalon.elevatorBack.getOutputCurrent() > 50.0)
    {//this is currently not being used.  may be an option in the future for timing
      Robot.m_ElevatorTalon.faultCount++;
    }
    //Robot.m_ElevatorTalon.AllUp();
}

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
   /* if (Robot.m_ElevatorTalon.gyroStop.get() > 10.0 || Robot.m_ElevatorTalon.faultCount > 50)
    {
      return true;
    }
    else
    {
      return false;
    }
    */
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
