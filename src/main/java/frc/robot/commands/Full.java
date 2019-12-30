package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.*;

public class Full{

    public static int mode= 1; 
    public static String alt_yurur;
    public static String robot_kol;
    public static String ros_string;
    public static String yavuz;
    public static String yavuz2;


    public static void Full(String robot_kol){

        // ros_string = Robot.workingSerialCom.read();

        // yavuz = Robot.workingSerialCom.StringConverter(ros_string, 1);
        // yavuz2 = Robot.workingSerialCom.StringConverter(ros_string, 2);

        if(Robot.m_oi.logitech.getRawButton(7)){
            mode = 1;
        }else if(Robot.m_oi.logitech.getRawButton(7) && Robot.m_oi.logitech.getRawButton(8)){
            mode = 2;
        }
        else if(Robot.m_oi.logitech.getRawButton(8)){
            mode = 3;
        }

        System.out.println(mode);

        if(mode == 1){

            // Robot.m_driveTrain.run(alt_yurur);
            Robot.m_driveTrain.driveBase();
            System.out.println("alt yürür");

        }else if(mode == 2 ){
            Robot.m_driveTrain.driveTrainLeftFrontMotor.set(0);
            Robot.m_driveTrain.driveTrainRightFrontMotor.set(0);
            Robot.m_driveTrain.driveTrainLeftRearMotor.set(0);
            Robot.m_driveTrain.driveTrainRightRearMotor.set(0);
            Robot.inverse.Inverse(robot_kol);
            System.out.println("robot kol");

        }
        else if(mode == 3){
            Robot.m_driveTrain.driveTrainLeftFrontMotor.set(0);
            Robot.m_driveTrain.driveTrainRightFrontMotor.set(0);
            Robot.m_driveTrain.driveTrainLeftRearMotor.set(0);
            Robot.m_driveTrain.driveTrainRightRearMotor.set(0);
            Robot.Science.science();
            System.out.println("bilim");
        }
    }

//     public static void Full2(String alt_yurur, String robot_kol){

// }
}