/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class ClimbSolenoid extends Subsystem {
  // Put methods for controlling this subsystem
  DoubleSolenoid frontSolenoid;
  DoubleSolenoid backSolenoid;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    frontSolenoid = new DoubleSolenoid(0, 1);
    backSolenoid = new DoubleSolenoid(2, 3);
  }

  public void FrontExtend()
  {
    frontSolenoid.set(Value.kForward);
  }

  public void BackExtend()
  {
    backSolenoid.set(Value.kForward);
  }
  public void FrontRetract()
  {
    frontSolenoid.set(Value.kReverse);
  }

  public void BackRetract()
  {
    backSolenoid.set(Value.kReverse);
  }

}
