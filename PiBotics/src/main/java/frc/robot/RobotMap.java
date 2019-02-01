/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //talons
  public static const int drive_lf = 13;
  public static const int drive_lr = 12;
  public static const int drive_rf = 11;
  public static const int drive_rr = 10;
  public static const int ball_Lift = 20;
  public static const int ball_Intake = 21;
  public static const int ball_Tilt = 22;
  public static const int climb_Drive = 30;
  public static const int hatch_Slide = 40;
  //solenoids
  public static const int climb_Front1 = 0;
  public static const int climb_Front2 = 1;
  public static const int climb_Back1 = 2;
  public static const int climb_Back2 = 3;
  public static const int hatch_Grab1 = 4;
  public static const int hatch_Grab2 = 5;
  public static const int hatch_Tilt1 = 6;
  public static const int hatch_Tilt2 = 7;
  //camera
  public static const int camera_X = 0;
  public static const int camera_Y = 1;
  //sticks
  public static const int oi_Driver = 0;
  public static const int oi_Operator = 2;
}
