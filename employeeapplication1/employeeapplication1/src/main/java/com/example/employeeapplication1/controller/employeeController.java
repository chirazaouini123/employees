package com.example.employeeapplication1.controller;

import com.example.employeeapplication1.exception.ResourcesNotfoundException;
import com.example.employeeapplication1.model.Employee;
import com.example.employeeapplication1.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")

public class employeeController {
    final EmployeeServiceImpl employeeService;

    @Autowired
    public employeeController(EmployeeServiceImpl employeeService)
    {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllemployees(){
        List<Employee> employees =employeeService.findAllemployees();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee employee1 =employeeService.AddEmployee(employee);
        return new ResponseEntity<>(employee1,HttpStatus.CREATED);

    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee =employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);

    }
    @PutMapping("/employees/{id}")

    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
        Employee e1=employeeService.updateEmployee(id,employeeDetails);
        return   new ResponseEntity<>(e1,HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
        Map<String,Boolean> response=employeeService.deleteEmployee(id);
        return  ResponseEntity.ok(response);
    }


}
