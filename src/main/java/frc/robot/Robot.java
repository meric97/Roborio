/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.subsystems.DriveTrain;
import frc.robot.commands.JoystickDrive;
import frc.robot.commands.PID;
import frc.robot.commands.Full;
import frc.robot.commands.Inverse;
import frc.robot.subsystems.Science;
import frc.robot.subsystems.RoboticArm;
import frc.robot.sensors.Encoder;
// import java.io.PrintWriter;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.PIDCommand;

// import frc.robot.sensors.serialComWorking;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  // public static serialComWorking workingSerialCom;

  public static PID pid;
  public static DriveTrain m_driveTrain;
  public static OI m_oi;
  public static Encoder encoder;
  public static JoystickDrive JoystickDrive;
  public static RoboticArm RoboticArm;
  public static Science Science;
  public static String ros_string;
  public static Inverse inverse;
  
  public static int LeftFront;
  public static int LeftRear;
  public static int RightFront;
  public static int RigthRear;
  
  public static String gulce;
  public static String yavuz = "";
  
  public static String LeftFront_ros;
  public static String RigthFront_ros;
  
  public static String alt_yurur;
  public static String robot_kol;

  // Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_driveTrain = new DriveTrain();
    m_oi = new OI();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
    encoder = new Encoder();
    JoystickDrive = new JoystickDrive();
    RoboticArm = new RoboticArm();
    Science = new Science();
    pid = new PID();
    inverse = new Inverse();

    // workingSerialCom = new serialComWorking();


    // while(true){
    //   //   ros_string = workingSerialCom.read();
    //   //   System.out.println(ros_string);
    //   LeftFront = Robot.m_driveTrain.dr+iveTrainLeftFrontMotor.getSelectedSensorVelocity()*(10/4096);
    //   RightFront =  Robot.m_driveTrain.driveTrainRightFrontMotor.getSelectedSensorVelocity()*(10/4096);
    //   LeftFront_ros = workingSerialCom.floattosString(LeftFront);
    //   RigthFront_ros = workingSerialCom.floattosString(RightFront);

    //   ros_string = workingSerialCom.read();
    //   gulce = workingSerialCom.StringConverter(ros_string, 1);
    //   System.out.println(gulce);
    //   workingSerialCom.write(LeftFront_ros+RigthFront_ros+"\n");
    // }
      // workingSerialCom.write("Yavuz\n");
    //   // RoboticArm.run();
    //   // m_driveTrain.run();
    //   // workingSerialCom.StringConverter(ros_string, 3);
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
    // m_driveTrain.run(gulce);



    // workingSerialCom.StringConverter(ros_string, 2);
    // RoboticArm.run( workingSerialCom.StringConverter(ros_string, 2));
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

    Robot.m_driveTrain.driveTrainLeftFrontMotor.setSelectedSensorPosition(0);
    Robot.m_driveTrain.driveTrainRightFrontMotor.setSelectedSensorPosition(0);
    Robot.m_driveTrain.driveTrainRightRearMotor.setSelectedSensorPosition(0);
    Robot.m_driveTrain.driveTrainLeftRearMotor.setSelectedSensorPosition(0);

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
   
    // m_driveTrain.driveBase();

      // ros_string = workingSerialCom.read();
      // System.out.println(ros_string);
      // gulce = workingSerialCom.StringConverter(ros_string, 1);
      // m_driveTrain.run(gulce);
      // // System.out.println(Robot.m_driveTrain.driveTrainRightFrontMotor.getSelectedSensorVelocity());

      // LeftFront = (Robot.m_driveTrain.driveTrainLeftFrontMotor.getSelectedSensorVelocity()*6)/4096;
      // RightFront =  (Robot.m_driveTrain.driveTrainRightFrontMotor.getSelectedSensorVelocity()*6)/4096;
      // LeftFront_ros = workingSerialCom.floattosString(LeftFront);
      // RigthFront_ros = workingSerialCom.floattosString(RightFront);

      // workingSerialCom.write("S"+LeftFront_ros+","+RigthFront_ros+"F"+"\n");

  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    // ros_string = workingSerialCom.read();
    // yavuz = workingSerialCom.StringConverter(ros_string, 2);
    // Inverse.Inverse(yavuz);

    // JoystickDrive.execute();



    // ros_string = workingSerialCom.read();
    // alt_yurur = workingSerialCom.StringConverter(ros_string, 1);
    // robot_kol = workingSerialCom.StringConverter(ros_string, 2);
    Full.Full(yavuz);
     
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    // yavuz = workingSerialCom.StringConverter(ros_string, 3);
    // Science.science();  
    
}
}