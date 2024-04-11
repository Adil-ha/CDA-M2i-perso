package org.example;

import org.example.layout.BorderLayoutDemo;
import org.example.layout.FlowLayoutDemo;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jframe = new JFrame("Demo Layout");
        jframe.setVisible(true);
        jframe.setSize(1200,500);
        jframe.setLocationRelativeTo(null);
//        jframe.add(new BorderLayoutDemo());
        jframe.add(new FlowLayoutDemo().getJPanel());
//        jframe.pack();
        jframe.setName("demo");

    }
}