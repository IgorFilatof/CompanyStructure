package com.companystructure.dao.MainDepartmentDao;

import com.companystructure.model.MainDepartment;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MainDepartmentDaoImpl implements MainDepartmentDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void addMainDepartment(MainDepartment mainDepartment) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(mainDepartment);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateDepartment(String name, int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update MainDepartment set nameMainDep= :nameDep where idDepartment= :idDep");
        query.setParameter("nameDep", name);
        query.setParameter("idDep", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteDepartment(int id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Department where MainDepartment.idMaindep= :idDep");
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
            Query query1 = session.createQuery("delete from MainDepartment where idMaindep= :idDepart");
            query1.setParameter("idDepart", id);
            query1.executeUpdate();
            transaction.commit();
        }
        session.close();
    }

    @Override
    public List getDepartmentById(int id) {
        Session session = sessionFactory.openSession();
       Query query=session.createQuery("from MainDepartment where idMaindep= :idDep");
       query.setParameter("idDep",id);
       List list=query.list();
        session.close();
        return list;
    }


    @Override
    public List getAllDepartmentInMainDepartment(int id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Department where mainDepartment= :idDep");
        query.setParameter("idDep", id);
        List<Integer> list = query.list();
        session.close();
        return list;
    }
}
