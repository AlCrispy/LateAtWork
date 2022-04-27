package main.java.com.mango.core;

import main.java.com.mango.core.ui.TimeManagementFrame;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static final String LOOK_AND_FEEL = "com.formdev.flatlaf.FlatDarkLaf";

	public static void main(String args[]) {

		startupLookAndFeel();
		//Creating the Frame
		new TimeManagementFrame();
	}

	private static void startupLookAndFeel() {
		try {
			UIManager.setLookAndFeel(LOOK_AND_FEEL);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
		JFrame.setDefaultLookAndFeelDecorated(true);
	}
} 
