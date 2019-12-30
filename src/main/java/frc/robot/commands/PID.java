package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.WPI_MotorSafetyImplem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.RobotState;
import frc.robot.Robot;
import frc.robot.commands.JoystickDrive;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class PID extends Subsystem
{    
    double target;
    double current_rpm = 0;
    double rpm_error = target - current_rpm;
    double rpm_oldError = rpm_error;
    double power;
    double current_distance=0;
    double distance_error = target - current_distance;
    double distance_oldError=distance_error;
    double tolerance;
    double kP;
    double kI;
    double kD;
    boolean control;
    @Override

    protected void initDefaultCommand() {
        
    }
    public PID(){ 

    }
 
    public double pid1(double tolerance, double kP, double kI, double kD, double target ) {
  
        current_distance = -frc.robot.sensors.Encoder.arm1encoder();


        distance_error = target-current_distance;
    
        if( target-tolerance<current_distance && current_distance<target+tolerance){
            control = true;
        }else{
            control = false;
        }

        if(control == false){
            if ( distance_error < 0) 
                {
                power = -0.05 + (kP*distance_error) + (kI*(distance_error+distance_oldError)) + (kD*(distance_error-distance_oldError) );	
            }
            else 
            {
                power = 0.05 + (kP*distance_error) + (kI*(distance_error+distance_oldError)) + (kD*(distance_error-distance_oldError) );	
            }

            if(power > 1){
                power = 1;
            }
            else if(power < -1){
                power = -1;
            } 
        }else{
            power = 0;
        }
        System.out.println("Guc: " + power);
        System.out.println("Dist_Error: " + distance_error);
        return power*-1; //??
    }


    public double pid2(double tolerance, double kP, double kI, double kD, double target ) {
  
        current_distance = frc.robot.sensors.Encoder.arm2encoder();


        distance_error = target-current_distance;
    
        if( target-tolerance<current_distance && current_distance<target+tolerance){
            control = true;
        }else{
            control = false;
        }

        if(control == false){
            if ( distance_error < 0) 
                {
                power = -0.05 + (kP*distance_error) + (kI*(distance_error+distance_oldError)) + (kD*(distance_error-distance_oldError) );	
            }
            else 
            {
                power = 0.05 + (kP*distance_error) + (kI*(distance_error+distance_oldError)) + (kD*(distance_error-distance_oldError) );	
            }

            if(power > 1){
                power = 1;
            }
            else if(power < -1){
                power = -1;
            } 
        }else{
            power = 0;
        }
        System.out.println("Guc: " + power);
        System.out.println("Dist_Error: " + distance_error);
        return power*-1; 
    }


public double pid3(double tolerance, double kP, double kI, double kD, double target ) {
  
        current_distance = frc.robot.sensors.Encoder.arm3encoder();


        distance_error = target-current_distance;
    
        if( target-tolerance<current_distance && current_distance<target+tolerance){
            control = true;
        }else{
            control = false;
        }

        if(control == false){
            if ( distance_error < 0) 
                {
                power = -0.05 + (kP*distance_error) + (kI*(distance_error+distance_oldError)) + (kD*(distance_error-distance_oldError) );	
            }
            else 
            {
                power = 0.05 + (kP*distance_error) + (kI*(distance_error+distance_oldError)) + (kD*(distance_error-distance_oldError) );	
            }

            if(power > 1){
                power = 1;
            }
            else if(power < -1){
                power = -1;
            } 
        }else{
            power = 0;
        }
        System.out.println("Guc: " + power);
        System.out.println("Dist_Error: " + distance_error);
        return power*-1; 
    }


public double pid4(double tolerance, double kP, double kI, double kD, double target ) {
  
        current_distance = frc.robot.sensors.Encoder.arm4encoder();


        distance_error = target-current_distance;
    
        if( target-tolerance<current_distance && current_distance<target+tolerance){
            control = true;
        }else{
            control = false;
        }

        if(control == false){
            if ( distance_error < 0) 
                {
                power = -0.05 + (kP*distance_error) + (kI*(distance_error+distance_oldError)) + (kD*(distance_error-distance_oldError) );	
            }
            else 
            {
                power = 0.05 + (kP*distance_error) + (kI*(distance_error+distance_oldError)) + (kD*(distance_error-distance_oldError) );	
            }

            if(power > 1){
                power = 1;
            }
            else if(power < -1){
                power = -1;
            } 
        }else{
            power = 0;
        }
        System.out.println("Guc: " + power);
        System.out.println("Dist_Error: " + distance_error);
        return power*-1; //??
    }


public double pid5(double tolerance, double kP, double kI, double kD, double target ) {
  
        current_distance = frc.robot.sensors.Encoder.arm5encoder();


        distance_error = target-current_distance;
    
        if( target-tolerance<current_distance && current_distance<target+tolerance){
            control = true;
        }else{
            control = false;
        }

        if(control == false){
            if ( distance_error < 0) 
                {
                power = -0.05 + (kP*distance_error) + (kI*(distance_error+distance_oldError)) + (kD*(distance_error-distance_oldError) );	
            }
            else 
            {
                power = 0.05 + (kP*distance_error) + (kI*(distance_error+distance_oldError)) + (kD*(distance_error-distance_oldError) );	
            }

            if(power > 1){
                power = 1;
            }
            else if(power < -1){
                power = -1;
            } 
        }else{
            power = 0;
        }
        System.out.println("Guc: " + power);
        System.out.println("Dist_Error: " + distance_error);
        return power*-1; //??
    }


public double pid6(double tolerance, double kP, double kI, double kD, double target ) {
  
        current_distance = -frc.robot.sensors.Encoder.arm6encoder();


        distance_error = target-current_distance;
    
        if( target-tolerance<current_distance && current_distance<target+tolerance){
            control = true;
        }else{
            control = false;
        }

        if(control == false){
            if ( distance_error < 0) 
                {
                power = -0.05 + (kP*distance_error) + (kI*(distance_error+distance_oldError)) + (kD*(distance_error-distance_oldError) );	
            }
            else 
            {
                power = 0.05 + (kP*distance_error) + (kI*(distance_error+distance_oldError)) + (kD*(distance_error-distance_oldError) );	
            }

            if(power > 1){
                power = 1;
            }
            else if(power < -1){
                power = -1;
            } 
        }else{
            power = 0;
        }
        System.out.println("Guc: " + power);
        System.out.println("Dist_Error: " + distance_error);
        return power*-1; //??
    }


public double pid7(double tolerance, double kP, double kI, double kD, double target ) {
  
        current_distance = frc.robot.sensors.Encoder.arm7encoder();


        distance_error = target-current_distance;
    
        if( target-tolerance<current_distance && current_distance<target+tolerance){
            control = true;
        }else{
            control = false;
        }

        if(control == false){
            if ( distance_error < 0) 
                {
                power = -0.05 + (kP*distance_error) + (kI*(distance_error+distance_oldError)) + (kD*(distance_error-distance_oldError) );	
            }
            else 
            {
                power = 0.05 + (kP*distance_error) + (kI*(distance_error+distance_oldError)) + (kD*(distance_error-distance_oldError) );	
            }

            if(power > 1){
                power = 1;
            }
            else if(power < -1){
                power = -1;
            } 
        }else{
            power = 0;
        }
        System.out.println("Guc: " + power);
        System.out.println("Dist_Error: " + distance_error);
        return power*-1; //??
    }

public double RigthFrontPid( float tolerance,double current ,double kP, double kI, double kD, double target ) {
        
        current_rpm = current;

        rpm_error = target-current_rpm;

        if( target-tolerance<current_rpm && current_rpm<target+tolerance){
            control = true;
        }else{
            control = false;
        }


        if (rpm_error < 0) 
            {
            power = (kP*rpm_error) + (kI*(rpm_error+rpm_oldError)) + (kD*(rpm_error-rpm_oldError) );	
        }
        else 
        {
            power = (kP*rpm_error) + (kI*(rpm_error+rpm_oldError)) + (kD*(rpm_error-rpm_oldError) );	
        }

        if(power > 0.5){
            power = 0.5;
        }
        else if(power < -0.5){
            power = -0.5;
        } 

        System.out.println(power);
                
        return power; //??
}
// public double RigthRearPid( float tolerance,double current ,double kP, double kI, double kD, double target ) {

// }

}




