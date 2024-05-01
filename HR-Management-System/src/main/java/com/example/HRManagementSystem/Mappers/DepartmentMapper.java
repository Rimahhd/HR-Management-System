package com.example.HRManagementSystem.Mappers;

import com.example.HRManagementSystem.DTO.DepartmentDto;
import com.example.HRManagementSystem.Entities.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentDto departmentToDto(Department department);
    Department dtoToDepartment(DepartmentDto dto);
}

