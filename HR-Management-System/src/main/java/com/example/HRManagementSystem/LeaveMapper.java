package com.example.HRManagementSystem;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LeaveMapper {
    LeafDto leaveTypeToDto(Leaf leaveType);
    Leaf dtoToLeaveType(LeafDto dto);
}


