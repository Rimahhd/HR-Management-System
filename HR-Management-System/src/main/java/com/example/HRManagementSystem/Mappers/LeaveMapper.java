package com.example.HRManagementSystem.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.HRManagementSystem.DTO.LeavesDTO.LeaveDTO;
import com.example.HRManagementSystem.Entities.LeavesEntities.LeaveEntity;

@Mapper(componentModel = "spring")
public interface LeaveMapper {
    LeaveMapper INSTANCE = Mappers.getMapper(LeaveMapper.class);

    LeaveDTO LeaveEntityToLeaveDTO(LeaveEntity cmUserEntity);

    LeaveEntity userDTOToCmUserEntity(LeaveDTO userDTO);
}


