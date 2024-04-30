package com.example.HRManagementSystem;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Leaf}
 */
@Value
public class LeafDto implements Serializable {
    Integer id;
    LeavetypeDto leaveType;
    LocalDate fromDate;
    LocalDate toDate;
    Integer numberOfDays;
    String note;
    Employee employee;
}