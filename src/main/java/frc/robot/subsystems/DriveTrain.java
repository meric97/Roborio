/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.commands.JoystickDrive;
import frc.robot.commands.*;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import frc.robot.sensors.serialComWorking;


public class DriveTrain extends Subsystem {

  public static serialComWorking workingSerialCom;
  public WPI_TalonSRX driveTrainLeftFrontMotor;
  public WPI_TalonSRX driveTrainLeftRearMotor;
  public WPI_TalonSRX driveTrainRightFrontMotor;
  public WPI_TalonSRX driveTrainRightRearMotor;
  protected double m_maxOutput = 1;
  public static String ros;
  public static String drive_string;
  public static double LeftFront;
  public static double RightFront; 
  public static double RigthRear ;
  public static double LeftRear ;
  public static double a ;

  public DriveTrain() {
   
    
    driveTrainLeftFrontMotor = new WPI_TalonSRX(3);
    driveTrainLeftFrontMotor.setInverted(true);
    
    driveTrainLeftRearMotor = new WPI_TalonSRX(1);
    driveTrainLeftRearMotor.setInverted(true);
    
    driveTrainRightFrontMotor = new WPI_TalonSRX(2);
    driveTrainRightFrontMotor.setInverted(true);
    
    driveTrainRightRearMotor = new WPI_TalonSRX(4);
    driveTrainRightRearMotor.setInverted(true);

  
  }

  @Override
  public void initDefaultCommand() {
    Robot.m_driveTrain.setDefaultCommand(new JoystickDrive());
  
  }

  @Override
  public void periodic() {
    // Put code here to be run every loop
  }

