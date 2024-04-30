package com.example.HRManagementSystem;

import java.util.List;

public interface EmployeeService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);
    List<EmployeeDto> getEmployeesByDepartment(Long departmentId);
}
