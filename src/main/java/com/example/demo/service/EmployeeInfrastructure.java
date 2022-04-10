package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.InvalidException;

import java.util.List;

public interface EmployeeInfrastructure {

    public Employee createNewEmployee(Employee employee);

    public Employee getEmployeeById(Integer id) throws InvalidException;

    public List<Employee> getAllEmployees();
}
