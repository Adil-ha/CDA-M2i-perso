package org.example.controller;

import org.example.dao.EmployeeDao;
import org.example.model.Employee;

import java.util.List;

public class EmployeeController {
    private EmployeeDao employeeDao;

    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }
}

