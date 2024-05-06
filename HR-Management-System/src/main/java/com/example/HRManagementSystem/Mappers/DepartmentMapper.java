package com.example.HRManagementSystem.Mappers;

import com.example.HRManagementSystem.DTO.DepartmentDto;
import com.example.HRManagementSystem.Entities.DepartmentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentDto departmentToDto(DepartmentEntity department);
    DepartmentEntity dtoToDepartment(DepartmentDto dto);
}

