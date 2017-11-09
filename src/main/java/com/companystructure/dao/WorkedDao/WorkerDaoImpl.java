package com.companystructure.dao.WorkedDao;

import com.companystructure.model.Department;
import com.companystructure.model.Worker;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    public void transferWorker(int id) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        String hqlUpdate="update Worker set id_dep";
        session.close();

    }

    @Override
    public void transferAllWorkers() {

    }

    @Override
    public Worker getLeader() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Worker.class);
        criteria.add(Restrictions.eq("isLeader", true));
        Worker worker=(Worker)criteria.uniqueResult();
        return worker;
    }

    @Override
    public List<Worker> searchWorker(String name) {
        Session session=sessionFactory.openSession();
        Criteria criteria=session.createCriteria(Worker.class);
        criteria.add(Restrictions.eq("name",name));
        List<Worker> workerList=criteria.list();
        return workerList;
    }

    @Override
    public List<Worker> getAllWorker() {
        Session session = sessionFactory.openSession();
        List<Worker> workerList = session.createQuery("from Worker").list();
        return workerList;
    }
}
