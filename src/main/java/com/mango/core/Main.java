package main.java.com.mango.core;

import main.java.com.mango.core.ui.TimeManagementFrame;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static void main(String args[]) {

		startupLookAndFeel();

		TimeManagementFrame mainframe = new TimeManagementFrame();

		//Creating the Frame
		mainframe.timeManagementFrame();
	}

	private static void startupLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
		JFrame.setDefaultLookAndFeelDecorated(true);
	}
} 
