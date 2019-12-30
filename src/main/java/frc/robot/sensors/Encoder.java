package frc.robot.sensors;

import frc.robot.Robot;

public class Encoder {
    public static double encoder1_round;
    public static double encoder2_round;
    public static double encoder3_round;
    public static double encoder4_round;
    public static double encoder5_round;
    public static double encoder6_round;
    public static double encoder7_round;
    public static double Left_Encoder_Position;
    public static double targetPosition = 500;
    public static double Right_Encoder_Position;
    public static double Perimeter = 48;
    // public static double RoundNumber = targetPosition/Perimeter;
    public static double RoundNumber = 0;
    public static double encoderValue;
    public static double encoderRound;
    public static double encoderPosition;
    public static double encoderZeroValue;
    public static double old_encoder = 0;
    public static int encoder_rpm=0;
    public static double armencoder1value;
    public static double armencoder2value;
    public static double armencoder3value;
    public static double armencoder4value;
    public static double armencoder5value;
    public static double armencoder6value;
    public static double armencoder7value;
    public static double encoder1value;
    public static double encoder2value;
    public static double encoder3value;
    public static double encoder4value;
    public static double encoder5value;
    public static double encoder6value;
    public static double encoder7value;
    public static double old_encoder1 = 0;
    public static double old_encoder2;
    public static double old_encoder3;
    public static double old_encoder4;
    public static double old_encoder5;
    public static double old_encoder6;
    public static double old_encoder7;
    public static double encoder1_rpm;
    public static float encoder2_rpm;
    public static double encoder3_rpm;
    public static double encoder4_rpm;
    public static double encoder5_rpm;
    public static double encoder6_rpm;
    public static double encoder7_rpm;
    
    public Encoder() {
        // Robot.m_driveTrain.driveTrainRightRearMotor.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 1);
        // Robot.m_driveTrain.driveTrainRightRearMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        // Robot.m_driveTrain.driveTrainRightRearMotor.setSelectedSensorPosition(0);
        // Robot.m_driveTrain.driveTrainRightRearMotor.setSensorPhase(true);
      
        // Robot.m_driveTrain.driveTrainRightFrontMotor.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 1);
        // Robot.m_driveTrain.driveTrainRightFrontMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        // Robot.m_driveTrain.driveTrainRightFrontMotor.setSelectedSensorPosition(0);
        // Robot.m_driveTrain.driveTrainRightFrontMotor.setSensorPhase(true);
        

        // Robot.m_driveTrain.driveTrainLeftRearMotor.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 1);
        // Robot.m_driveTrain.driveTrainLeftRearMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        // Robot.m_driveTrain.driveTrainLeftRearMotor.setSelectedSensorPosition(0);
        // Robot.m_driveTrain.driveTrainLeftRearMotor.setSensorPhase(true);

        // Robot.m_driveTrain.driveTrainLeftFrontMotor.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 1);
        // Robot.m_driveTrain.driveTrainLeftFrontMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        // Robot.m_driveTrain.driveTrainLeftFrontMotor.setSelectedSensorPosition(0);
        
        // Robot.RoboticArm.joint1Motor.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 1);
        // Robot.RoboticArm.joint1Motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        // Robot.RoboticArm.joint1Motor.setSelectedSensorPosition(0);
        
        // Robot.RoboticArm.joint2Motor.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 1);
        // Robot.RoboticArm.joint2Motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        // Robot.RoboticArm.joint2Motor.setSelectedSensorPosition(0);

        // Robot.RoboticArm.joint3Motor.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 1);
        // Robot.RoboticArm.joint3Motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        // Robot.RoboticArm.joint3Motor.setSelectedSensorPosition(0);

        // Robot.RoboticArm.joint4Motor.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 1);
        // Robot.RoboticArm.joint4Motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        // Robot.RoboticArm.joint4Motor.setSelectedSensorPosition(0);

        // Robot.RoboticArm.joint5Motor.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 1);
        // Robot.RoboticArm.joint5Motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        // Robot.RoboticArm.joint5Motor.setSelectedSensorPosition(0);

        // Robot.RoboticArm.joint6Motor.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 1);
        // Robot.RoboticArm.joint6Motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        // Robot.RoboticArm.joint6Motor.setSelectedSensorPosition(0);

        // Robot.RoboticArm.joint7Motor.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 1);
        // Robot.RoboticArm.joint7Motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        // Robot.RoboticArm.joint7Motor.setSelectedSensorPosition(0); 
    }

