package main.java.com.mango.core.ui;

import javax.swing.*;
import java.awt.*;

public class TimeManagementFrame {

    public static final String FRAME_NAME = "Time Management Tool";

    public void timeManagementFrame() {

        JFrame frame = new JFrame(FRAME_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        PanelRepository repository = new PanelRepository();

        JPanel workingPanel = repository.createWorkingPanel();
        JPanel LoggingPanel = repository.createLoggingPanel();
        JPanel ButtonBarPanel = repository.createButtonBarPanel();


        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.CENTER, workingPanel);

        frame.setVisible(true);
    }
}
