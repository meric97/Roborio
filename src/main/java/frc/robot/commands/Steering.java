package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.WPI_MotorSafetyImplem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import java.lang.*;
import edu.wpi.first.wpilibj.RobotState;
import frc.robot.Robot;
import frc.robot.commands.JoystickDrive;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class Steering extends Subsystem
{
    public static double angle;
    public static double length;
    public static double L;
    public static double H;
    public static double B;
    public static double arac_length = 1.4; //metre
    public static double teker_arasi = 0.93; //metre
    public static double joy = Robot.m_oi.logitech.getRawAxis(0)*50;
    public static double donme_radius = (1/Math.tan(joy))*arac_length;
    public Steering(){
    }

    @Override

    protected void initDefaultCommand() {
        
    }

    public static double ackermannLeft(){
        angle = Math.atan(arac_length/(donme_radius-teker_arasi/2));
        return angle;
    }

    public static double ackermannRight(){
        angle = Math.atan(arac_length/(donme_radius+teker_arasi/2));

        return angle;
    }

    public static double angletolength(double angle){
        length = Math.sqrt((L-H*Math.cos(angle))*(L-H*Math.cos(angle))+(H*Math.sin(angle)-B)*(H*Math.sin(angle)-B));
        return length ;
    }






}