/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ElevatorTalonNew extends Subsystem {
  public WPI_TalonSRX elevatorFront;
  public WPI_TalonSRX elevatorBack;

  public ElevatorTalonNew()
  {
    elevatorFront = new WPI_TalonSRX(RobotMap.elevator_Front);
    elevatorBack = new WPI_TalonSRX(RobotMap.elevator_Rear);
  }

  public void FrontUp()
  {
    elevatorFront.set(RobotMap.FrontSpeed);
  }

  public void BackUp()
  {
    elevatorBack.set(RobotMap.BackSpeed);
  }

  public void FrontStop()
  {
    elevatorFront.set(0.0);
  }

  public void BackStop()
  {
    elevatorBack.set(0.0);
  }

  @Override
  public void initDefaultCommand() {
    
  }
}
