package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JToolBar {

    private JLabel labelSearch;
    private JTextField textFieldSearch;
    private JButton buttonNew;
    private JButton buttonSave;
    private JButton buttonUpdate;
    private JButton buttonClear;
    private JButton buttonPrint;

    public ToolBar() {
        initializeUI();
    }

    private void initializeUI() {
        setFloatable(false); // Make the toolbar non-floating
        setLayout( new FlowLayout( FlowLayout.CENTER ) );

        labelSearch = new JLabel("Search");
        textFieldSearch = new JTextField(10); // Set preferred width of the text field

        // Create buttons with names and icons
        buttonNew = new JButton(new ImageIcon("icons/new_icon.png")+ "New");
        buttonNew.setText("New");

        buttonSave = new JButton(new ImageIcon("icons/save.png")+ "Save");
        buttonSave.setText("Save");


        buttonUpdate = new JButton(new ImageIcon("icons/update_icon.png")+ "Update");
        buttonUpdate.setText("Update");

        buttonClear = new JButton(new ImageIcon("icons/clear_icon.png")+ "Clear");
        buttonClear.setText("Clear");

        buttonPrint = new JButton(new ImageIcon("icons/print_icon.png")+ "Print");
        buttonPrint.setText("Print");

        // Add action listeners for the buttons
        buttonNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle New button action
            }
        });

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle Save button action
            }
        });

        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle Update button action
            }
        });

        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle Clear button action
            }
        });

        buttonPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle Print button action
            }
        });

        // Add components to the toolbar
        add(labelSearch);
        add(textFieldSearch);
        add(buttonNew);
        add(buttonSave);
        add(buttonUpdate);
        add(buttonClear);
        add(buttonPrint);
    }
}

