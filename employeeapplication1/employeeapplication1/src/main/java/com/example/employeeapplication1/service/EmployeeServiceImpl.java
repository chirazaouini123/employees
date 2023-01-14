package com.example.employeeapplication1.service;

import com.example.employeeapplication1.exception.ResourcesNotfoundException;
import com.example.employeeapplication1.model.Employee;
import com.example.employeeapplication1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class EmployeeServiceImpl implements EmployeeServiceInterface{
    final EmployeeRepository er;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository er) {
        this.er = er;
    }


    @Override
    public List<Employee> findAllemployees(){
        return er.findAll();
    }


    @Override
    public Employee AddEmployee( Employee employee){
        return er.save(employee);
    }



    @Override
    public Employee findEmployeeById(Long id){
        return er.findById(id).orElseThrow(()-> new ResourcesNotfoundException("Employee doesn't exist with id:"+ id));


    }
    @Override
    public Employee updateEmployee(Long id,  Employee employeeDetails){
        Employee employee1 =er.findById(id).
                orElseThrow(()-> new ResourcesNotfoundException("Employee doesn't exist with id:"+ id));
        employee1.setFirstName(employeeDetails.getFirstName());
        employee1.setLastName(employeeDetails.getLastName());
        employee1.setEmailId(employeeDetails.getEmailId());
        return  er.save(employee1);

    }
    @Override
    public Map<String,Boolean> deleteEmployee(Long id){
        Employee employee=er.findById(id).orElseThrow(()->new ResourcesNotfoundException("Employee doesn't exist with id"+id));
        er.delete(employee);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }



}
