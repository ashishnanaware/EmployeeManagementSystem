package com.example.controller;

import com.example.entity.Employee;
import com.example.service.EmployeeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeSevice sevice;
    @PostMapping
    public ResponseEntity<Employee> createEmp(@RequestBody Employee employee) {
        return new ResponseEntity<>(sevice.createEmployee(employee), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmp(){
        return new ResponseEntity<>(sevice.getAll(), HttpStatus.CREATED);
    }

}
