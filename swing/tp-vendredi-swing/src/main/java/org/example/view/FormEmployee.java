package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormEmployee extends JPanel {
    private JLabel labelEmployeeID;
    private JLabel labelName;
    private JLabel labelGender;
    private JLabel labelAge;
    private JLabel labelBloodGroup;
    private JLabel labelPhoneNumber;
    private JLabel labelQualification;
    private JLabel labelStartDate;
    private JLabel labelAddress;
    private JLabel labelImagePath;
    private JLabel labelPhoto;

    private JTextField textFieldEmployeeID;
    private JTextField textFieldName;
    private JRadioButton radioButtonMale;
    private JRadioButton radioButtonFemale;
    private ButtonGroup genderButtonGroup;
    private JTextField textFieldAge;
    private JTextField textFieldBloodGroup;
    private JTextField textFieldPhoneNumber;
    private JComboBox<String> comboBoxQualification;
    private JTextField textFieldStartDate;
    private JTextArea textAreaAddress;
    private JButton buttonUploadImage;
    private JTextField textFieldImagePath;
    private JPanel panelPhoto;

    public FormEmployee() {
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new GridLayout(0, 3, 10, 10)); // 3 columns with 10px horizontal and vertical gap

        // First Column
        labelEmployeeID = new JLabel("Employee ID"); // Initialize labelEmployeeID
        textFieldEmployeeID = new JTextField();
        add(labelEmployeeID);
        add(textFieldEmployeeID);
        add(new JLabel()); // Empty space to align with other columns

        labelName = new JLabel("Name");
        textFieldName = new JTextField();
        add(labelName);
        add(textFieldName);
        add(new JLabel()); // Empty space

        labelGender = new JLabel("Gender");
        JPanel genderPanel = new JPanel(); // Panel to hold radio buttons
        radioButtonMale = new JRadioButton("Male");
        radioButtonFemale = new JRadioButton("Female");
        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(radioButtonMale);
        genderButtonGroup.add(radioButtonFemale);
        genderPanel.add(radioButtonMale);
        genderPanel.add(radioButtonFemale);
        add(labelGender);
        add(genderPanel);
        add(new JLabel()); // Empty space

        labelAge = new JLabel("Age");
        textFieldAge = new JTextField();
        add(labelAge);
        add(textFieldAge);
        add(new JLabel()); // Empty space

        labelBloodGroup = new JLabel("Blood Group");
        textFieldBloodGroup = new JTextField();
        add(labelBloodGroup);
        add(textFieldBloodGroup);
        add(new JLabel()); // Empty space

        labelPhoneNumber = new JLabel("Phone Number");
        textFieldPhoneNumber = new JTextField();
        add(labelPhoneNumber);
        add(textFieldPhoneNumber);
        add(new JLabel()); // Empty space

        labelQualification = new JLabel("Qualification");
        String[] qualifications = {"Bachelor's Degree", "Master's Degree", "PhD", "Diploma", "Other"};
        comboBoxQualification = new JComboBox<>(qualifications);
        add(labelQualification);
        add(comboBoxQualification);
        add(new JLabel()); // Empty space

        labelStartDate = new JLabel("Start Date");
        textFieldStartDate = new JTextField();
        add(labelStartDate);
        add(textFieldStartDate);
        add(new JLabel()); // Empty space

        labelAddress = new JLabel("Address");
        textAreaAddress = new JTextArea();
        textAreaAddress.setLineWrap(true);
        JScrollPane addressScrollPane = new JScrollPane(textAreaAddress);
        add(labelAddress);
        add(addressScrollPane);
        add(new JLabel()); // Empty space

        // Second Column
        add(new JLabel()); // Empty space
        buttonUploadImage = new JButton("Upload Image");
        buttonUploadImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle upload image action
            }
        });
        add(buttonUploadImage);

        labelImagePath = new JLabel("Image Path");
        textFieldImagePath = new JTextField();
        add(labelImagePath);
        add(textFieldImagePath);
        add(new JLabel()); // Empty space

        // Third Column
        add(new JLabel()); // Empty space
        panelPhoto = new JPanel();
        panelPhoto.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        labelPhoto = new JLabel("Photo");
        panelPhoto.add(labelPhoto);
        add(panelPhoto);
        add(new JLabel()); // Empty space
    }
}

