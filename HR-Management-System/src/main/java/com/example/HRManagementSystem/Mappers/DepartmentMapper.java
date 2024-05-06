package com.example.HRManagementSystem.Mappers;

import com.example.HRManagementSystem.DTO.DepartmentDTO.DepartmentDTO;
import com.example.HRManagementSystem.Entities.DepartmentEntity.DepartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    static DepartmentDTO DepartmentEntityToDepartmentDTO(DepartmentEntity entityToGetAll) {
        return null;
    }

    DepartmentDTO EntityToDepartmentDTO(DepartmentEntity cmUserEntity);

    DepartmentDTO EmployeeEntityToDepartmentDTO(DepartmentEntity cmUserEntity);

    DepartmentEntity departmentDTOToCmUserEntity(DepartmentDTO userDTO);
}
