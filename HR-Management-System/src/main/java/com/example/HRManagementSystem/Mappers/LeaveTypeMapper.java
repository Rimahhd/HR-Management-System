package com.example.HRManagementSystem.Mappers;

import com.example.HRManagementSystem.DTO.LeavesDTO.LeaveTypeDTO;
import com.example.HRManagementSystem.Entities.LeavesEntities.LeaveTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LeaveTypeMapper {
    LeaveTypeMapper INSTANCE = Mappers.getMapper(LeaveTypeMapper.class);

    LeaveTypeDTO LeaveTypeEntityToLeaveTypeDTO(LeaveTypeEntity cmUserEntity);

    LeaveTypeEntity userDTOToCmUserEntity(LeaveTypeDTO userDTO);
}
