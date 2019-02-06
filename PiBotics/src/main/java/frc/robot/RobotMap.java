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
  public static final int drive_lf = 13;
  public static final int drive_lr = 12;
  public static final int drive_rf = 11;
  public static final int drive_rr = 10;
  public static final int ball_Lift = 20;
  public static final int ball_Intake = 21;
  public static final int ball_Tilt = 22;
  public static final int climb_Drives = 30;
  public static final int hatch_Slide = 40;
  //solenoids
  public static final int climb_Front1 = 0;
  public static final int climb_Front2 = 1;
  public static final int climb_Back1 = 2;
  public static final int climb_Back2 = 3;
  public static final int hatch_Grab1 = 4;
  public static final int hatch_Grab2 = 5;
  public static final int hatch_Tilt1 = 6;
  public static final int hatch_Tilt2 = 7;
  //camera
  public static final int camera_X = 0;
  public static final int camera_Y = 1;
  //sticks
  public static final int oi_Driver = 0;
  public static final int oi_Operator = 2;
}
