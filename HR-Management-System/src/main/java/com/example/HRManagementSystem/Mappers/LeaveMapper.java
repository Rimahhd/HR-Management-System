package com.example.HRManagementSystem.Mappers;

import com.example.HRManagementSystem.DTO.LeaveDTO;
import com.example.HRManagementSystem.Entities.LeaveEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeaveMapper {
    LeaveDTO leaveTypeToDto(LeaveEntity leaveType);
    LeaveEntity dtoToLeaveType(LeaveDTO dto);
}