  public void run(String drive_string){
   
    String[] rpm_raw = drive_string.split(",");
   
    char[] rover_left = rpm_raw[0].toCharArray();
    char[] rover_right =rpm_raw[1].toCharArray();
   
    int left_front_ros = 1000*Character.getNumericValue(rover_left[0])+ 100*Character.getNumericValue(rover_left[1])+ 10*Character.getNumericValue(rover_left[2])+Character.getNumericValue(rover_left[3]);
    int left_rear_ros =  1000*Character.getNumericValue(rover_left[0])+ 100*Character.getNumericValue(rover_left[1])+ 10*Character.getNumericValue(rover_left[2])+Character.getNumericValue(rover_left[3]);     
    int right_front_ros = 1000*Character.getNumericValue(rover_right[0])+ 100*Character.getNumericValue(rover_right[1])+ 10*Character.getNumericValue(rover_right[2])+Character.getNumericValue(rover_right[3]);             
    int right_rear_ros =  1000*Character.getNumericValue(rover_right[0])+ 100*Character.getNumericValue(rover_right[1])+ 10*Character.getNumericValue(rover_right[2])+Character.getNumericValue(rover_right[3]);            
    
      if (left_front_ros > 999){
        left_front_ros = -(left_front_ros-1000);
      }
  
      if (left_rear_ros > 999){
        left_rear_ros = -(left_rear_ros-1000);
      }
  
      if (right_front_ros > 999){
        right_front_ros = -(right_front_ros-1000);
      }
  
      if (right_rear_ros > 999){
        right_rear_ros = -(right_rear_ros-1000);
      }
    
    
    System.out.println(left_front_ros+" "+right_front_ros);
 
    // driveTrainLeftFrontMotor.set(-(float)left_front_ros/250);
    
    // driveTrainLeftRearMotor.set(-(float)left_front_ros/250);

    // driveTrainRightFrontMotor.set(-(float)right_front_ros/250);
    
    // driveTrainRightRearMotor.set(-(float)right_front_ros/250);
    
    // LeftFront = -Robot.m_driveTrain.driveTrainLeftFrontMotor.getSelectedSensorVelocity()*6/4096;
    // RightFront = -Robot.m_driveTrain.driveTrainRightFrontMotor.getSelectedSensorVelocity()*6/4096;
    // if((-left_front_ros-right_front_ros)<20 && ((-left_front_ros-right_front_ros)>-20)){
    // driveTrainLeftFrontMotor.set(-(float)left_front_ros*2/240);
    
    // driveTrainLeftRearMotor.set(-(float)left_front_ros*2/240);

    // driveTrainRightFrontMotor.set(-(float)right_front_ros*2/240);
    
    // driveTrainRightRearMotor.set(-(float)right_front_ros*2/240);

    // }else{
    // driveTrainLeftFrontMotor.set(-(float)(1+Math.abs(-right_front_ros+left_front_ros)/320)*left_front_ros/320);
    
    // driveTrainLeftRearMotor.set(-(float)(1+Math.abs(-right_front_ros+left_front_ros)/320)*left_front_ros/320);

    // driveTrainRightFrontMotor.set(-(float)(1+Math.abs(-right_front_ros+left_front_ros)/320)*right_front_ros/320);
    
    // driveTrainRightRearMotor.set(-(float)(1+Math.abs(-right_front_ros+left_front_ros)/320)*right_front_ros/320);
    // }
  }
  public void driveBase() {

    double moveValue = Robot.m_oi.logitech.getY();
    double rotateValue = Robot.m_oi.logitech.getX();
    double leftMotorSpeed;
    double rightMotorSpeed;

    // square the inputs (while preserving the sign) to increase fine control
    // while permitting full power
    //   square the inputs (while preserving the sign) to increase fine control
    //   while permitting full power

    if (moveValue > 0.0) {
      if (rotateValue > 0.0) {
        leftMotorSpeed = moveValue - rotateValue;
        rightMotorSpeed = Math.max(moveValue, rotateValue);
      } else {
        leftMotorSpeed = Math.max(moveValue, -rotateValue);
        rightMotorSpeed = moveValue + rotateValue;
      }
    } else {
      if (rotateValue > 0.0) {
        leftMotorSpeed = -Math.max(-moveValue, rotateValue);
        rightMotorSpeed = moveValue + rotateValue;
      } else {
        leftMotorSpeed = moveValue - rotateValue;
        rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
      }
    }
    

    setLeftRightMotorOutputs(leftMotorSpeed, rightMotorSpeed);
    // if((Robot.m_oi.logitech.getRawAxis(1) < 0.2) || (Robot.m_oi.logitech.getRawAxis(1) > -0.2 )){
    //   a = 0;
    // }else{
    //   a = Robot.m_oi.logitech.getRawAxis(1);

    // }
    // LeftFront = -Robot.m_driveTrain.driveTrainLeftFrontMotor.getSelectedSensorVelocity()*6/4096;
    // RightFront = -Robot.m_driveTrain.driveTrainRightFrontMotor.getSelectedSensorVelocity()*6/4096;
    // Robot.m_driveTrain.driveTrainRightFrontMotor.set(Robot.pid.RigthFrontPid(5,RightFront,0.005, 0, 0, Robot.m_oi.logitech.getRawAxis(1)*200));
    // Robot.m_driveTrain.driveTrainLeftFrontMotor.set(Robot.pid.RigthFrontPid(5,LeftFront,0.005, 0, 0,Robot.m_oi.logitech.getRawAxis(1)*200));
    // Robot.m_driveTrain.driveTrainRightRearMotor.set(Robot.pid.RigthFrontPid(5,RightFront,0.005, 0,0,Robot.m_oi.logitech.getRawAxis(1)*200));
    // Robot.m_driveTrain.driveTrainLeftRearMotor.set(Robot.pid.RigthFrontPid(5,LeftFront,0.0051, 0, 0,Robot.m_oi.logitech.getRawAxis(1)*200));
    // System.out.println(Robot.m_oi.logitech.getRawAxis(1));
  }

  public void setLeftRightMotorOutputs(double leftOutput, double rightOutput) {

    // driveTrainLeftFrontMotor.set(ControlMode.Velocity, (leftOutput * m_maxOutput)*150000);
    
    // driveTrainLeftRearMotor.set(ControlMode.Velocity, (leftOutput * m_maxOutput)*150000);

    // driveTrainRightFrontMotor.set(ControlMode.Velocity, (rightOutput * m_maxOutput)*150000);
    
    // driveTrainRightRearMotor.set(ControlMode.Velocity, (rightOutput * m_maxOutput)*150000);

    // driveTrainLeftFrontMotor.set( leftOutput*1.5/6);
    
    // driveTrainLeftRearMotor.set( leftOutput*1.5/6 );

    // driveTrainRightFrontMotor.set( rightOutput*1.5/6);
    
    // driveTrainRightRearMotor.set( rightOutput*1.5/6 );

    driveTrainLeftFrontMotor.set( (float)(1+Math.abs(-rightOutput+leftOutput)/4)*leftOutput);
    
    driveTrainLeftRearMotor.set( (float)(1+Math.abs(-rightOutput+leftOutput)/4)*leftOutput);

    driveTrainRightFrontMotor.set((float)(1+Math.abs(-rightOutput+leftOutput)/4)*rightOutput);
    
    driveTrainRightRearMotor.set( (float)(1+Math.abs(-rightOutput+leftOutput)/4)*rightOutput);


  }
  }
