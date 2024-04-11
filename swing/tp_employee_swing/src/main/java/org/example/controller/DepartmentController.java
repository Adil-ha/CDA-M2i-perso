package org.example.controller;

import org.example.dao.DepartmentDao;
import org.example.model.Department;

import java.util.List;

public class DepartmentController {

    private DepartmentDao departmentDao;

    public DepartmentController(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }

    public void addDepartment(Department department) {
        departmentDao.addDepartment(department);
    }

    public void updateDepartment(Department department) {
        departmentDao.updateDepartment(department);
    }

    public void deleteDepartment(int id) {
        departmentDao.deleteDepartment(id);
    }
}

