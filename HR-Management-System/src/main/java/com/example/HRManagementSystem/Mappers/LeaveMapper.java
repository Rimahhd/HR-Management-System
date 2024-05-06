package com.example.HRManagementSystem.Mappers;

import com.example.HRManagementSystem.DTO.LeaveDTO;
import com.example.HRManagementSystem.Entities.Leaf;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeaveMapper {
    LeaveDTO leaveTypeToDto(Leaf leaveType);
    Leaf dtoToLeaveType(LeaveDTO dto);
}


