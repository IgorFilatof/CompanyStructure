package com.companystructure.dao;


import com.companystructure.model.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkerDaoImpl implements WorkerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addWorker(Worker worker) {
        Session session = sessionFactory.openSession();
        session.persist(worker);
        session.close();
    }

    @Override
    public void updateWorker(Worker worker) {
        Session session = sessionFactory.openSession();
        session.update(worker);
        session.close();
    }

    @Override
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
        session.close();
    }

    @Override
    public void transferWorker(int id) {

    }

    @Override
    public void transferAllWorkers() {

    }

    @Override
    public void getLeader() {

    }

    @Override
    public List<Worker> searchWorker() {
        return null;
    }

    @Override
    public List<Worker> getAllWorker() {
        Session session = sessionFactory.openSession();
        List<Worker> workerList = session.createQuery("from Worker").list();
        return workerList;
    }
}
