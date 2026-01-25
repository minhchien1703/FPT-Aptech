package com.example.demo.dto.Employee;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeResponseDto {
    private Long id;

    private String name;

    private Integer age;

    private Double salary;
}
