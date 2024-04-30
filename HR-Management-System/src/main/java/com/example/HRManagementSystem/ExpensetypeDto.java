package com.example.HRManagementSystem;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Expensetype}
 */
@Value
public class ExpensetypeDto implements Serializable {
    Integer id;
    String name;
}