    public static double getEncoderVelocityRightFront()
    {
        encoderValue = (Robot.m_driveTrain.driveTrainRightFrontMotor.getSelectedSensorPosition());
        encoderRound = encoderValue/1024;
        if(encoderRound - old_encoder/1024 != 0 ){
         encoder_rpm= (int) ( encoderRound * 100 - (old_encoder / 1024) * 100);
         old_encoder = encoderValue;
        }
        return encoder_rpm*0.06;
    }

    public static double getEncoderVelocityLeftRear()
    {
        encoderValue = (Robot.m_driveTrain.driveTrainLeftRearMotor.getSelectedSensorPosition());
        encoderRound = encoderValue/1024;
        if(encoderRound - old_encoder/1024 != 0 ){
         encoder_rpm= (int) ( encoderRound * 100 - (old_encoder / 1024) * 100);
         old_encoder = encoderValue;
        }
        return encoder_rpm*0.06;
    }

    public static double getEncoderVelocityLeftFront()
    {
        encoderValue = (Robot.m_driveTrain.driveTrainLeftFrontMotor.getSelectedSensorPosition());
        encoderRound = encoderValue/1024;
        if(encoderRound - old_encoder/1024 != 0 ){
         encoder_rpm= (int) ( encoderRound * 100 - (old_encoder / 1024) * 100);
         old_encoder = encoderValue;
        }
        return encoder_rpm*0.06;
    }

    public static double getEncoderVelocityRightRear()
    {
        encoderValue = (Robot.m_driveTrain.driveTrainRightRearMotor.getSelectedSensorPosition());
        encoderRound = encoderValue/1024;
        if(encoderRound - old_encoder/1024 != 0 ){
         encoder_rpm= (int) ( encoderRound * 100 - (old_encoder / 1024) * 100);
         old_encoder = encoderValue;
        }
        return encoder_rpm*0.06;
    }

    // public static double getEncoderVelocity() {
    //    encoderValue = (Robot.m_driveTrain.driveTrainRightRearMotor.getSelectedSensorPosition()+ Robot.m_driveTrain.driveTrainRightFrontMotor.getSelectedSensorPosition())/2;
    //    encoderRound = encoderValue/1024;
    //    if(encoderRound - old_encoder/1024 != 0 ){
    //     encoder_rpm= (int) ( encoderRound * 100 - (old_encoder / 1024) * 100);
    //     old_encoder = encoderValue;
    //    }
    //   return encoder_rpm*0.06;//encoderPosition-encoderZeroValue;

    //  }

