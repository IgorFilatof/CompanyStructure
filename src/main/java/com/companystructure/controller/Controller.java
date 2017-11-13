package com.companystructure.controller;

import com.companystructure.model.Department;
import com.companystructure.model.MainDepartment;
import com.companystructure.model.Worker;
import com.companystructure.service.DepartmentService.DepartmentService;
import com.companystructure.service.MainDepartmentService.MainDepartmentService;
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
@RequestMapping(value = "/company")
@Api(value = "ControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private WorkerService workerService;

    @Autowired
    private MainDepartmentService mainDepartmentService;

    @RequestMapping(value = "/worker/add", method = RequestMethod.POST)
    @ApiOperation("Add new worker")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Worker.class)})
    public ResponseEntity<Worker> addWorker(@RequestBody Worker worker) {
        workerService.addWorker(worker);
        return new ResponseEntity<Worker>(worker, HttpStatus.OK);
    }


    @RequestMapping(value = "/worker/update", method = RequestMethod.PUT)
    @ApiOperation("Update worker")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Update")})
    public ResponseEntity<Void> updateWorker(@RequestBody Worker worker) {
        workerService.updateWorker(worker);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "worker/{id}", method = RequestMethod.GET)
    @ApiOperation("Get worker by ID")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Worker.class)})
    public ResponseEntity<Worker> getWorkerById(@PathVariable("id") int id) {
        Worker worker = workerService.getWorkerById(id);
        if (worker == null) {
            return new ResponseEntity<Worker>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Worker>(worker, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "worker/leader/{idDep}", method = RequestMethod.GET)
    @ApiOperation("Get leader from department")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    public ResponseEntity<List> getLeader(@PathVariable("idDep") int idDep) {
        List list = workerService.getLeader(idDep);
        return new ResponseEntity<List>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "worker/transfer/{idDep}/dep/{idWorker}", method = RequestMethod.PUT)
    @ApiOperation("Transfer worker")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    public ResponseEntity<Void> transferWorker(@PathVariable("idDep") int idDep, @PathVariable("idWorker") int idWorker) {
        workerService.transferWorker(idDep, idWorker);
        return new ResponseEntity<Void>(HttpStatus.OK);

    }

    @RequestMapping(value = "worker/transferAll/{idOldDep}/dep/{idNewDep}", method = RequestMethod.PUT)
    @ApiOperation("Transfer all worker to another department")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    public ResponseEntity<Void> transferAllWorker(@PathVariable("idOldDep") int idOldDep, @PathVariable("idNewDep") int idNewDep) {
        workerService.transferAllWorkers(idOldDep, idNewDep);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "worker/search/{searchName}", method = RequestMethod.GET)
    @ApiOperation("Find worker by name")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Worker.class)})
    public ResponseEntity<List<Worker>> searchWorker(@PathVariable("searchName") String searchName) {
        List<Worker> worker = workerService.searchWorker(searchName);
        return new ResponseEntity<List<Worker>>(worker, HttpStatus.OK);
    }

    @RequestMapping(value = "workers/{idDep}", method = RequestMethod.GET)
    @ApiOperation("Gets all workers in department")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Worker.class)})
    public ResponseEntity<List> getAllWorker(@PathVariable("idDep") int idDep) {
        List workerList = workerService.getAllWorker(idDep);
        if (workerList.isEmpty()) {
            return new ResponseEntity<List>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List>(workerList, HttpStatus.OK);
        }
    }


    @RequestMapping(value = "department/add", method = RequestMethod.POST)
    @ApiOperation("Add new department")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Department.class)})
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
        return new ResponseEntity<Department>(department, HttpStatus.OK);
    }

    @RequestMapping(value = "department/update{name}/dep/{id}", method = RequestMethod.PUT)
    @ApiOperation("Update department")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    public ResponseEntity<Void> updateDepartment(@PathVariable("name") String name, @PathVariable("id") int id) {
        departmentService.updateDepartment(name, id);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "department/{id}", method = RequestMethod.DELETE)
    @ApiOperation("Delete department")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    public ResponseEntity<Void> deleteDepartment(@PathVariable("id") int id) {
        Department department = departmentService.getDepartmentById(id);
        if (department == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            departmentService.deleteDepartment(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "department/{id}", method = RequestMethod.GET)
    @ApiOperation("Get department by ID")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Department.class)})
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") int id) {
        Department department = departmentService.getDepartmentById(id);
        if (department == null) {
            return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Department>(department, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "department/salary/{id}", method = RequestMethod.GET)
    @ApiOperation("Get salary in department")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Integer.class)})
    public ResponseEntity<Integer> getAllSalaryInDepartment(@PathVariable("id") int id) {
        Integer salary = departmentService.getAllSalaryInDepartment(id);
        return new ResponseEntity<Integer>(salary, HttpStatus.OK);
    }

    @RequestMapping(value = "Maindepartment/add", method = RequestMethod.POST)
    @ApiOperation("Add new Main department")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = MainDepartment.class)})
    public ResponseEntity<MainDepartment> addMainDepartment(@RequestBody MainDepartment mainDepartment) {
        mainDepartmentService.addMainDepartment(mainDepartment);
        return new ResponseEntity<MainDepartment>(mainDepartment, HttpStatus.OK);
    }

    @RequestMapping(value = "mainDepartment/update{name}/dep/{id}", method = RequestMethod.PUT)
    @ApiOperation("Update Main department")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    public ResponseEntity<Void> updateMainDepartment(@PathVariable("name") String name, @PathVariable("id") int id) {
        mainDepartmentService.updateDepartment(name, id);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "mainDepartment/{id}", method = RequestMethod.DELETE)
    @ApiOperation("Delete Main department")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    public ResponseEntity<Void> deleteMainDepartment(@PathVariable("id") int id) {
        List list=mainDepartmentService.getDepartmentById(id);
        if (list.isEmpty()) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            mainDepartmentService.deleteDepartment(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "mainDepartment/{id}", method = RequestMethod.GET)
    @ApiOperation("Get main department by ID")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    public ResponseEntity<List> getMainDepartmentById(@PathVariable("id") int id) {
        List list = mainDepartmentService.getDepartmentById(id);
        return new ResponseEntity<List>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "mainDepartment/id/{id}", method = RequestMethod.GET)
    @ApiOperation("Get department in  main Department")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Integer.class)})
    public ResponseEntity<List> getAllDepartmentInMainDepartment(@PathVariable("id") int id) {
        List list = mainDepartmentService.getAllDepartmentInMainDepartment(id);
        return new ResponseEntity<List>(list, HttpStatus.OK);
    }
}
