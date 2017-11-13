package com.companystructure.service.MainDepartmentService;


import com.companystructure.dao.MainDepartmentDao.MainDepartmentDao;
import com.companystructure.model.MainDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MainDepartmentServiceImpl implements MainDepartmentService {

   @Autowired
    private MainDepartmentDao mainDepartmentDao;

    @Override
    public void addMainDepartment(MainDepartment mainDepartment) {
        mainDepartmentDao.addMainDepartment(mainDepartment);
    }

    @Override
    public void updateDepartment(String name, int id) {
        mainDepartmentDao.updateDepartment(name, id);
    }

    @Override
    public void deleteDepartment(int id) {
        mainDepartmentDao.deleteDepartment(id);
    }

    @Override
    public List getDepartmentById(int id) {
        return mainDepartmentDao.getDepartmentById(id);
    }

    @Override
    public List getAllDepartmentInMainDepartment(int id) {
        return mainDepartmentDao.getAllDepartmentInMainDepartment(id);
    }
}
