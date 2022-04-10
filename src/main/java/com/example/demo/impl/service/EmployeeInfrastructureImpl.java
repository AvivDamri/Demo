package com.example.demo.impl.service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.InvalidException;
import com.example.demo.gateway.LocalHostGateway;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeInfrastructure;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeInfrastructureImpl implements EmployeeInfrastructure {

    private final EmployeeRepository employeeRepository;
    private final LocalHostGateway localHostGateway;

    @Override
    public Employee createNewEmployee(Employee employee) {
        employee.setCreatedDate(LocalDate.now());
        return employeeRepository.insert(employee);
    }

    @Override
    public Employee getEmployeeById(Integer id) throws InvalidException {
        Employee employee = employeeRepository.find(id);

        if (employee == null) {
            throw new InvalidException("Employee does not Exist inside th DB");
        }

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return localHostGateway.apiClient();
    }
}
