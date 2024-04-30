package com.example.HRManagementSystem;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Employee}
 */
@Value
public class EmployeeDto implements Serializable {
    Integer id;
    String name;
    String email;
    String address;
    Department department;
}