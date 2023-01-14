package com.example.employeeapplication1.service;

import com.example.employeeapplication1.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface EmployeeServiceInterface {
    public List<Employee> findAllemployees();
    public Employee AddEmployee( Employee employee);
    public Employee findEmployeeById( Long id);
    public Employee updateEmployee(Long id,  Employee employeeDetails);
    public Map<String,Boolean> deleteEmployee( Long id);
}
