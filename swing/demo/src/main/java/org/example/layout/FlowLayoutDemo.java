package org.example.layout;

import lombok.Data;

import javax.swing.*;
import java.awt.*;


@Data
public class FlowLayoutDemo {

    private JPanel jPanel;

    private JLabel jLabel;

    private JComboBox<String> jComboBox;

    private JLabel resultLabel;

    public FlowLayoutDemo(){

        jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));

        JButton button = new JButton("bouton1");
        button.setBackground(Color.GREEN);
        button.addActionListener(e-> System.out.println("Button Click"));
        jPanel.add(button);

        jPanel.add(new JButton("button2"));
        jPanel.add(new JButton("button3"));

        jPanel.add(new JLabel("label"));

        JTextField input = new JTextField(20);

        jComboBox = new JComboBox<>(new String[]{"option1","option2","option3" });
        jPanel.add(jComboBox);

        resultLabel = new JLabel("Resultat et selection s'afficheront ici");
        jPanel.add(resultLabel);

        JButton validateButton = new JButton("Valider");

        validateButton.addActionListener(e->{

            String selected = String.valueOf(jComboBox.getSelectedIndex());
            String inputText = input.getText();

            resultLabel.setText("Input data : " + inputText );

        });

        jPanel.add(validateButton);





    }
}
