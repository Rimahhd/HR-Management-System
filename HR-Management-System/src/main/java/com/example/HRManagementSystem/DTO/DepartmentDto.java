package com.example.HRManagementSystem.DTO;

import com.example.HRManagementSystem.Entities.Department;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Department}
 */
@Value
public class DepartmentDto implements Serializable {
    Integer id;
    String name;
}