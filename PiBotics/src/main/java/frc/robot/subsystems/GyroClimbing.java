/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Timer;


public class GyroClimbing extends Subsystem {
  
  public Solenoid front;
  public Solenoid rear;

  AHRS gyro;

  public Timer gyroStop;

  public Boolean gyroFrontAllowed = false;
  public Boolean gyroBackAllowed = false;
  public Boolean stopAll = false;

  public double angle = 0.0;
  public double cmdLoopCount = 0.0;

  @Override
  public void initDefaultCommand() {
    front = new Solenoid(1,0);
    rear = new Solenoid(1,1);

    gyro = new AHRS(Port.kMXP);

    gyroStop = new Timer();
  }

  public double GetAngle()
  {
   angle = gyro.getRoll();
   return angle;
  }
 // public void GetReset()
  //{
   //angle = gyro.reset();
  //}

  public void frontGo()
  {
    front.set(true); //valve open when voltage is present so true should open the valve
  }

  public void frontStop()
  {
    front.set(false);
  }

  public void rearGo()
  {
    rear.set(true);
  }

  public void rearStop()
  {
    rear.set(false);
  }
  public void AllStop()
  {
    front.set(false); //valve open when voltage is present so true should open the valve
    rear.set(false);
  }
  public void AllGo()
  {
    front.set(true); //valve open when voltage is present so true should open the valve
    rear.set(true);
  }
}
