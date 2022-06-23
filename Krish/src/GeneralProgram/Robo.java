package GeneralProgram;

import java.awt.AWTException; 
import java.awt.Robot; 
import java.awt.event.KeyEvent; 
import java.io.*; 

public class Robo 
{ 
	public static void main(String[] args) throws IOException, 
	AWTException, InterruptedException 
	{ 
		String command = "notepad.exe"; 
		Runtime run = Runtime.getRuntime(); 
		run.exec(command); 
		try { 
			Thread.sleep(2000); 
		} 
		catch (InterruptedException e) 
		{ 
			e.printStackTrace(); 
		} 

		// Create an instance of Robot class 
		Robot robot = new Robot(); 

		// Press keys using robot. A gap of 
		// of 500 mili seconds is added after 
		// every key press 
		robot.keyPress(KeyEvent.VK_B); 
		Thread.sleep(500); 
		robot.keyPress(KeyEvent.VK_H); 
		Thread.sleep(500); 
		robot.keyPress(KeyEvent.VK_U); 
		Thread.sleep(500); 
		robot.keyPress(KeyEvent.VK_C); 
		Thread.sleep(500); 
		robot.keyPress(KeyEvent.VK_H); 
		Thread.sleep(500); 
		robot.keyPress(KeyEvent.VK_U); 
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_SPACE); 
        Thread.sleep(500); 
		robot.keyPress(KeyEvent.VK_L); 
		Thread.sleep(500); 
		robot.keyPress(KeyEvent.VK_O); 
		Thread.sleep(500); 
		robot.keyPress(KeyEvent.VK_V); 
		Thread.sleep(500); 
		robot.keyPress(KeyEvent.VK_E); 
		Thread.sleep(500); 
		robot.keyPress(KeyEvent.VK_SPACE); 
        Thread.sleep(500); 
		robot.keyPress(KeyEvent.VK_Y); 
		Thread.sleep(500); 
		robot.keyPress(KeyEvent.VK_O); 
		Thread.sleep(500); 
		robot.keyPress(KeyEvent.VK_U); 
//		Thread.sleep(500); 
//		robot.keyPress(KeyEvent.VK_E); 
//		Thread.sleep(500); 
//		robot.keyPress(KeyEvent.VK_K); 
//		Thread.sleep(500); 
//		robot.keyPress(KeyEvent.VK_S); 
//		Thread.sleep(500); 
//		robot.keyPress(KeyEvent.VK_F); 
//		Thread.sleep(500); 
//		robot.keyPress(KeyEvent.VK_O); 
//		Thread.sleep(500); 
//		robot.keyPress(KeyEvent.VK_R); 
//		Thread.sleep(500); 
//		robot.keyPress(KeyEvent.VK_G); 
//		Thread.sleep(500); 
//		robot.keyPress(KeyEvent.VK_E); 
//		Thread.sleep(500); 
//		robot.keyPress(KeyEvent.VK_E); 
//		Thread.sleep(500); 
//		robot.keyPress(KeyEvent.VK_K); 
//		Thread.sleep(500); 
//		robot.keyPress(KeyEvent.VK_S); 
	} 
}
