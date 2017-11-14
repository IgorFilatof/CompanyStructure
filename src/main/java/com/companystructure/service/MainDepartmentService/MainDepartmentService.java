package com.companystructure.service.MainDepartmentService;


import com.companystructure.model.MainDepartment;

import java.util.List;

public interface MainDepartmentService {

    void addMainDepartment(MainDepartment mainDepartment);
    void updateDepartment(String name,int id);
    List getDepartmentById(int id);
    List getAllDepartmentInMainDepartment(int id);
}
