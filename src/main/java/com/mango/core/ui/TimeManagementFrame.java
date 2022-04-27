package main.java.com.mango.core.ui;

import javax.swing.*;


public class TimeManagementFrame extends JFrame {

    public static final String FRAME_NAME = "Time Management Tool";

    public TimeManagementFrame() {

        PanelRepository repository = new PanelRepository();
        JPanel workingPanel = repository.createWorkingPanel();

        getContentPane().add(workingPanel);
        setTitle(FRAME_NAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setResizable(false);
        setVisible(true);

    }

}
