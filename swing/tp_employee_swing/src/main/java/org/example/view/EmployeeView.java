package org.example.view;

import org.example.controller.EmployeeController;
import org.example.model.Employee;
import org.example.model.Role;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EmployeeView extends JFrame {
    private EmployeeController employeeController;

    private JTextField nameField;
    private JComboBox<String> roleComboBox;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JList<Employee> employeeList;

    public EmployeeView(EmployeeController employeeController) {
        this.employeeController = employeeController;

        setTitle("Employee Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        loadEmployeeList();

        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Role:"));
        roleComboBox = new JComboBox<>(new String[]{"MANAGER", "EMPLOYEE", "HR"});
        inputPanel.add(roleComboBox);

        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        addButton.addActionListener(e -> addEmployee());
        updateButton.addActionListener(e -> updateEmployee());
        deleteButton.addActionListener(e -> deleteEmployee());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        employeeList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(employeeList);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    private void loadEmployeeList() {
        List<Employee> employees = employeeController.getAllEmployees();
        DefaultListModel<Employee> model = new DefaultListModel<>();
        for (Employee employee : employees) {
            model.addElement(employee);
        }
        employeeList.setModel(model);
    }

    private void addEmployee() {
        String name = nameField.getText();
        String role = (String) roleComboBox.getSelectedItem();
        employeeController.addEmployee(new Employee(name, Role.valueOf(role)));
        loadEmployeeList();
    }

    private void updateEmployee() {
        Employee selectedEmployee = employeeList.getSelectedValue();
        if (selectedEmployee != null) {
            String name = nameField.getText();
            String role = (String) roleComboBox.getSelectedItem();
            selectedEmployee.setName(name);
            selectedEmployee.setRole(Role.valueOf(role));
            employeeController.updateEmployee(selectedEmployee);
            loadEmployeeList();
        }
    }

    private void deleteEmployee() {
        Employee selectedEmployee = employeeList.getSelectedValue();
        if (selectedEmployee != null) {
            employeeController.deleteEmployee(selectedEmployee.getId());
            loadEmployeeList();
        }
    }
}
