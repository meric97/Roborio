package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Robot;
import frc.robot.sensors.serialComWorking;
import edu.wpi.first.wpilibj.Timer;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import java.util.*;

/**
 * Add your docs here.
 */
public class Science extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static serialComWorking workingSerialCom;
  public static String ros_arm_string;
  public static WPI_TalonSRX augers;
  public static WPI_TalonSRX lama;
  public static WPI_TalonSRX vidalimil;
  public static WPI_VictorSPX peristaltic;
  public static WPI_VictorSPX lineer;
  public static int check = 1;
  public static Timer timer;
  public static double time;
  public static double old_time = time;
  public static int i=0;
  public static int a=0;
  public static int b=0;

  public Science() {
    timer = new Timer();

    augers = new WPI_TalonSRX(12);
    
    lama = new WPI_TalonSRX(14);
    
    vidalimil = new WPI_TalonSRX(13);

    peristaltic = new WPI_VictorSPX(16);

    lineer = new WPI_VictorSPX(15);
    
    timer.start();
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void science_ros(String science_str){
    String[] science = science_str.split(",");
   
    char[] augers_ros = science[0].toCharArray();
    char[] lama_ros =science[1].toCharArray();
    char[] vidalimil_ros = science[2].toCharArray();

    int augers_final = 1000*Character.getNumericValue(augers_ros[0])+ 100*Character.getNumericValue(augers_ros[1])+ 10*Character.getNumericValue(augers_ros[2])+Character.getNumericValue(augers_ros[3]);
    int lama_final =  1000*Character.getNumericValue(lama_ros[0])+ 100*Character.getNumericValue(lama_ros[1])+ 10*Character.getNumericValue(lama_ros[2])+Character.getNumericValue(lama_ros[3]);     
    int vidalimil_final = 1000*Character.getNumericValue(vidalimil_ros[0])+ 100*Character.getNumericValue(vidalimil_ros[1])+ 10*Character.getNumericValue(vidalimil_ros[2])+Character.getNumericValue(vidalimil_ros[3]);             

  }

  public void science(){

    if( Robot.m_oi.logitech.getRawButtonPressed(1) == true){
        check = 3;    
    }else if(  Robot.m_oi.logitech.getRawButtonPressed(2) == true ){
        check = 2;
    } else if( Robot.m_oi.logitech.getRawButtonPressed(4) == true){
        check = 1;
    }else if( Robot.m_oi.logitech.getRawButtonPressed(3) == true){
        check = 4;
    }else if(Robot.m_oi.logitech.getRawButtonPressed(5) == true){
        check = 5;
    }else if(Robot.m_oi.logitech.getRawButtonPressed(6) == true){
      check = 6;
    }

    System.out.println(check);

    if((Robot.m_oi.logitech.getRawAxis(3) > 0.008 || Robot.m_oi.logitech.getRawAxis(3) < -0.008)){
      lineer.set(Robot.m_oi.logitech.getRawAxis(3));
    }else if((Robot.m_oi.logitech.getRawAxis(2) > 0.008 || Robot.m_oi.logitech.getRawAxis(2) < -0.008)){
      lineer.set(-Robot.m_oi.logitech.getRawAxis(2));
    }else{
      lineer.set(0);
    }
    if(check == 4){
      System.out.println("augerler ve vidalı mil- lineer");

      if((Robot.m_oi.logitech.getRawAxis(5) > 0.008 || Robot.m_oi.logitech.getRawAxis(5) < -0.008) || (Robot.m_oi.logitech.getRawAxis(1) > 0.008 || Robot.m_oi.logitech.getRawAxis(1) < -0.008)){
          augers.set(Robot.m_oi.logitech.getRawAxis(5));
          lama.set(0);
          vidalimil.set(-Robot.m_oi.logitech.getRawAxis(1));
          peristaltic.set(0);

        }
      else{
        augers.set(0);
        lama.set(0);
        vidalimil.set(0);
        peristaltic.set(0);

      }  
    }

    else if(check == 2 ){
      System.out.println("lama");

      if(Robot.m_oi.logitech.getRawAxis(1) > 0.008 || Robot.m_oi.logitech.getRawAxis(1) < -0.008){
        lama.set( Robot.m_oi.logitech.getRawAxis(1)/10);
        augers.set(0);
        vidalimil.set(0);
        peristaltic.set(0);

      }
        else{
          augers.set(0);
          lama.set(0);
          vidalimil.set(0);
          peristaltic.set(0);

        }
      }
    else if(check == 3){
      System.out.println("vidalı mil");

      if(Robot.m_oi.logitech.getRawAxis(1) > 0.008 || Robot.m_oi.logitech.getRawAxis(1) < -0.008){
        vidalimil.set(- Robot.m_oi.logitech.getRawAxis(1));
        lama.set(0);
        augers.set(0);
        peristaltic.set(0);
      }
      else{
        augers.set(0);
        lama.set(0);
        vidalimil.set(0);
        peristaltic.set(0);

      }
      }
    // else if(check == 4 && (Robot.m_oi.logitech.getRawAxis(1) > 0.008 || Robot.m_oi.logitech.getRawAxis(1) < -0.008)){
    //   vidalimil.set( Robot.m_oi.logitech.getRawAxis(1)/9);
    //   lama.set(0);
    //   augers.set(1);
    //   System.out.println("d");
    // }
    else if(check == 5){
      System.out.println("peristaltic");
      
      augers.set(0);
      lama.set(0);
      vidalimil.set(0);
      // if((Robot.m_oi.logitech.getRawAxis(2)>0.008)&&(Robot.m_oi.logitech.getRawAxis(2)<-0.008)){
      // // if(timer.hasPeriodPassed(0.5)){
      // //   peristaltic.set(-1); 
      // // }else{
      // //   peristaltic.set(0); 
      // //   check = 1;
      // // }
      //  for(i=0;i<1000;i++){
      //     a++;
      //   }
      //   if(a<999){
      //     lineer.set(Robot.m_oi.logitech.getRawAxis(2));
      //   }else{
      //     lineer.set(0);
      //   }
      // }
      
      // else if((Robot.m_oi.logitech.getRawAxis(3)>0.008)&&(Robot.m_oi.logitech.getRawAxis(3)<-0.008)){
      //   for(i=0;i<1000;i++){
      //     b++;
      //   }
      //   if(b<999){
      //     lineer.set(-Robot.m_oi.logitech.getRawAxis(3));
      //   }else{
      //     lineer.set(0);
      //   }

      // while(timer.hasPeriodPassed(1) == false){
      // peristaltic.set(1);  }
      // if(timer.hasPeriodPassed(1)){
      if((Robot.m_oi.logitech.getRawAxis(4) >0.1 || Robot.m_oi.logitech.getRawAxis(4) <-0.1)){
       peristaltic.set(Robot.m_oi.logitech.getRawAxis(4)/2);
        // // System.out.println(time);
      }
        // }
       // if(time-old_time>10){
       //   check = 1;
      else{
        peristaltic.set(0);
      }
    }
    else if(check == 1){
      augers.set(0);
      lama.set(0);
      vidalimil.set(0);
      peristaltic.set(0);
      lineer.set(0);

      System.out.println("steady");

    }
  
}
}
