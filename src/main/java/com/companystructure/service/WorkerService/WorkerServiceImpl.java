package com.companystructure.service.WorkerService;


import com.companystructure.dao.WorkedDao.WorkerDao;
import com.companystructure.model.Worker;
import com.companystructure.service.WorkerService.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerDao workerDao;

    @Override
    public void addWorker(Worker worker) {
        workerDao.addWorker(worker);
    }

    @Override
    public void updateWorker(Worker worker) {
        workerDao.updateWorker(worker);
    }

    @Override
    public Worker getWorkerById(int id) {
        return workerDao.getWorkerById(id);
    }

    @Override
    public void dismissalWorker(int id) {

    }

    @Override
    public void transferWorker(int id) {

    }

    @Override
    public void transferAllWorkers() {

    }

    @Override
    public Worker getLeader() {
      return  workerDao.getLeader();
    }

    @Override
    public List<Worker> searchWorker(String name) {
        return workerDao.searchWorker(name);
    }

    @Override
    public List<Worker> getAllWorker() {
        return workerDao.getAllWorker();
    }
}
