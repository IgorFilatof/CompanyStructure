package com.companystructure.dao.DepartmentDao;


import com.companystructure.model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentdaoImpl implements DepartmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addDepartment(Department department) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(department);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateDepartment(Department department) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(department);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteDepartment(int id) {
        Session session = sessionFactory.openSession();
        Department department = session.load(Department.class, id);
        if(department!=null){
            session.delete(department);
        }
        session.close();
    }

    @Override
    public Department getDepartmentById(int id) {
        Session session=sessionFactory.openSession();
        Department department=session.load(Department.class,id);
        session.close();
        return department;
    }
}
