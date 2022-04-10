package com.example.demo.repository;

import com.example.demo.entity.Employee;
import com.example.demo.impl.service.EmployeeInfrastructureImpl;
import com.example.demo.service.EmployeeInfrastructure;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

    List<Employee> findAllByAge(Integer age);

    List<Employee> findAllByNameAndAge(String name, Integer age);

    @Query(value = "{id: ?0}")
    Employee find(Integer id);
}
