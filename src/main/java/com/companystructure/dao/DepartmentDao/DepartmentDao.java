package com.companystructure.dao.DepartmentDao;
import com.companystructure.model.Department;



public interface DepartmentDao {

    void addDepartment(Department department);
    void updateDepartment(String name,int id);
    void deleteDepartment(int id);
    Department getDepartmentById(int id);
    Integer getAllSalaryInDepartment(int id);


}
