package com.companystructure.dao.WorkedDao;


import com.companystructure.model.Worker;

import java.util.List;

public interface WorkerDao {
    void addWorker(Worker worker);

    void updateWorker(Worker worker);

    Worker getWorkerById(int id);

    void dismissalWorker(int id);

    void transferWorker(int idDep,int idWorker);

    void transferAllWorkers(int idOldDep, int idNewDep);

    List getLeader(int idDep);

    List<Worker> searchWorker(String name);

    List<Worker> getAllWorker(int idDep);
}
