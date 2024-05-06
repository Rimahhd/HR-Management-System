package com.example.HRManagementSystem.DTO.LeavesDTO;

import lombok.Data;

@Data
public class LeaveTypeDTO {
    private int id;
    private String name;

    public String getName() {
        return name;
    }
}
