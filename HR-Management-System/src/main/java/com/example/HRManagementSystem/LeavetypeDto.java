package com.example.HRManagementSystem;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Leavetype}
 */
@Value
public class LeavetypeDto implements Serializable {
    Integer id;
    String name;
}