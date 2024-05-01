package com.example.HRManagementSystem.Mappers;

import com.example.HRManagementSystem.DTO.DepartmentDto;
import com.example.HRManagementSystem.DTO.EmployeeDto;
import com.example.HRManagementSystem.Entities.Department;
import com.example.HRManagementSystem.Entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto employeeToDto(Employee employee);

    Employee dtoToEmployee(EmployeeDto dto);

    DepartmentDto departmentToDto(Department department);

    Department dtoToDepartment(DepartmentDto dto);

    List<EmployeeDto> employeeListToDtoList(List<Employee> employees);
}
