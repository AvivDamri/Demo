package com.example.demo.web.controllers;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeDto;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.service.EmployeeInfrastructure;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final EmployeeInfrastructure employeeInfrastructure;
    private final EmployeeMapper employeeMapper;

//    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @PostMapping(value = "/employee", consumes = "application/json")
    public ResponseEntity<Employee> createNewEmployee(@Valid @RequestBody EmployeeDto employee) {
        return ResponseEntity.status(HttpStatus.CREATED).
                body(employeeInfrastructure.createNewEmployee(employeeMapper.mapEmployeeDtoToEmployee(employee)));
    }

    @SneakyThrows
    @GetMapping(value = "/employee/{id}", consumes = "application/json")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeInfrastructure.getEmployeeById(id));
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeInfrastructure.getAllEmployees());
    }

    @SneakyThrows
    @GetMapping("/employee")
    public ResponseEntity<Employee> getEmployee2(@RequestParam Integer id) {
        return ResponseEntity.ok(employeeInfrastructure.getEmployeeById(id));
    }
}
