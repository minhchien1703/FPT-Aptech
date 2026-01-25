package com.example.demo.mapper;

import com.example.demo.dto.Employee.EmployeeRequestDto;
import com.example.demo.dto.Employee.EmployeeResponseDto;
import com.example.demo.entity.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeResponseDto toDto(Employee employee);
    Employee toEntity(EmployeeRequestDto requestDto);
    List<EmployeeResponseDto> toDtoList(List<Employee> employees);
}
