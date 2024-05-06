package com.example.HRManagementSystem.DTO.EmployeeDTO;

import com.example.HRManagementSystem.DTO.DepartmentDTO.DepartmentDTO;
import lombok.Data;
import java.util.List;

@Data
public class EmployeeDTO {

    private int id;
    private String address;
    private String name;
    private String email;
    private Long departmentId;
    private List<DepartmentDTO> departments;

}

