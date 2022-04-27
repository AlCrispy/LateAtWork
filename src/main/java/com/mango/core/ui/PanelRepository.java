package main.java.com.mango.core.ui;

import javax.swing.*;
import java.awt.*;

public class PanelRepository {

    protected JPanel createWorkingPanel() {
        //Creating the panel at bottom and adding components
        JPanel workingPanel = new JPanel();
        SpringLayout workingPanelLayout = new SpringLayout();
        workingPanel.setLayout(workingPanelLayout);// the panel is not visible in output

        JLabel startWorkLabel = new JLabel("Start working at: ");
        JTextField startWorkTextfield = new JTextField(5);

        JLabel startLunchLabel = new JLabel("Start lunch at: ");
        JTextField startLunchTextfield = new JTextField(5);

        JLabel endLunchLabel = new JLabel("End lunch at: ");
        JTextField endLunchTextfield = new JTextField(5);

        JLabel endWorkLabel = new JLabel("End working at: ");
        JTextField endWorkTextfield = new JTextField(5);

        workingPanel.add(startWorkLabel);
        workingPanel.add(startWorkTextfield);

        workingPanel.add(startLunchLabel);
        workingPanel.add(startLunchTextfield);

        workingPanel.add(endLunchLabel);
        workingPanel.add(endLunchTextfield);

        workingPanel.add(endWorkLabel);
        workingPanel.add(endWorkTextfield);

        workingPanelLayout.putConstraint(SpringLayout.WEST, startWorkLabel, 20, SpringLayout.WEST, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.NORTH, startWorkLabel, 20, SpringLayout.NORTH, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.WEST, startWorkTextfield , 20 + 100, SpringLayout.WEST, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.NORTH, startWorkTextfield, 20, SpringLayout.NORTH, workingPanel);

        workingPanelLayout.putConstraint(SpringLayout.WEST, startLunchLabel, 20, SpringLayout.WEST, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.NORTH, startLunchLabel, 20 + 30, SpringLayout.NORTH, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.WEST, startLunchTextfield , 20 + 100, SpringLayout.WEST, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.NORTH, startLunchTextfield, 20 + 30, SpringLayout.NORTH, workingPanel);

        workingPanelLayout.putConstraint(SpringLayout.WEST, endLunchLabel, 20, SpringLayout.WEST, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.NORTH, endLunchLabel, 20 + (30 * 2), SpringLayout.NORTH, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.WEST, endLunchTextfield , 20 + 100, SpringLayout.WEST, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.NORTH, endLunchTextfield, 20 + (30 * 2), SpringLayout.NORTH, workingPanel);

        workingPanelLayout.putConstraint(SpringLayout.WEST, endWorkLabel, 20, SpringLayout.WEST, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.NORTH, endWorkLabel, 20 + (30 * 3), SpringLayout.NORTH, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.WEST, endWorkTextfield , 20 + 100, SpringLayout.WEST, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.NORTH, endWorkTextfield, 20 + (30 * 3), SpringLayout.NORTH, workingPanel);

        return workingPanel;
    }

    protected JPanel createButtonBarPanel() {
        JPanel buttonBarPanel = new JPanel();
        return buttonBarPanel;
    }

    public JPanel createLoggingPanel() {
        JPanel loggingPanel = new JPanel();
        return loggingPanel;
    }
}
