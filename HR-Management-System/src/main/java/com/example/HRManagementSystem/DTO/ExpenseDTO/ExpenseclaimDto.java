package com.example.HRManagementSystem.DTO;

import com.example.HRManagementSystem.Entities.Employee;
import com.example.HRManagementSystem.Entities.Expenseclaim;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link Expenseclaim}
 */
@Value
public class ExpenseclaimDto implements Serializable {
    Integer id;
    LocalDate date;
    String description;
    BigDecimal total;
    String status;
    Employee employee;
}