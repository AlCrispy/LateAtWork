package main.java.com.mango.core.ui;

import main.java.com.mango.core.arithmetics.TimeManagementArithmetics;
import main.java.com.mango.core.entity.WorkTimeResponse;

import javax.swing.*;
import java.awt.*;

public class PanelRepository {

    public static final String EXECUTE = "Execute";
    public static final String RESET = "Reset";
    public static final String EMPTY_STRING = "";
    TimeManagementArithmetics arithmetics = new TimeManagementArithmetics();

    protected JPanel createWorkingPanel() {
        JPanel workingPanel = new JPanel();
        workingPanel.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.DARK_GRAY));
        SpringLayout workingPanelLayout = new SpringLayout();
        workingPanel.setLayout(workingPanelLayout);

        JLabel startWorkLabel = new JLabel("Start working at: ");
        JTextField startWorkTextfield = new JTextField(5);
        JLabel startLunchLabel = new JLabel("Start lunch at: ");
        JTextField startLunchTextfield = new JTextField(5);
        JLabel endLunchLabel = new JLabel("End lunch at: ");
        JTextField endLunchTextfield = new JTextField(5);

        JTextArea infoArea = new JTextArea(10, 28);
        infoArea.setEditable(false);
        infoArea.setBackground(Color.DARK_GRAY);
        infoArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.BLACK), BorderFactory.createEmptyBorder(3, 3, 3, 3)));

        JButton buttonExecute = new JButton(EXECUTE);
        buttonExecute.addActionListener(event -> {
            WorkTimeResponse response = arithmetics.performArithmeticsForExactEndWorkTime(startWorkTextfield.getText(), startLunchTextfield.getText(), endLunchTextfield.getText());
            String textResponse = EMPTY_STRING;
            for(Object adjustment: response.getAdjustment()){
                textResponse += adjustment +"\n";
            }
            textResponse += response.getMorningWorkTime() + "\n"
                            + response.getRemainingTimeToWork() + "\n"
                            + response.getWorkUntil();
            infoArea.setText(textResponse);
        });
        JButton buttonReset = new JButton(RESET);
        buttonReset.addActionListener(event -> {
            infoArea.setText(EMPTY_STRING);
            startWorkTextfield.setText(EMPTY_STRING);
            startLunchTextfield.setText(EMPTY_STRING);
            endLunchTextfield.setText(EMPTY_STRING);
        });

        workingPanel.add(startWorkLabel);
        workingPanel.add(startWorkTextfield);
        workingPanel.add(startLunchLabel);
        workingPanel.add(startLunchTextfield);
        workingPanel.add(endLunchLabel);
        workingPanel.add(endLunchTextfield);

        workingPanel.add(infoArea);

        workingPanel.add(buttonExecute);
        workingPanel.add(buttonReset);

        workingPanelLayout.putConstraint(SpringLayout.WEST, startWorkLabel, 20, SpringLayout.WEST, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.NORTH, startWorkLabel, 20, SpringLayout.NORTH, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.WEST, startWorkTextfield , 20 + 250, SpringLayout.WEST, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.NORTH, startWorkTextfield, 20, SpringLayout.NORTH, workingPanel);

        workingPanelLayout.putConstraint(SpringLayout.WEST, startLunchLabel, 20, SpringLayout.WEST, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.NORTH, startLunchLabel, 20 + 30, SpringLayout.NORTH, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.WEST, startLunchTextfield , 20 + 250, SpringLayout.WEST, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.NORTH, startLunchTextfield, 20 + 30, SpringLayout.NORTH, workingPanel);

        workingPanelLayout.putConstraint(SpringLayout.WEST, endLunchLabel, 20, SpringLayout.WEST, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.NORTH, endLunchLabel, 20 + (30 * 2), SpringLayout.NORTH, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.WEST, endLunchTextfield , 20 + 250, SpringLayout.WEST, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.NORTH, endLunchTextfield, 20 + (30 * 2), SpringLayout.NORTH, workingPanel);

        workingPanelLayout.putConstraint(SpringLayout.WEST, infoArea, 20, SpringLayout.WEST, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.NORTH, infoArea, 180, SpringLayout.NORTH, workingPanel);

        workingPanelLayout.putConstraint(SpringLayout.WEST, buttonExecute, 115, SpringLayout.WEST, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.NORTH, buttonExecute, 400, SpringLayout.NORTH, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.WEST, buttonReset , 115 + 80, SpringLayout.WEST, workingPanel);
        workingPanelLayout.putConstraint(SpringLayout.NORTH, buttonReset, 400, SpringLayout.NORTH, workingPanel);

        return workingPanel;
    }

}
