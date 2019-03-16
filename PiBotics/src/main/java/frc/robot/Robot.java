/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;



import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.ClimbTalon;
import frc.robot.subsystems.ElevatorTalon;
import frc.robot.subsystems.HatchGrab;
import frc.robot.subsystems.HatchSolenoid;
import frc.robot.subsystems.HatchTalon;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.ElevatorTalonNew;
import com.kauailabs.navx.frc.AHRS;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static driveTrain m_driveTrain;
  public static HatchSolenoid m_HatchSolenoid;
  public static HatchTalon m_HatchTalon;
  public static ClimbTalon m_ClimbTalon;
  public static HatchGrab m_HatchGrab;
  public static ElevatorTalon m_ElevatorTalon;
  public static ElevatorTalonNew m_ElevatorTalonNew; 
  
  public static Timer timeguy;

  public static OI m_oi;

  public static Compressor Comp;

  AHRS gyro;
  public static boolean driveDirection = true;
  public static boolean toggle = true;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {

    m_driveTrain = new driveTrain();
    m_HatchSolenoid = new HatchSolenoid();
    m_HatchTalon = new HatchTalon();
    m_ClimbTalon = new ClimbTalon();
    m_HatchGrab = new HatchGrab();
    m_ElevatorTalon = new ElevatorTalon();
    m_ElevatorTalonNew = new ElevatorTalonNew();

    timeguy = new Timer();
    
    Comp = new Compressor(1);

    m_oi = new OI();

    OI.hatch = 0;
    
    Comp.setClosedLoopControl(true);

    SmartDashboard.putData("Auto mode", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    
    Scheduler.getInstance().run();
    SmartDashboard.putBoolean("hatch Gran", m_HatchGrab.grabDirection);
    SmartDashboard.putBoolean("Hatch Tilt", m_HatchSolenoid.tiltDirection);
    SmartDashboard.putBoolean("hatch center", HatchTalon.limitCenter.get());
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    SmartDashboard.putBoolean("hatch Gran", m_HatchGrab.grabDirection);
    SmartDashboard.putBoolean("Hatch Tilt", m_HatchSolenoid.tiltDirection);
    SmartDashboard.putBoolean("hatch center", HatchTalon.limitCenter.get());
    if (m_ElevatorTalon.gyro.isConnected()){
      SmartDashboard.putNumber("gyro", m_ElevatorTalon.GetAngle());
    }
    /*
    if(toggle && m_oi.driveToggle.get())
    {
      toggle = false;

      if(!driveDirection)
      {
        driveDirection = true;
      }
      else
      {
        driveDirection = false;
      }
    }
    else if (!m_oi.driveToggle.get())
    {
      toggle = true;
    }
    */
    SmartDashboard.putBoolean("dr", driveDirection);
    SmartDashboard.putBoolean("Joy", m_oi.driveToggle.get());
    SmartDashboard.putBoolean("hatch", m_HatchGrab.grabDirection);

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