    // public static void zeroEncoder() {
    //     encoderValue = ( Robot.m_driveTrain.driveTrainRightRearMotor.getSelectedSensorPosition());//+ Robot.m_driveTrain.driveTrainLeftRearMotor.getSelectedSensorPosition())/2;
    //     encoderRound = encoderValue/4100;
    //     encoderPosition = encoderRound*2*Math.PI*15.24;
    //     encoderZeroValue = encoderPosition;
    // }
    public static double rigthrearencoder(){
        armencoder1value = Robot.m_driveTrain.driveTrainRightRearMotor.getSelectedSensorVelocity();
    //     encoder1value = (armencoder1value/4096)*360;
    //     // if(encoder1value - old_encoder1 != 0){
    //     //     encoder1_rpm = (int)(encoder1value*100 -(old_encoder1 / 4096) * 100);
    //     //     old_encoder1 = encoder1value;
    //     // }
        encoder1_round = (armencoder2value*90)/75000;
        return encoder1_round;
    }
 
 
    public static double arm1encoder(){
        armencoder1value = Robot.RoboticArm.joint1Motor.getSelectedSensorPosition();
    //     encoder1value = (armencoder1value/4096)*360;
    //     // if(encoder1value - old_encoder1 != 0){
    //     //     encoder1_rpm = (int)(encoder1value*100 -(old_encoder1 / 4096) * 100);
    //     //     old_encoder1 = encoder1value;
    //     // }
        encoder1_round = (armencoder1value*90)/75000;
        return encoder1_round;
    }
    public static double arm2encoder(){
        armencoder2value = Robot.RoboticArm.joint2Motor.getSelectedSensorPosition();
       // encoder2_round = armencoder2value*13.2/(4096*32*75);
        //encoder2value = (armencoder2value*13.2/(4096*32*75) - (int)encoder2_round)*360;
        encoder2_round = (armencoder2value*90)/75000;
        
        // if(encoder2value - old_encoder2 != 0){
        //     encoder2_rpm = (int)(encoder2value*32*75 -(old_encoder2 / 4096 * 32*75));
        //     old_encoder2 = encoder2value;
        // }
        return encoder2_round ;
    }

    
    public static double arm3encoder(){
        armencoder3value = Robot.RoboticArm.joint3Motor.getSelectedSensorPosition();
    //     encoder3value = armencoder3value/4096;
    //     if(encoder3value - old_encoder3 != 0){
    //         encoder3_rpm = (int)(encoder3value*100 -(old_encoder3 / 4096) * 100);
    //         old_encoder3 = encoder3value;
    //     }
        encoder3_round = (armencoder3value*360)/225342;
        return encoder3_round;
    }
    public static double arm4encoder(){
        armencoder4value = Robot.RoboticArm.joint4Motor.getSelectedSensorPosition();
    //     encoder3value = armencoder3value/4096;
    //     if(encoder3value - old_encoder3 != 0){
    //         encoder3_rpm = (int)(encoder3value*100 -(old_encoder3 / 4096) * 100);
    //         old_encoder3 = encoder3value;
    //     }
        encoder4_round = (armencoder4value*360)/225342;
        return encoder4_round;
     }
    public static double arm5encoder(){
        armencoder5value = Robot.RoboticArm.joint5Motor.getSelectedSensorPosition();
    //     encoder5value = armencoder5value/4096;
    //     if(encoder5value - old_encoder5 != 0){
    //         encoder5_rpm = (int)(encoder5value*100 -(old_encoder5 / 4096) * 100);
    //         old_encoder5 = encoder5value;
    //     }
        encoder5_round = (armencoder5value*360)/225342;
        return encoder5_round;
    }
    public static double arm6encoder(){
        armencoder6value = Robot.RoboticArm.joint6Motor.getSelectedSensorPosition();
    //     encoder6value = armencoder6value/4096;
    //     if(encoder6value - old_encoder6 != 0){
    //         encoder6_rpm = (int)(encoder3value*100 -(old_encoder6 / 4096) * 100);
    //         old_encoder6 = encoder6value;
    //     }
        encoder6_round = (armencoder6value*360)/225342;
        return encoder6_round;
    }

    public static double arm7encoder(){
        armencoder7value = Robot.RoboticArm.joint7Motor.getSelectedSensorPosition();
    //     encoder7value = armencoder7value/4096;
    //     if(encoder7value - old_encoder7 != 0){
    //         encoder7_rpm = (int)(encoder7value*100 -(old_encoder7 / 4096) * 100);
    //         old_encoder7 = encoder7value;
    //     }
        encoder7_round = (armencoder7value*360)/225342;
        return encoder7_round;
    }
}