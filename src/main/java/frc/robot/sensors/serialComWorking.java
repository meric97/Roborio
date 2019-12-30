/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.sensors;

import edu.wpi.first.wpilibj.SerialPort;

/**
 * Add your docs here.
 */
public class serialComWorking {
	public static String ros_string;
	public static String[] message_array = new String[13];
	public static String drive_system_str;
	public static String robotic_arm_str;
	public static String science_str;
	public static String alt_yurur;
	public static String robot_kol;
	public static String bilim;
	public static String returnlenecek;
	public static String buff;
	public static int value;
	public static String string;

    public static SerialPort USBDevice =  new SerialPort(115200 ,SerialPort.Port.kUSB); // USB needs to be changed
	public static String receivedData;
	public static String control = "";
	public static String message = "";

	public String read() {
		USBDevice.flush();

		receivedData =  USBDevice.readString(54); 
		int length = receivedData.length();
		char[] charData = receivedData.toCharArray();
		
		for (int i = 0; i < length; i++) {
			if (charData[i] == 'S'){
				if (charData[i+53] == 'F'){
					for (int j = i + 1; j < i + 53; j++){
						if (Character.isDigit(charData[j])){
							control += charData[j];
						}
					}
				}
				if (control.length() == 52){
					message = control;
				}
			}
			control = "";
		}
		return message;
	}
	
	public void write(String message) {
		
        USBDevice.writeString(message);
	}
	
	public String StringConverter(String string, int sistem){

	// 	// 1 ==> alt yürür, 2 ==> robot kol, 3 ==> bilim
	// 	for (var i = 0; i < 13; i++) {

	// 		buff = string.substring(4*i,4*i+4);
	// 		// System.out.println(buff);
	// 		message_array[i] = buff;
	// 	}
	// 	alt_yurur = message_array[0] + "," + message_array[1];
	// 	robot_kol = message_array[2] + "," + message_array[3] + "," + message_array[4] + "," + message_array[5] + "," + message_array[6] + "," + message_array[7] + "," + message_array[8];
	// 	bilim = message_array[9] + "," + message_array[10] + "," + message_array[11] + "," + message_array[12];
		
	// 	if(sistem == 1){
	// 		returnlenecek = alt_yurur;
	// 	}else if(sistem == 2){
	// 		returnlenecek = robot_kol;
	// 	}else if(sistem == 3){
	// 		returnlenecek = bilim;
	// 	}
			
	// 	return returnlenecek;
	//   }
		// 1 ==> alt yürür, 2 ==> robot kol, 3 ==> bilim
		alt_yurur = string.substring(0,4) + "," + string.substring(4,8);
		robot_kol = string.substring(8,12) + "," + string.substring(12,16) + "," + string.substring(16,20) + "," + string.substring(20,24) + "," +string.substring(24,28) + "," + string.substring(28,32) + ","+string.substring(32,36);
		bilim = string.substring(36,40) + "," + string.substring(40,44) + "," + string.substring(44,48) + "," + string.substring(48,52);

		if(sistem == 1){
			returnlenecek = alt_yurur;
		}else if(sistem == 2){
			returnlenecek = robot_kol;
		}else if(sistem == 3){
			returnlenecek = bilim;
		}
			
		return returnlenecek;
	}
		
	public String floattosString(double joint){
			if( joint<0){
				value = (int)((-1)*joint);
	
				if (value<10){
					string = "000"+Integer.toString(value);
				}
				else if(value< 100 && value > 9){
					string = "00"+Integer.toString(value);
				}
				else{
					string = "0"+Integer.toString(value);
				}
			}
			else if(joint>0){
				value= (int) joint;
					if (value<10){
							string = "100"+Integer.toString(value);
						}
					else if(value < 100 && value > 9){
							string = "10"+Integer.toString(value);
						}
					else{
							string = "1"+Integer.toString(value);
						}
					}
				
			else{
				string = "00000000";
			}

					
			return string;
		}
}