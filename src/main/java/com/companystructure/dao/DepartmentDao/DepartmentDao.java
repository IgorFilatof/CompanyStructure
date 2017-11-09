package com.companystructure.dao.DepartmentDao;
import com.companystructure.model.Department;


public interface DepartmentDao {

    void addDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(int id);
    Department getDepartmentById(int id);


}
