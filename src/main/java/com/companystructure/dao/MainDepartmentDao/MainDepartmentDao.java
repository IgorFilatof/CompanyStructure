package com.companystructure.dao.MainDepartmentDao;



import com.companystructure.model.MainDepartment;

import java.util.List;

public interface MainDepartmentDao {

    void addMainDepartment(MainDepartment mainDepartment);
    void updateDepartment(String name,int id);
    void deleteDepartment(int id);
    List getDepartmentById(int id);
    List getAllDepartmentInMainDepartment(int id);
}
