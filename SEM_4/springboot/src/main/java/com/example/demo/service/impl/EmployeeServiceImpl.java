package com.example.demo.service.impl;

import com.example.demo.dto.Employee.EmployeeRequestDto;
import com.example.demo.dto.Employee.EmployeeResponseDto;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeResponseDto> getAllEmployees(String keyword) {
        if (keyword != null && !keyword.trim().isEmpty()) {
            List<Employee> searchResult = employeeRepository.findByNameContainingIgnoreCase(keyword);
            return employeeMapper.toDtoList(searchResult);
        }

        List<Employee> allEmployees = employeeRepository.findAll();
        return employeeMapper.toDtoList(allEmployees);
    }

    @Override
    public void saveEmployee(EmployeeRequestDto requestDto) {
        Employee employee = employeeMapper.toEntity(requestDto);
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeResponseDto getEmployeeById(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()) {
            return employeeMapper.toDto(optional.get());
        }
        throw new RuntimeException("Employee not found for id :: " + id);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        this.employeeRepository.deleteById(id);
    }
}
