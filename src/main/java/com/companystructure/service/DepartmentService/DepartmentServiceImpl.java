package com.companystructure.service.DepartmentService;


import com.companystructure.dao.DepartmentDao.DepartmentDao;
import com.companystructure.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public void addDepartment(Department department) {
departmentDao.addDepartment(department);
    }

    @Override
    public void updateDepartment(String name, int id) {
        departmentDao.updateDepartment(name, id);
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

    @Override
    public Integer getAllSalaryInDepartment(int id) {
        return departmentDao.getAllSalaryInDepartment(id);
    }
}
