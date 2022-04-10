package com.example.demo.mapper;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EmployeeMapper {

    public Employee mapEmployeeDtoToEmployee(EmployeeDto employeeDto);
}
