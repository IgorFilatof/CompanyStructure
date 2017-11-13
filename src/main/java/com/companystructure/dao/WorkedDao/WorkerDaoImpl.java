package com.companystructure.dao.WorkedDao;

import com.companystructure.model.Department;
import com.companystructure.model.Worker;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class WorkerDaoImpl implements WorkerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addWorker(Worker worker) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(worker);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateWorker(Worker worker) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(worker);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    @Transactional
    public Worker getWorkerById(int id) {
        Session session = sessionFactory.openSession();
        Worker worker = session.load(Worker.class, id);
        session.close();
        return worker;
    }

    @Override
    public void dismissalWorker(int id) {
        Session session = sessionFactory.openSession();
        Worker worker = session.load(Worker.class, id);
        //  worker.setDateEndWork(2008/3/27);
        session.close();
    }

    @Override
    public void transferWorker(int idDep, int idWorker) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update Worker set department.idDepartment= :depParam where idWorker= :id");
        query.setParameter("depParam", idDep);
        query.setParameter("id", idWorker);
        query.executeUpdate();
        transaction.commit();
        session.close();

    }

    @Override
    public void transferAllWorkers(int idOldDep, int idNewDep) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update Worker set department.idDepartment= :depParam where department.idDepartment= :id");
        query.setParameter("depParam", idNewDep);
        query.setParameter("id", idOldDep);
        query.executeUpdate();
        transaction.commit();
        session.close();

    }

    @Override
    public List getLeader(int idDep) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Worker where isLeader=true and department.idDepartment= :idDep");
        query.setParameter("idDep", idDep);
        List list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<Worker> searchWorker(String name) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Worker where name= :nameWorker");
        query.setParameter("nameWorker", name);
        List<Worker> workerList = query.list();
        session.close();
        return workerList;
    }

    @Override
    public List getAllWorker(int idDep) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Worker where department.idDepartment= :idDep");
        query.setParameter("idDep", idDep);
        List workerList = query.list();
        session.getTransaction().commit();
        session.close();
        return workerList;
    }
}
