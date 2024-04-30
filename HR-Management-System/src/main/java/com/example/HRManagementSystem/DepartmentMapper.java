package com.example.HRManagementSystem;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentDto departmentToDto(Department department);
    Department dtoToDepartment(DepartmentDto dto);
}

