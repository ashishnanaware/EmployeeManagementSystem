package com.example.service;

import com.example.entity.Employee;
import com.example.exception.ResourceFoundException;
import com.example.repository.AddressRepository;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeSevice {
    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private AddressRepository addressRepository;

    public Employee createEmployee(Employee employee)  {


        Optional<Employee> emp = repository.findByPhoneOrEmail(employee.getPhone(), employee.getEmail());
        if(emp.isPresent())
            throw new ResourceFoundException("already registered");

        String empid = UUID.randomUUID().toString();
        employee.setId(empid);
        return repository.save(employee);
    }

    public List<Employee> getAll() {
        return repository.findAll();
    }
}
