package org.example.util;

import org.example.model.Employee;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EmployeeTableModel extends AbstractTableModel {
    private List<Employee> employeeList;
    private String[] columnNames = {"ID", "Name", "Gender", "Age", "Blood Group", "Phone Number", "Qualification", "Start Date", "Address", "Photo"};

    public EmployeeTableModel(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public int getRowCount() {
        return employeeList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee employee = employeeList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return employee.getId();
            case 1:
                return employee.getName();
            case 2:
                return employee.getGender();
            case 3:
                return employee.getAge();
            case 4:
                return employee.getBloodGroup();
            case 5:
                return employee.getPhoneNumber();
            case 6:
                return employee.getQualification();
            case 7:
                return employee.getStartDate();
            case 8:
                return employee.getAddress();
            case 9:
                return employee.getPhotoUrl();
            default:
                return null;
        }
    }
}

