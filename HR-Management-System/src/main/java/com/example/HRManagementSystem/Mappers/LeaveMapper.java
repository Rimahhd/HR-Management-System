package com.example.HRManagementSystem.Mappers;

import com.example.HRManagementSystem.DTO.LeafDto;
import com.example.HRManagementSystem.Entities.Leaf;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LeaveMapper {
    LeafDto leaveTypeToDto(Leaf leaveType);
    Leaf dtoToLeaveType(LeafDto dto);
}


