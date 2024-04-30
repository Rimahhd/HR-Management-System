package com.example.HRManagementSystem;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDto employeeToDto(Employee employee);
    Employee dtoToEmployee(EmployeeDto dto);
}

