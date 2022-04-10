package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class EmployeeDto {

    @Id
    Integer id;

    @NotNull
    @Min(1)
    Integer age;

    @NotNull
    @JsonProperty("employeeName")
    @Pattern(regexp = "^[a-zA-Z]{1,99}$")
    String name;

    String role;

    List<Habit> habits;
}
