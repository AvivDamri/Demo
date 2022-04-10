package com.example.demo.mapper;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeDto;
import com.example.demo.entity.Habit;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-09T17:28:56+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee mapEmployeeDtoToEmployee(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeDto.getId() );
        employee.setAge( employeeDto.getAge() );
        employee.setName( employeeDto.getName() );
        employee.setRole( employeeDto.getRole() );
        List<Habit> list = employeeDto.getHabits();
        if ( list != null ) {
            employee.setHabits( new ArrayList<Habit>( list ) );
        }

        return employee;
    }
}
