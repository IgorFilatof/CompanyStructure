package com.companystructure.service.DepartmentService;


import com.companystructure.model.Department;

public interface DepartmentService {
    void addDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(int id);
    Department getDepartmentById(int id);
}
