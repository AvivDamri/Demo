package com.example.demo.gateway;

import com.example.demo.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LocalHostGateway {

    private final RestTemplate restTemplate;

    @Value("${localhost.path}")
    String path;

    public List<Employee> apiClient() {
        Employee[] employees =  restTemplate.getForObject(path, Employee[].class);
        return Arrays.asList(employees.clone());
    }
}
