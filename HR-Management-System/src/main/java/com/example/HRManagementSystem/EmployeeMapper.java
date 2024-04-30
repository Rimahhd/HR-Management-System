package com.example.HRManagementSystem;

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
