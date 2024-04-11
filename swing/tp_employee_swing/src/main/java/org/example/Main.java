package org.example;

import org.example.controller.DepartmentController;
import org.example.controller.EmployeeController;
import org.example.dao.DepartmentDao;
import org.example.dao.EmployeeDao;
import org.example.view.DepartmentView;
import org.example.view.EmployeeView;

public class Main {
    public static void main(String[] args) {
        // Instanciation des DAOs
        EmployeeDao employeeDao = new EmployeeDao();
        DepartmentDao departmentDao = new DepartmentDao();

        // Instanciation des contrôleurs avec les DAOs correspondants
        EmployeeController employeeController = new EmployeeController(employeeDao);
        DepartmentController departmentController = new DepartmentController(departmentDao);

        // Instanciation des vues avec les contrôleurs correspondants
        EmployeeView employeeView = new EmployeeView(employeeController);
        DepartmentView departmentView = new DepartmentView(departmentController);
    }
}
