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
//import frc.robot.commands.*;

/**
 * Add your docs here.
 */
public class HatchSolenoid extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid grabSolenoid;
  DoubleSolenoid tiltSolenoid;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    grabSolenoid = new DoubleSolenoid(4, 5);
    tiltSolenoid = new DoubleSolenoid(6, 7);
  }

  public void grabSolenoidControl()
  {
    grabSolenoid.set(Value.kForward);
  }

  public void releaseSolenoidControl()
  {
    grabSolenoid.set(Value.kReverse);
  }  

  public void tiltForward()
  {
    tiltSolenoid.set(Value.kForward);
  }
  public void tiltBack()
  {
    tiltSolenoid.set(Value.kReverse);
  }
}
