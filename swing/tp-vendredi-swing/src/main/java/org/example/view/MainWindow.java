package org.example.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainWindow extends JFrame {
    private JPanel panelNorth;
    private JToolBar panelCenter;
    private JTable panelSouth;

    public MainWindow() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Employee Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creating panels
        panelNorth = new FormEmployee();
        panelCenter = new ToolBar(); // You'll need to implement your own toolbar here
        panelSouth = new JTable(); // You'll need to implement your own table here

        // Adding borders and outer margins to the panels
        panelNorth.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Employee Form"),
                new EmptyBorder(10, 10, 10, 10))); // Border and outer margin for panelNorth

        panelCenter.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Toolbar"),
                new EmptyBorder(10, 10, 10, 10))); // Border and outer margin for panelCenter

        panelSouth.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Employee List"),
                new EmptyBorder(10, 10, 10, 10))); // Border and outer margin for panelSouth

        // Adding panels with specified height percentages
        add(panelNorth, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
        add(panelSouth, BorderLayout.SOUTH);

        // Set the window size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.getWidth() * 0.8);
        int height = (int) (screenSize.getHeight() * 0.8);
        setSize(width, height);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Make the window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
    }
}


