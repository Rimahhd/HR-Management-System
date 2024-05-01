package com.example.HRManagementSystem.Services;

import com.example.HRManagementSystem.DTO.DepartmentDto;
import com.example.HRManagementSystem.DTO.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);
    List<EmployeeDto> getEmployeesByDepartment(Long departmentId);
}
