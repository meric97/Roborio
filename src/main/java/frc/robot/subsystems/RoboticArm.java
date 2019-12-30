/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.WPI_MotorSafetyImplem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.RobotState;
import frc.robot.Robot;
import frc.robot.commands.JoystickDrive;
// import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import frc.robot.sensors.Encoder;
import frc.robot.sensors.serialComWorking;


/**
 * Add your docs here.
 */
public class RoboticArm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static serialComWorking workingSerialCom;
  public static PID PID;
  public static String ros_arm_string;
  public static WPI_TalonSRX joint1Motor;
  public static WPI_TalonSRX joint2Motor;
  public static WPI_TalonSRX joint3Motor;
  public static WPI_TalonSRX joint4Motor;
  public static WPI_TalonSRX joint5Motor;
  public static WPI_TalonSRX joint6Motor;
  public static WPI_TalonSRX joint7Motor;
  public static double target_angle;
  public static int joint1 ;
  public static int joint2 ;
  public static int joint3 ;
  public static int joint4 ;
  public static int joint5 ;
  public static int joint6 ;
  public static int joint7 ;
  public static String robotic_arm_string;
  public static char[] robotic_arm_str;

  public RoboticArm() {
    // Construct objects here
    // leftFrontTalon = new WPI_TalonSRX(11);
    
    PID = new PID();

    joint1Motor = new WPI_TalonSRX(5);
    // joint1Motor.setInverted(true);
    
    joint2Motor = new WPI_TalonSRX(6);
    // joint2Motor.setInverted(true);
    
    joint3Motor = new WPI_TalonSRX(7);
    // joint3Motor.setInverted(true);
    
    joint4Motor = new WPI_TalonSRX(8);
    // joint4Motor.setInverted(true);

    joint5Motor = new WPI_TalonSRX(9);
    // joint5Motor.setInverted(true);

    joint6Motor = new WPI_TalonSRX(10);
    // joint6Motor.setInverted(true);

    joint7Motor = new WPI_TalonSRX(11);
    // joint7Motor.setInverted(true);
    
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public static void run (String robotic_arm_string){
   
    String[] arm_string = robotic_arm_string.split(",");
   
    char[] joint1_str = arm_string[0].toCharArray();
    char[] joint2_str = arm_string[1].toCharArray();
    char[] joint3_str = arm_string[2].toCharArray();
    char[] joint4_str = arm_string[3].toCharArray();
    char[] joint5_str = arm_string[4].toCharArray();
    char[] joint6_str = arm_string[5].toCharArray();
    char[] gripper_str = arm_string[6].toCharArray();

    int joint1 = 1000*Character.getNumericValue(joint1_str[0])+ 100*Character.getNumericValue(joint1_str[1])+ 10*Character.getNumericValue(joint1_str[2])+Character.getNumericValue(joint1_str[3]);
    int joint2 =  1000*Character.getNumericValue(joint2_str[0])+ 100*Character.getNumericValue(joint2_str[1])+ 10*Character.getNumericValue(joint2_str[2])+Character.getNumericValue(joint2_str[3]);     
    int joint3 = 1000*Character.getNumericValue(joint3_str[0])+ 100*Character.getNumericValue(joint3_str[1])+ 10*Character.getNumericValue(joint3_str[2])+Character.getNumericValue(joint3_str[3]);             
    int joint4 =  1000*Character.getNumericValue(joint4_str[0])+ 100*Character.getNumericValue(joint4_str[1])+ 10*Character.getNumericValue(joint4_str[2])+Character.getNumericValue(joint4_str[3]);            
    int joint5 =  1000*Character.getNumericValue(joint5_str[0])+ 100*Character.getNumericValue(joint5_str[1])+ 10*Character.getNumericValue(joint5_str[2])+Character.getNumericValue(joint5_str[3]);            
    int joint6 =  1000*Character.getNumericValue(joint6_str[0])+ 100*Character.getNumericValue(joint6_str[1])+ 10*Character.getNumericValue(joint6_str[2])+Character.getNumericValue(joint6_str[3]);            
    int gripper =  1000*Character.getNumericValue(gripper_str[0])+ 100*Character.getNumericValue(gripper_str[1])+ 10*Character.getNumericValue(gripper_str[2])+Character.getNumericValue(gripper_str[3]);
    
    if (joint1 > 999){
      joint1 = -(joint1-1000);
    }

    if (joint2 > 999){
      joint2 = -(joint2-1000);
    }

    if (joint3 > 999){
      joint3 = -(joint3-1000);
    }

    if (joint4 > 999){
      joint4 = -(joint4-1000);
    }

    if (joint5 > 999){
      joint5 = -(joint5-1000);
    }

    if (joint6 > 999){
      joint6 = -(joint6-1000);
    }

    if (gripper > 999){
      gripper = -(gripper-1000);
    }

      System.out.println(joint1+" "+joint2+" "+joint3+" "+joint4+" "+joint5+" "+joint6+" "+gripper);

    RoboticArm.yavuzkalposman1(joint1);
    System.out.println("1.Encoder konumu: " + Encoder.arm1encoder());

    RoboticArm.yavuzkalposman2(joint2);
    System.out.println("2.Encoder konumu: " + Encoder.arm2encoder());

    RoboticArm.yavuzkalposman3(joint3);
    System.out.println("3.Encoder konumu: " + Encoder.arm3encoder());

    RoboticArm.yavuzkalposman4(joint4);
    System.out.println("4.Encoder konumu: " + Encoder.arm4encoder());

    RoboticArm.yavuzkalposman5(joint5);
    System.out.println("5.Encoder konumu: " + Encoder.arm5encoder());

    RoboticArm.yavuzkalposman6(joint6);
    System.out.println("6.Encoder konumu: " + Encoder.arm6encoder());

    if(gripper == 2 ){
      joint7Motor.set(0);
    }else if(gripper == 0 ){
      joint7Motor.set(-0.2);
   }else if(gripper == 1 ){
      joint7Motor.set(0.2);
  }

  }
  public static void yavuzkalposman1 (double target_angle){
    joint1Motor.set(PID.pid1(0.5, 0.1, 0.3, 0.5, target_angle)); // pid ( tolerans, kP, kI, kD, hedef açı )
    System.out.println("1. Eksen Aci: " + target_angle);
  }

  public static void yavuzkalposman2 (double target_angle) {
    joint2Motor.set(PID.pid2(0.2, 0.3, 0.1, 0.008, target_angle)); // pid ( tolerans, kP, kI, kD, hedef açı )
    System.out.println("2. Eksen Aci: " + target_angle);
  }

  public static void yavuzkalposman3 (double target_angle) {
    joint3Motor.set(PID.pid3(0.2, 0.3, 0.1, 0.1, target_angle)); // pid ( tolerans, kP, kI, kD, hedef açı )
    System.out.println("2. Eksen Aci: " + target_angle);
  }

  public static void yavuzkalposman4 (double target_angle){
    joint4Motor.set(PID.pid4(1, 0.008, 0.3, 0.5, target_angle)); // pid ( tolerans, kP, kI, kD, hedef açı )
    System.out.println("4. Eksen Aci: " + target_angle);
  }

  public static void yavuzkalposman5 (double target_angle){
    joint5Motor.set(PID.pid5(1, 0.008, 0.3, 0.5, target_angle)); // pid ( tolerans, kP, kI, kD, hedef açı )
    System.out.println("5. Eksen Aci: " + target_angle);
  }

  public static void yavuzkalposman6 (double target_angle){
    joint6Motor.set(PID.pid6(2, 0.0004, 0.3, 0.1, target_angle)); // pid ( tolerans, kP, kI, kD, hedef açı )
    System.out.println("6. Eksen Aci: " + target_angle);
  }

  public static void yavuzkalposman7 (double target_angle){
    joint7Motor.set(PID.pid7(0.5, 0.1, 0.3, 0.5, target_angle)); // pid ( tolerans, kP, kI, kD, hedef açı )
    System.out.println("7. Eksen Aci: " + target_angle);
  }

    // if(frc.robot.sensors.Encoder.arm2encoder()-0.5 < target_angle  && target_angle < frc.robot.sensors.Encoder.arm2encoder()+0.5){
    //   joint2Motor.set(0);   
    // }
    // else if(target_angle < frc.robot.sensors.Encoder.arm2encoder()-0.5)
    // {
    //   while(target_angle <= frc.robot.sensors.Encoder.arm2encoder())
    //   {
    //    joint2Motor.set(0.2);
    //   //  System.out.println(frc.robot.sensors.Encoder.arm2encoder());
    //   }
    // }
    // else if(target_angle > frc.robot.sensors.Encoder.arm2encoder()+0.5)
    // {
    //   while(target_angle >= frc.robot.sensors.Encoder.arm2encoder())
    //   {
      //  joint2Motor.set(-0.2);
    //   }
    // }


  public void roboticarm(){
    // System.out.println(Robot.m_oi.logitech.getRawAxis(1));

    
    //joint1Motor.set(ControlMode.Position, Robot.m_oi.logitech.getRawAxis(1)*1024*100);

    if(Robot.m_oi.logitech.getRawButton(1) && (Robot.m_oi.logitech.getRawAxis(0) > 0.008 || Robot.m_oi.logitech.getRawAxis(0) < -0.008)){
      joint1Motor.set( Robot.m_oi.logitech.getRawAxis(0)/2);
      joint2Motor.set(0);
      joint3Motor.set(0);
      joint4Motor.set(0);
      joint5Motor.set(0);
      joint6Motor.set(0);
      joint7Motor.set(0);
      System.out.println("1.Encoder konumu: " + -Encoder.arm1encoder());
    }
    else if(Robot.m_oi.logitech.getRawButton(2) && (Robot.m_oi.logitech.getRawAxis(1) > 0.008 || Robot.m_oi.logitech.getRawAxis(1) < -0.008)){
      joint2Motor.set( -Robot.m_oi.logitech.getRawAxis(1));
      joint1Motor.set(0);
      joint3Motor.set(0);
      joint4Motor.set(0);
      joint5Motor.set(0);
      joint6Motor.set(0);
      joint7Motor.set(0);
      System.out.println("2.Encoder konumu: " + Encoder.arm2encoder());
    }
    else if(Robot.m_oi.logitech.getRawButton(3) && (Robot.m_oi.logitech.getRawAxis(1) > 0.008 || Robot.m_oi.logitech.getRawAxis(1) < -0.008)){
      joint3Motor.set( Robot.m_oi.logitech.getRawAxis(1));
      joint2Motor.set(0);
      joint1Motor.set(0);
      joint4Motor.set(0);
      joint5Motor.set(0);
      joint6Motor.set(0);
      joint7Motor.set(0);
      System.out.println("3.Encoder konumu: " + Encoder.arm3encoder());
    }

    else if(Robot.m_oi.logitech.getRawButton(4) && (Robot.m_oi.logitech.getRawAxis(1) > 0.008 || Robot.m_oi.logitech.getRawAxis(1) < -0.008)){
      joint4Motor.set(-Robot.m_oi.logitech.getRawAxis(1)/2);
      joint2Motor.set(0);
      joint3Motor.set(0);
      joint1Motor.set(0);
      joint5Motor.set(0);
      joint6Motor.set(0);
      joint7Motor.set(0);
      System.out.println("4.Encoder konumu: " + Encoder.arm4encoder());
    }
    else if(Robot.m_oi.logitech.getRawButton(5) && (Robot.m_oi.logitech.getRawAxis(1) > 0.008 || Robot.m_oi.logitech.getRawAxis(1) < -0.008)){
      joint5Motor.set( Robot.m_oi.logitech.getRawAxis(1)/3);
      joint2Motor.set(0);
      joint3Motor.set(0);
      joint4Motor.set(0);
      joint1Motor.set(0);
      joint6Motor.set(0);
      joint7Motor.set(0);
      System.out.println("5.Encoder konumu: " + Encoder.arm5encoder());
    }
     
    else if(Robot.m_oi.logitech.getRawButton(6) && (Robot.m_oi.logitech.getRawAxis(1) > 0.008 || Robot.m_oi.logitech.getRawAxis(1) < -0.008)){
      joint6Motor.set( Robot.m_oi.logitech.getRawAxis(1)/2);
      joint2Motor.set(0);
      joint3Motor.set(0);
      joint4Motor.set(0);
      joint5Motor.set(0);
      joint1Motor.set(0);
      joint7Motor.set(0);
      System.out.println("6.Encoder konumu: " + -Encoder.arm6encoder());
    }

    else if(Robot.m_oi.logitech.getRawButton(10) && (Robot.m_oi.logitech.getRawAxis(1) > 0.008 || Robot.m_oi.logitech.getRawAxis(1) < -0.008)){
      joint7Motor.set(Robot.m_oi.logitech.getRawAxis(1)/5);
      joint2Motor.set(0);
      joint3Motor.set(0);
      joint4Motor.set(0);
      joint5Motor.set(0);
      joint6Motor.set(0);
      joint1Motor.set(0);
      System.out.println("7.Encoder konumu: " + Encoder.arm7encoder());
    }else{
      joint1Motor.set(0);
      joint2Motor.set(0);
      joint3Motor.set(0);
      joint4Motor.set(0);
      joint5Motor.set(0);
      joint6Motor.set(0);
      joint7Motor.set(0);
    }
    
  }
}