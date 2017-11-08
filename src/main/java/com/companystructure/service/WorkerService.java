package com.companystructure.service;


import com.companystructure.model.Worker;

import java.util.List;

public interface WorkerService {
    void addWorker(Worker worker);

    void updateWorker(Worker worker);

    Worker getWorkerById(int id);

    void dismissalWorker(int id);

    void transferWorker(int id);

    void transferAllWorkers();

    void getLeader();

    List<Worker> searchWorker();

    List<Worker> getAllWorker();
}
