package com.example.HRManagementSystem.Mappers;

import com.example.HRManagementSystem.DTO.EmployeeDTO.EmployeeDTO;
import com.example.HRManagementSystem.Entities.EmployeeEntity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")

public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO EmployeeEntityToEmployeeDTO(EmployeeEntity cmUserEntity);

    EmployeeEntity userDTOToCmUserEntity(EmployeeDTO userDTO);
}


