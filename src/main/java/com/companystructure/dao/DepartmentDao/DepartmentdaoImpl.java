package com.companystructure.dao.DepartmentDao;


import com.companystructure.model.Department;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public void updateDepartment(String name, int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update Department set nameDepartment= :nameDep where idDepartment= :idDep");
        query.setParameter("nameDep", name);
        query.setParameter("idDep", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }


    @Override
    public void deleteDepartment(int id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Worker where department.idDepartment= :idDep");
        query.setParameter("idDep", id);
        List list = query.list();
        if (!list.isEmpty()) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Transaction transaction = session.beginTransaction();
            Query query1 = session.createQuery("delete from Department where idDepartment= :idDepart");
            query1.setParameter("idDepart", id);
            query1.executeUpdate();
            transaction.commit();
        }
        session.close();
    }

    @Override
    public Department getDepartmentById(int id) {
        Session session = sessionFactory.openSession();
        Department department = session.load(Department.class, new Integer(id));
        session.close();
        return department;
    }

    @Override
    public Integer getAllSalaryInDepartment(int id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select salary from Worker where department.idDepartment= :idDep");
        query.setParameter("idDep", id);
        List<Integer> list = query.list();
        int allSalary = 0;
        for (Integer integer : list) {
            allSalary += integer;
        }

        return allSalary;
    }
}
