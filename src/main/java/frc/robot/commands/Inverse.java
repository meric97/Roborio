package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.sensors.Encoder;
import frc.robot.subsystems.RoboticArm;


public class Inverse {

    public static int durum;
    public static int check= 1;
    public static int  target = 0;
    public static void Inverse(String robotic_arm_string){

     if( Robot.m_oi.logitech.getPOV(0) == 0){
        check = 1;    
     }else if(  Robot.m_oi.logitech.getPOV(0) == 90 ){
        check = 2;
     } else if( Robot.m_oi.logitech.getPOV(0) == 180){
        check = 3;
     }else if( Robot.m_oi.logitech.getPOV(0) == 270){
        check = 4;
     }

     if(Robot.m_oi.logitech.getRawButton(9)){
         target = target+1;
     }else if(Robot.m_oi.logitech.getRawButton(10)){
         target = target-1;
     }
     System.out.println(target);
        if(check == 1){
            System.out.println("Kalibrasyon");
            Robot.RoboticArm.roboticarm();
                                
        }else if(check == 2){
            System.out.println("Sıfırlama");
            RoboticArm.joint1Motor.setSelectedSensorPosition(0);
            RoboticArm.joint2Motor.setSelectedSensorPosition(0);
            RoboticArm.joint3Motor.setSelectedSensorPosition(0);
            RoboticArm.joint4Motor.setSelectedSensorPosition(0);
            RoboticArm.joint5Motor.setSelectedSensorPosition(0);
            RoboticArm.joint6Motor.setSelectedSensorPosition(0);
            RoboticArm.joint7Motor.setSelectedSensorPosition(0);

            System.out.println("1.Encoder konumu: " + Encoder.arm1encoder());
            System.out.println("2.Encoder konumu: " + Encoder.arm2encoder());
            System.out.println("3.Encoder konumu: " + Encoder.arm3encoder());
            System.out.println("4.Encoder konumu: " + Encoder.arm4encoder());
            System.out.println("5.Encoder konumu: " + Encoder.arm5encoder());
            System.out.println("6.Encoder konumu: " + Encoder.arm6encoder());
            System.out.println("7.Encoder konumu: " + Encoder.arm7encoder());

        }

        else if( check == 3){
            System.out.println("PID Elektronik");

            
            if(Robot.m_oi.logitech.getRawButton(1)){
                RoboticArm.yavuzkalposman1(target);
                RoboticArm.joint2Motor.set(0);
                RoboticArm.joint3Motor.set(0);
                RoboticArm.joint4Motor.set(0);
                RoboticArm.joint5Motor.set(0);
                RoboticArm.joint6Motor.set(0);
                RoboticArm.joint7Motor.set(0);
                System.out.println("1.Encoder konumu: " + Encoder.arm1encoder());
            }
            else if(Robot.m_oi.logitech.getRawButton(2)){
                RoboticArm.yavuzkalposman2(target);
                RoboticArm.joint1Motor.set(0);
                RoboticArm.joint3Motor.set(0);
                RoboticArm.joint4Motor.set(0);
                RoboticArm.joint5Motor.set(0);
                RoboticArm.joint6Motor.set(0);
                RoboticArm.joint7Motor.set(0);
                System.out.println("2.Encoder konumu: " + Encoder.arm2encoder());
            }
            else if(Robot.m_oi.logitech.getRawButton(3)){
                RoboticArm.yavuzkalposman3(target);
                RoboticArm.joint2Motor.set(0);
                RoboticArm.joint1Motor.set(0);
                RoboticArm.joint4Motor.set(0);
                RoboticArm.joint5Motor.set(0);
                RoboticArm.joint6Motor.set(0);
                RoboticArm.joint7Motor.set(0);
                System.out.println("3.Encoder konumu: " + Encoder.arm3encoder());
            }
        
            else if(Robot.m_oi.logitech.getRawButton(4)){
                RoboticArm.yavuzkalposman4(target);
                RoboticArm.joint2Motor.set(0);
                RoboticArm.joint3Motor.set(0);
                RoboticArm.joint1Motor.set(0);
                RoboticArm.joint5Motor.set(0);
                RoboticArm.joint6Motor.set(0);
                RoboticArm.joint7Motor.set(0);
                System.out.println("4.Encoder konumu: " + Encoder.arm4encoder());
            }
            else if(Robot.m_oi.logitech.getRawButton(5)){
                RoboticArm.yavuzkalposman5(target);
                RoboticArm.joint2Motor.set(0);
                RoboticArm.joint3Motor.set(0);
                RoboticArm.joint4Motor.set(0);
                RoboticArm.joint1Motor.set(0);
                RoboticArm.joint6Motor.set(0);
                RoboticArm.joint7Motor.set(0);
                System.out.println("5.Encoder konumu: " + Encoder.arm5encoder());
            }
            
            else if(Robot.m_oi.logitech.getRawButton(6)){
                RoboticArm.yavuzkalposman6(target);
                RoboticArm. joint2Motor.set(0);
                RoboticArm.joint3Motor.set(0);
                RoboticArm.joint4Motor.set(0);
                RoboticArm.joint5Motor.set(0);
                RoboticArm.joint1Motor.set(0);
                RoboticArm.joint7Motor.set(0);
                System.out.println("6.Encoder konumu: " + Encoder.arm6encoder());
            }
        
            else if(Robot.m_oi.logitech.getRawButton(8)){
                RoboticArm.yavuzkalposman7(target);
                RoboticArm.joint2Motor.set(0);
                RoboticArm.joint3Motor.set(0);
                RoboticArm.joint4Motor.set(0);
                RoboticArm.joint5Motor.set(0);
                RoboticArm.joint6Motor.set(0);
                RoboticArm.joint1Motor.set(0);
                System.out.println("7.Encoder konumu: " + Encoder.arm7encoder());
            }else{
                RoboticArm.joint1Motor.set(0);
                RoboticArm.joint2Motor.set(0);
                RoboticArm.joint3Motor.set(0);
                RoboticArm.joint4Motor.set(0);
                RoboticArm.joint5Motor.set(0);
                RoboticArm.joint6Motor.set(0);
                RoboticArm.joint7Motor.set(0);
            }
            // RoboticArm.yavuzkalposman1(Robot.m_oi.logitech.getRawAxis(0)*5);
            // System.out.println("1.Encoder konumu: " + Encoder.arm1encoder());

            // RoboticArm.yavuzkalposman2(10);
            // System.out.println("2.Encoder konumu: " + Encoder.arm2encoder());

            // // RoboticArm.yavuzkalposman3(10);
            // System.out.println("3.Encoder konumu: " + Encoder.arm3encoder());

            // // RoboticArm.yavuzkalposman4(10);
            // System.out.println("4.Encoder konumu: " + Encoder.arm4encoder());

            // // RoboticArm.yavuzkalposman5(10);
            // System.out.println("5.Encoder konumu: " + Encoder.arm5encoder());

            // // RoboticArm.yavuzkalposman6(10);
            // System.out.println("6.Encoder konumu: " + Encoder.arm6encoder());

            // // RoboticArm.yavuzkalposman7(10);
            // System.out.println("7.Encoder konumu: " + Encoder.arm7encoder());
        }
        // else if( check == 4){
        //     System.out.println("Inverse Kinematic");
        //     Robot.RoboticArm.run(robotic_arm_string);

        // }
    }

}