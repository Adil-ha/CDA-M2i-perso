package org.example.view;

import org.example.controller.DepartmentController;
import org.example.model.Department;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DepartmentView extends JFrame {
    private DepartmentController departmentController;

    private JTextField nameField;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JList<Department> departmentList;

    public DepartmentView(DepartmentController departmentController) {
        this.departmentController = departmentController;

        setTitle("Department Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        loadDepartmentList();

        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        addButton.addActionListener(e -> addDepartment());
        updateButton.addActionListener(e -> updateDepartment());
        deleteButton.addActionListener(e -> deleteDepartment());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        departmentList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(departmentList);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    private void loadDepartmentList() {
        List<Department> departments = departmentController.getAllDepartments();
        DefaultListModel<Department> model = new DefaultListModel<>();
        for (Department department : departments) {
            model.addElement(department);
        }
        departmentList.setModel(model);
    }

    private void addDepartment() {
        String name = nameField.getText();
        departmentController.addDepartment(new Department(name));
        loadDepartmentList();
    }

    private void updateDepartment() {
        Department selectedDepartment = departmentList.getSelectedValue();
        if (selectedDepartment != null) {
            String name = nameField.getText();
            selectedDepartment.setName(name);
            departmentController.updateDepartment(selectedDepartment);
            loadDepartmentList();
        }
    }

    private void deleteDepartment() {
        Department selectedDepartment = departmentList.getSelectedValue();
        if (selectedDepartment != null) {
            departmentController.deleteDepartment(selectedDepartment.getId());
            loadDepartmentList();
        }
    }
}
