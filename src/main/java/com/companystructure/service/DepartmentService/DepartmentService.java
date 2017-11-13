package com.companystructure.service.DepartmentService;


import com.companystructure.model.Department;

import java.util.List;

public interface DepartmentService {
    void addDepartment(Department department);
    void updateDepartment(String name,int id);
    void deleteDepartment(int id);
    Department getDepartmentById(int id);
    Integer getAllSalaryInDepartment(int id);
}
