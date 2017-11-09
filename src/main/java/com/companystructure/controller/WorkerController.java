package com.companystructure.controller;

import com.companystructure.model.Worker;
import com.companystructure.service.WorkerService.WorkerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/worker")
@Api(value = "WorkerControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation("Add new worker")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Worker.class)})
    public ResponseEntity<Worker> addWorker(@RequestBody Worker worker) {
        workerService.addWorker(worker);
        return new ResponseEntity<Worker>(worker, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation("Update worker")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Update")})
    public ResponseEntity<Void> updateWorker(@RequestBody Worker worker) {
        workerService.updateWorker(worker);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation("Get worker by ID")
    @ApiResponses(value = {@ApiResponse(code=200,message = "OK",response = Worker.class)})
    public ResponseEntity<Worker> getWorkerById(@PathVariable("id") int id) {
        Worker worker = workerService.getWorkerById(id);
        if (worker == null) {
            return new ResponseEntity<Worker>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Worker>(worker, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "leader", method = RequestMethod.GET)
    @ApiOperation("Get leader from department")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "OK",response = Worker.class)})
    public ResponseEntity<Worker> getLeader() {
        Worker worker = workerService.getLeader();
        return new ResponseEntity<Worker>(worker, HttpStatus.OK);
    }

   /* @RequestMapping( value = "/{searchName}", method = RequestMethod.GET)
    public ResponseEntity<List<Worker>> searchWorker(@PathVariable ("searchName")String searchName) {
        List<Worker> worker= workerService.searchWorker(searchName);
        return new ResponseEntity<List<Worker>>(worker,HttpStatus.OK);
    }*/

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation("Gets all workers in department")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Worker.class)})
    public ResponseEntity<List<Worker>> getAllWorker() {
        List<Worker> workerList = workerService.getAllWorker();

        if (workerList.isEmpty()) {
            return new ResponseEntity<List<Worker>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Worker>>(workerList, HttpStatus.OK);
        }
    }
}
