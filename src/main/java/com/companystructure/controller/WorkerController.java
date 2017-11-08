package com.companystructure.controller;

import com.companystructure.model.Worker;
import com.companystructure.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Worker> addWorker(@RequestBody Worker worker) {
        workerService.addWorker(worker);
        return new ResponseEntity<Worker>(worker, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateWorker(@RequestBody Worker worker) {
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Worker> getWorkerById(@PathVariable("id") int id) {
        Worker worker = workerService.getWorkerById(id);
        if (worker == null) {
            return new ResponseEntity<Worker>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Worker>(worker, HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Worker>> getAllWorker() {
        List<Worker> workerList = workerService.getAllWorker();

        if (workerList.isEmpty()) {
            return new ResponseEntity<List<Worker>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Worker>>(workerList, HttpStatus.OK);
        }
    }
}
