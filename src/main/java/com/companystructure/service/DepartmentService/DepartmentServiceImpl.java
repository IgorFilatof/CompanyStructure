package com.companystructure.service.DepartmentService;


import com.companystructure.dao.DepartmentDao.DepartmentDao;
import com.companystructure.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public void addDepartment(Department department) {
departmentDao.addDepartment(department);
    }

    @Override
    public void updateDepartment(Department department) {
departmentDao.updateDepartment(department);
    }

    @Override
    public void deleteDepartment(int id) {
departmentDao.deleteDepartment(id);
    }

    @Override
    public Department getDepartmentById(int id) {
        Department department=departmentDao.getDepartmentById(id);
        return department;
    }
}
