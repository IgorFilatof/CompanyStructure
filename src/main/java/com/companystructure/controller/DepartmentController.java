package com.companystructure.controller;

import com.companystructure.model.Department;
import com.companystructure.model.Worker;
import com.companystructure.service.DepartmentService.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@Api(value = "DepartmentControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation("Add new department")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Department.class)})
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
        return new ResponseEntity<Department>(department, HttpStatus.OK);
    }

 /*   @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
        departmentService.updateDepartment(department);
        return new ResponseEntity<Department>(department, HttpStatus.CREATED);
    }*/

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteDepartment(@PathVariable("id") int id) {
        Department department = departmentService.getDepartmentById(id);
        if (department == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            departmentService.deleteDepartment(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") int id) {
        Department department = departmentService.getDepartmentById(id);
        if (department == null) {
            return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Department>(department, HttpStatus.OK);
        }
    }
}
