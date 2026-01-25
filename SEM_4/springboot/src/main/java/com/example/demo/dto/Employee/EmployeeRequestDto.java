package com.example.demo.dto.Employee;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import jakarta.validation.constraints.NotEmpty;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDto {
    private Long id;

    @NotEmpty(message = "Tên không được để trống")
    @Size(min = 2, max = 100, message = "Tên phải từ 2 đến 100 ký tự")
    private String name;

    @NotNull(message = "Tuổi là bắt buộc")
    @Min(value = 18, message = "Tuổi phải từ 18 trở lên")
    private Integer age;

    @NotNull(message = "Lương là bắt buộc")
    @Min(value = 0, message = "Lương không được âm")
    private Double salary;
}
