import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

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
    private JDatePicker startDatePicker; 
    private JTextArea textAreaAddress;
    private JButton buttonUploadImage;
    private JTextField textFieldImagePath;
    private JPanel panelPhoto;

    public FormEmployee() {
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new GridLayout(0, 3, 10, 10));

        // First Column
        labelEmployeeID = new JLabel("Employee ID");
        textFieldEmployeeID = new JTextField();
        add(labelEmployeeID);
        add(textFieldEmployeeID);
        add(new JLabel());

        labelName = new JLabel("Name");
        textFieldName = new JTextField();
        add(labelName);
        add(textFieldName);
        add(new JLabel());

        labelGender = new JLabel("Gender");
        JPanel genderPanel = new JPanel();
        radioButtonMale = new JRadioButton("Male");
        radioButtonFemale = new JRadioButton("Female");
        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(radioButtonMale);
        genderButtonGroup.add(radioButtonFemale);
        genderPanel.add(radioButtonMale);
        genderPanel.add(radioButtonFemale);
        add(labelGender);
        add(genderPanel);
        add(new JLabel());

        labelAge = new JLabel("Age");
        textFieldAge = new JTextField();
        add(labelAge);
        add(textFieldAge);
        add(new JLabel());

        labelBloodGroup = new JLabel("Blood Group");
        textFieldBloodGroup = new JTextField();
        add(labelBloodGroup);
        add(textFieldBloodGroup);
        add(new JLabel());

        labelPhoneNumber = new JLabel("Phone Number");
        textFieldPhoneNumber = new JTextField();
        add(labelPhoneNumber);
        add(textFieldPhoneNumber);
        add(new JLabel());

        labelQualification = new JLabel("Qualification");
        String[] qualifications = {"DOCT", "DESS", "MAST", "LICE", "BTS", "DEUG", "DUT", "BAC"};
        comboBoxQualification = new JComboBox<>(qualifications);
        add(labelQualification);
        add(comboBoxQualification);
        add(new JLabel());

        labelStartDate = new JLabel("Start Date");
        UtilDateModel startDateModel = new UtilDateModel();
        JDatePanelImpl startDatePanel = new JDatePanelImpl(startDateModel);
        startDatePicker = new JDatePickerImpl(startDatePanel);
        add(labelStartDate);
        add(startDatePicker);
        add(new JLabel());

        labelAddress = new JLabel("Address");
        textAreaAddress = new JTextArea();
        textAreaAddress.setLineWrap(true);
        JScrollPane addressScrollPane = new JScrollPane(textAreaAddress);
        add(labelAddress);
        add(addressScrollPane);
        add(new JLabel());


        add(new JLabel());
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
        add(new JLabel());

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
