package com.example.demo.service;

import com.example.demo.dto.Employee.EmployeeRequestDto;
import com.example.demo.dto.Employee.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDto> getAllEmployees(String request);
    void saveEmployee(EmployeeRequestDto requestDto);
    EmployeeResponseDto getEmployeeById(Long id);
    void deleteEmployeeById(Long id);
}
